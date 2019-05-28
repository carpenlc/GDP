package mil.nga.gdp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mil.nga.PropertyLoader;

import mil.nga.gdp.exceptions.PropertiesNotLoadedException;
import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.OperationFactory.OperationFactoryHolder;
import mil.nga.gdp.util.URIUtils;

/**
 * Session Bean implementation class RequestArchiveService
 * 
 * This class is mainly for debugging purposes.  As input it takes a 
 * BundlerRequest object and the job ID assigned to that request and
 * marshals the data in JSON format to an on disk file.  
 * 
 * @author L. Craig Carpenter
 */
public class RequestArchiveService 
        extends PropertyLoader 
        implements GDPConstantsI {
    
    /**
     * Set up the LogBack system for use throughout the class
     */        
    private static final Logger LOGGER = LoggerFactory.getLogger(
            RequestArchiveService.class);
    
    /**
     * Default date format added to generated job IDs.
     */
    private static final String FILENAME_DATE_FORMAT = "yyyyMMdd-HH:mm:ss:SSS";
    private static final DateFormat filenameDF = 
    		new SimpleDateFormat(FILENAME_DATE_FORMAT);
    /**
     * Date format used to generate timestamp added to output archive files.
     */
    private static final String MESSAGE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final DateFormat messageDF = 
    		new SimpleDateFormat(MESSAGE_DATE_FORMAT);
    		
    /**
     * Filename extension to add to the output JSON file.
     */
    private static final String EXTENSION = ".req";
    
    /**
     * String to prepend to the front of generated job IDs. 
     */
    private static final String DEFAULT_JOB_ID = "UNAVAILABLE";
    
    /**
     * Platform-specific new line character
     */
    private static final String NEW_LINE = System.getProperty("line.seperator");
    
    /**
     * Calculated path in which the request data will be stored.
     */
    private URI outputPath = null;
    
    /**
     * Flag determining whether or not we should enable the functionality.
     */
    private boolean enabled = true;
    
    /**
     * Default constructor. 
     */
    protected RequestArchiveService() { 
        super(PROPERTY_FILE_NAME);
        try {
            setEnabled(getProperty(ARCHIVE_REQUEST_PROP));
            setOutputPath(getProperty(REQUEST_DIRECTORY_PROP));
            checkOutputPath();
        }
        catch (PropertiesNotLoadedException pnle) {
            LOGGER.warn("An unexpected PropertiesNotLoadedException " 
                    + "was encountered.  Please ensure the application "
                    + "is properly configured.  Exception message [ "
                    + pnle.getMessage()
                    + " ].");
            setEnabled(false);
        }
    }

    /**
     * Ensure that the output path exists.
     */
    private void checkOutputPath() {

        if (getOutputPath() != null) {
            Path p = Paths.get(getOutputPath());
            if (!Files.exists(p)) {
                try {
                    Files.createDirectory(p);
                }
                catch (IOException ioe) {
                    LOGGER.error("System property [ "
                            + REQUEST_DIRECTORY_PROP
                            + " ] is set to directory [ "
                            + getOutputPath().toString()
                            + " ] but the directory does not exist and "
                            + "cannot be created.  Exception message => [ "
                            + ioe.getMessage()
                            + " ].");
                    outputPath = null;
                }
            }
        }
        else {
            LOGGER.info("Request archive service is disabled.");
        }
    }
    
    /**
     * If the job ID is not supplied we'll still export the request data but
     * the job ID will be generated from the current system time.
     * 
     * @return A default job ID.
     */
    private String generateBogusJobID() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(DEFAULT_JOB_ID);
        sb.append("_");
        sb.append(filenameDF.format(
        		System.currentTimeMillis()));
        
        return sb.toString();
    }
    
    /**
     * Method to assemble the full path to the target output file.
     * 
     * @param jobID The "main" part of the filename.
     * @return The full path to the target output file.
     */
    private URI getFilePath(String jobID) {
        
        StringBuilder sb = new StringBuilder();
        
        if (getOutputPath() != null) {
            sb.append(getOutputPath().toString());
            if (!sb.toString().endsWith(File.separator)) {
                sb.append(File.separator);
            }
        }
        else {
            LOGGER.warn("Output path is not defined!");
        }
        sb.append(jobID.trim());
        sb.append(EXTENSION);
        return URIUtils.getInstance().getURI(sb.toString());
    }
    
    /**
     * Save the input String containing pretty-printed JSON data to an output 
     * file.  The output file path is calculated using the input jobID.
     * 
     * @param request The "pretty-printed" JSON data.
     * @param jobID The job ID (used to calculate the output file name)
     */
    private void saveToFile(String request, String jobID) {
        
        URI outputFile = getFilePath(jobID);
        
        if ((request != null) && (!request.isEmpty())) {
            
            LOGGER.info("Saving request information for job ID [ "
                        + jobID 
                        + " ] in file name [ "
                        + outputFile.toString()
                        + " ].");
            
            Path p = Paths.get(outputFile);
            try (BufferedWriter writer = 
                    Files.newBufferedWriter(p, Charset.forName("UTF-8"))) {
                writer.write(request);
                writer.flush();
            }
            catch (IOException ioe) {
                LOGGER.error("Unexpected IOException encountered while " 
                        + "attempting to archive the request associated with "
                        + "job ID [ "
                        + jobID 
                        + " ] in filename [ "
                        + outputFile.toString()
                        + " ].  Error message [ "
                        + ioe.getMessage()
                        + " ].");
            }
        }
        else {
            LOGGER.warn("Unable to marshal the request data associated with "
                    + "job ID [ "
                    + jobID 
                    + " ].  The output String is null or empty.");
        }
    }
    
    /**
     * Method used to determine whether or not the request archive 
     * functionality is enabled. 
     * 
     * @return True if we should save incoming requests, false otherwise.
     */
    public boolean isEnabled() {
        return enabled;
    }
    
    /**
     * External interface used to marshal a BundleRequestMessage into a JSON-based
     * String and then store the results in an on-disk file.
     * 
     * @param request Incoming BundleRequestMessage object.
     * @param jobID The job ID assigned to input BundleRequestMessage object.
     */
    public void archiveRequest(Map<String, String> request, String requestID) {
        if ((getOutputPath() != null) && (isEnabled())) {
            if ((request != null) && (request.size() > 0)) {
                if ((requestID == null) || (requestID.isEmpty())) {
                	requestID = generateBogusJobID();
                    LOGGER.warn("The input request ID is null or not populated.  "
                            + "Using generated job ID [ "
                            + requestID
                            + " ].");
                }
                
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Archiving incoming request for job ID [ "
                            + requestID
                            + " ].");
                }
    
                StringBuilder requestData = new StringBuilder();
                
                requestData.append("## Request ID [ ");
                requestData.append(requestID);
                requestData.append(" ] received at [ ");
                requestData.append(messageDF.format(
                		System.currentTimeMillis()));
                requestData.append(" ] ##");
                requestData.append(NEW_LINE);
                
                for (String key : request.keySet()) {
                	requestData.append("key => [ ");
                	requestData.append(key);
                	requestData.append(" ], value => [ ");
                	requestData.append(request.get(key));
                	requestData.append(" ].");
                	requestData.append(NEW_LINE);
                }
                
                saveToFile(requestData.toString(), requestID);
                    
            }
            else {
                LOGGER.error("The input request is null or contains no "
                		+ "key/value pairs.  Request will not be archived.");
            }
        }
        else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Request archive feature is disabled.");
            }
        }
    }
    
    /**
     * Getter method for the target output path.
     * 
     * @return The location to use for storing the incoming request.
     */
    private URI getOutputPath() {
        return outputPath;
    }
    
    /**
     * Setter method for the enabled flag.
     * @param value The value of the <code>ARCHIVE_BUNDLE_REQUEST_PROP</code>
     * property.
     */
    private void setEnabled(String value) {
        if ((value != null) && (!value.isEmpty())) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Request archive feature is disabled by value "
                        + "of property [ "
                        + ARCHIVE_BUNDLE_REQUEST_PROP
                        + " ].");
            }
            enabled = false;
        }
        else {
            enabled = true;
        }
    }
    
    /**
     * Setter method for the output path.  
     * 
     * @param dir Location for storing the output data.
     */
    private void setOutputPath(String dir) {
        if ((dir != null) && (!dir.isEmpty())) { 
            outputPath = URIUtils.getInstance().getURI(dir);
            if (outputPath != null) {
                LOGGER.info("Incoming requests will be archived to [ "
                        + outputPath.toString()
                        + " ].");
            }
            else {
                LOGGER.error("System property [ "
                        + BUNDLE_REQUEST_DIRECTORY_PROP 
                        + " ] is set to [ "
                        + dir 
                        + " ] which cannot be converted to a URI.  "
                        + "Incoming requests will not be archived.");
            }    
        }
        else {
            LOGGER.warn("Output path specified by system property [ "
                    + BUNDLE_REQUEST_DIRECTORY_PROP
                    + " ] is null or empty.  Request archive service "
                    + "is disabled.");
        }
    }
    
	/**
	 * Accessor method for the Singleton instance of the RequestArchiveService 
	 * object.
	 * @return The singleton RequestArchiveService object.
	 */
	public static RequestArchiveService getInstance() { 
		return RequestArchiveServiceHolder.getSingleton();
	}
	
	/**
	 * Static inner class used to construct the Singleton object.  This class
	 * exploits the fact that classes are not loaded until they are referenced
	 * therefore enforcing thread safety without the performance hit imposed
	 * by the <code>synchronized</code> keyword.
	 * 
	 * @author L. Craig Carpenter
	 */
	public static class RequestArchiveServiceHolder {
		
		/**
		 * Reference to the Singleton instance of the OperationFactory
		 */
		private static RequestArchiveService _instance = new RequestArchiveService();
	
		/**
		 * Accessor method for the singleton instance of the <code>OperationFactory</code>.
		 * @return The Singleton instance of the <code>OperationFactory</code>.
		 */
	    public static RequestArchiveService getSingleton() {
	    	return _instance;
	    }
	    
	}
}
