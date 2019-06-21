package mil.nga.npd;

import java.util.Map;

import mil.nga.npd.exceptions.InvalidParameterException;
import mil.nga.npd.types.OutputFormatType;

/**
 * Abstract class used to segregate out methods that are common to the
 * GET input parameter processing associated with the various GDP web 
 * services.
 * 
 * @author L. Craig Carpenter
 */
public abstract class RESTFilter {

    /**
     * Parameter used to specify the output format.  This is case-sensitive.
     */
    public static final String OUTPUT_FORMAT_PARAM = "outputFormat";
    
    /**
     * Parameter used to specify the operation.  This is case-sensitive.
     */
    public static final String OPERATION_PARAM = "operation";
    
    /**
     * Parameter used when the input data is embedded in a JSON string.
     */
    public static final String PARAMETER_PARAM = "parameters";
    
    private OutputFormatType    outputFormat;
    private Map<String, Object> params;
    
    /**
     * Default constructor requiring clients to supply initial values for the 
     * <code>OutputFormat</code> and input parameter map.
     * 
     * @param outputFormat The user-requested output format.
     * @param inParams The input parameter list.
     */
    public RESTFilter(OutputFormatType outputFormat, Map<String, Object> inParams) {
    	this.outputFormat = outputFormat;
    	params            = inParams;
    }
    
    /**
     * During testing we found that *some* of the parameters  extracted
     * from the servlet parameter map were arrays of strings vs simple
     * String values.  This method was introduced to handle that case.
     * 
     * @param map The input parameter map from the servlet.
     * @param name The name of the requested parameter.
     * @return The requested value.  Null if the value is not found.
     * @throws InvalidParameterException Thrown if an unexpected type is 
     * encountered.
     */
    protected static String getParameter(
            Map<String, Object> 
            map, String name) throws InvalidParameterException {
        String value = null;
        if (map.get(name) instanceof String) {
            value = (String)map.get(name);
        }
        else if (map.get(name) instanceof String[]) {
            String[] temp = (String[])map.get(name);
            if (temp.length > 0) {
                value = temp[0];
            }
        }
        else {
            if (map.get(name) != null) {
                throw new InvalidParameterException("Map value for key [ "
                        + name
                        + " ] is of an unexpected object type. Object is of "
                        + "type => [ "
                        + map.get(name).getClass().getName()
                        + " ].");
            }
        }
        return value;
    }
    
    /**
     * Getter method for the <code>Map</code> containing the input parameters.
     * @return The input parameters.
     */
    public Map<String, Object> getInputParams() {
    	return params;
    }
    
    /**
     * Getter method for the requested output format.
     * @return The output format.
     */
    public OutputFormatType getOutputFormat() {
        return outputFormat;
    }
    
    /**
     * Getter method that creates the media type from the output format
     * type.  Used to control whether we output JSON or XML.
     * @return The media type String.
     */
    public String getMediaType() {
        String mediaType = "text/plain";
        switch (getOutputFormat()) {
            case XML:
                mediaType = "application/xml";
                break;
            case JSON:
                mediaType = "application/json";
                break;
            case KML:
                mediaType = "application/kml";   
                break;
        }
        return mediaType;
    }
}
