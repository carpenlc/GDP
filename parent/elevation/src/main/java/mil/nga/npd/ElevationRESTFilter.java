package mil.nga.npd;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.elevation.ObjectFactory;
import mil.nga.elevation.GetElevationAt;
import mil.nga.elevation.GetElevationAtResponse;
import mil.nga.elevation.GetMinMaxElevations;
import mil.nga.elevation.GetMinMaxElevationsResponse;
import mil.nga.elevation.GetMinMaxElevationsWKT;
import mil.nga.elevation.GetMinMaxElevationsWKTResponse;
import mil.nga.npd.exceptions.InternalServerErrorException;
import mil.nga.npd.exceptions.InvalidParameterException;
import mil.nga.npd.types.ElevationOperationType;
import mil.nga.npd.types.OutputFormatType;
import mil.nga.npd.utils.TypeConverter;
import mil.nga.security.SecurityElement;
import us.gov.ic.ism.v2.ClassificationType;

/**
 * The purpose of this class is to translate input GET parameters into 
 * the objects required to call the JAX-WS methods that actually 
 * perform the coordinate parsing.  This functionality was bolt-on
 * after the original bottom-up development that started with the 
 * WSDL.  Further, this class decoupled the parameter parsing logic 
 * from the servlet class to facilitate the development of 
 * jUnit tests.
 * 
 * This filter is a little bit strange.  We mimic the legacy implementation
 * which accepts command-line parameters in one of two ways.  First, is 
 * the standard mechanism which are a list of individual parameters.  
 * Second, is one parameter that points to a JSON string (which, unfortunately,
 * we cannot serialize/deserialize with JAX-B.)  
 * 
 * Due to the amount of logic required to parse the input parameters the 
 * parsing was offloaded to a separate class @see QueryStringParser
 * 
 * @author L. Craig Carpenter
 */
public class ElevationRESTFilter extends RESTFilter {
    
	/**
     * Set up the Logback system for use throughout the class.
     */
    private static final Logger LOGGER = 
            LoggerFactory.getLogger(ElevationRESTFilter.class);
	
    /**
     * Parameter containing the units to use for the output data.
     */
    public static final String REQUESTED_UNITS_PARAM = "heightType";
    
    /**
     * Parameter containing the source DEM requested.
     */
    public static final String SOURCE_DATA_PARAM = "terrainDataType";
    
    /**
     * Parameter containing a list of points in lon, lat order.
     */
    public static final String POINTS_PARAM = "pts";
    
    /**
     * Parameter containing a Well-Known Text (WKT) String
     */
    public static final String WKT_PARAM = "wkt";
    
    /**
     * Parameter containing a list of points that define a bounding box.
     */
    public static final String BOUNDING_BOX_PARAM = "bbox";
    
    /**
     * Parameter containing the latitude value
     */
    public static final String LATITUDE_PARAM = "lat";
    
    /**
     * Parameter containing the longitude value
     */
    public static final String LONGITUDE_PARAM = "lon";
    
    /**
     * Parameter containing the lower-left latitude value of a bounding box.
     */
    public static final String LOWER_LEFT_LATITUDE_PARAM = "lllat";
    
    /**
     * Parameter containing the lower-left longitude value of a bounding box.
     */
    public static final String LOWER_LEFT_LONGITUDE_PARAM = "lllon";
    
    /**
     * Parameter containing the upper-right latitude value of a bounding box.
     */
    public static final String UPPER_RIGHT_LATITUDE_PARAM = "urlat";
    
    /**
     * Parameter containing the upper-right longitude value of a bounding box.
     */
    public static final String UPPER_RIGHT_LONGITUDE_PARAM = "urlon";
    
    /**
     * OperationType to execute.
     */
    private final ElevationOperationType operation;

    /**
     * Child class used to parse the input parameters.
     */
    private final QueryStringParser parser;
    
    /**
     * Default object embedded in all of the calls to the JAX-WS methods.
     */
    private SecurityElement defaultSecElement;
    
    /**
     * Default constructor enforcing the builder creation pattern.
     * 
     * @param builder The builder object.
     */
    protected ElevationRESTFilter(ElevationRESTFilterBuilder builder) {
        super(builder.outputFormat, builder.params);
        
        parser    = builder.parser;
        operation = parser.getOperation();
        
        // Set up the SecurityElement
        defaultSecElement = new SecurityElement();
        defaultSecElement.setClassification(ClassificationType.U);
        defaultSecElement.getOwnerProducer().add("USA");
    }
    
    /**
     * Public facing method that executes the requested operation.
     * 
     * @return String representation of the results of the requested 
     * operation.
     * @throws InvalidParameterException Thrown if there are problems with
     * the input parameters.
     */
    public String translate() 
            throws InternalServerErrorException, 
                   InvalidParameterException {
        switch(operation) {
	        case GET_ELEVATION_AT:
	        	return executeGetElevationAt();
	        case GET_MIN_MAX_ELEVATIONS:
	        	return executeGetMinMaxElevations();
	        case GET_MIN_MAX_ELEVATIONS_WKT:
	        	return executeGetMinMaxElevationsWKT();
            default:
                throw new InvalidParameterException(
                        "Invalid operation. See WSDL for valid operations.");
        }
    }
    
    /**
     * This method maps the input GET request parameters to the WSDL-generated
     * object types and makes the call to the SOAP-based implementation classes
     * returning the results as a marshalled String.  This method maps the 
     * parameters for operation <code>GetElevationAt</code>.
     * 
     * @return The response as a marshalled string (XML or JSON depending on 
     * what the client requested.
     */
    public String executeGetElevationAt() 
    		throws InternalServerErrorException, InvalidParameterException {
    	
    	String         result = null;
    	StringWriter   sw     = null;
    	GetElevationAt input  = new GetElevationAt();
    	
    	input.setSecurity(defaultSecElement);
    	input.setTerrainDataType(parser.getSource());
    	input.setHeightType(parser.getUnits());
    	
    	List<GeodeticCoordinate> points = parser.getPoints();
    	
    	// There should be no chance of an NPE here, but we're going to check
    	// anyway.
    	if ((points != null) && (points.size() > 0)) {
	    	for (GeodeticCoordinate point : points) {
	    		input.getPts().add(TypeConverter.convert(point));
	    	}
    	}
    	else {
    		LOGGER.error("List of points is null or "
    				+ "contains no elements.  Unable to service request.");
    		throw new InvalidParameterException("List of points is null or "
    				+ "contains no elements.  Unable to service request.");
    	}

    	GetElevationAtResponse response = new ElevationService()
    			.getElevationAt(input);
    	
    	if (response != null) {
    		
	    	// Marshall the return object to a JSON 
	    	try {
		        
	    		// Because we are using JAX-WS generated object classes, they 
		        // don't have a XmlRootElement tag.  That means you cannot directly
		        // marshal the response from the target service, you must use the 
		        // helper classes that were also generated by JAX-WS.
		        ObjectFactory objFactory = new mil.nga.elevation.ObjectFactory();
		        JAXBElement<GetElevationAtResponse> jaxbResp = 
		                objFactory.createGetElevationAtResponse(response);
		        JAXBContext context = JAXBContext.newInstance(
		                "mil.nga.elevation");
		        Marshaller marshaller = context.createMarshaller();
		        if (getOutputFormat() == OutputFormatType.JSON) {
		            marshaller.setProperty(
		                    MarshallerProperties.MEDIA_TYPE, 
		                    MediaType.APPLICATION_JSON);
		        }
		        sw = new StringWriter();
		        marshaller.marshal(jaxbResp, sw);
		        
		        // Return the marshalled String
		        result = sw.toString();
	    	}
	        catch (JAXBException jbe) {
	            LOGGER.error("Unexpected JAXBException raised while marshalling "
	                    + "the output object.  Exception message => [ "
	                    + jbe.getMessage()
	                    + " ].");
	            throw new InternalServerErrorException(
	                    "Unexpected JAXBException raised while marshalling "
	                    + "the output object.  Exception message => [ "
	                    + jbe.getMessage()
	                    + " ].");
	        }
	    	finally {
	    		if (sw != null) {
	    			try { sw.close(); } catch (Exception e) {}
	    		}
	    	}
    	}
    	else {
    		LOGGER.error("Response received from call to "
    				+ "ElevationService.getElevationAt() is null.");
    		throw new InternalServerErrorException(
    				"Unable to generate a valid response for the input "
    				+ "request.  Please see application log files for "
    				+ "more information.");
    	}
    	return result;
    }
    
    /**
     * This method maps the input GET request parameters to the WSDL-generated
     * object types and makes the call to the SOAP-based implementation classes
     * returning the results as a marshalled String.  This method maps the 
     * parameters for operation <code>GetMinMaxElevations</code>.
     * 
     * @return The response as a marshalled string (XML or JSON depending on 
     * what the client requested.
     */
    public String executeGetMinMaxElevations() 
    		throws InternalServerErrorException, InvalidParameterException {
    	
    	String              result = null;
    	StringWriter        sw     = null;
    	GetMinMaxElevations input  = new GetMinMaxElevations();
    	
    	input.setSecurity(defaultSecElement);
    	input.setTerrainDataType(parser.getSource());
    	input.setHeightType(parser.getUnits());
    	input.setBbox(TypeConverter.convert(parser.getBoundingBox()));
    	
    	GetMinMaxElevationsResponse response = 
    			new ElevationService().getMinMaxElevations(input);

    	if (response != null) {
    		
	    	// Marshall the return object to a JSON 
	    	try {
		        
	    		// Because we are using JAX-WS generated object classes, they 
		        // don't have a XmlRootElement tag.  That means you cannot directly
		        // marshal the response from the target service, you must use the 
		        // helper classes that were also generated by JAX-WS.
		        ObjectFactory objFactory = new mil.nga.elevation.ObjectFactory();
		        JAXBElement<GetMinMaxElevationsResponse> jaxbResp = 
		                objFactory.createGetMinMaxElevationsResponse(response);
		        JAXBContext context = JAXBContext.newInstance(
		                "mil.nga.elevation");
		        Marshaller marshaller = context.createMarshaller();
		        if (getOutputFormat() == OutputFormatType.JSON) {
		            marshaller.setProperty(
		                    MarshallerProperties.MEDIA_TYPE, 
		                    MediaType.APPLICATION_JSON);
		        }
		        sw = new StringWriter();
		        marshaller.marshal(jaxbResp, sw);
		        
		        // Return the marshalled String
		        result = sw.toString();
	    	}
	        catch (JAXBException jbe) {
	            LOGGER.error("Unexpected JAXBException raised while marshalling "
	                    + "the output object.  Exception message => [ "
	                    + jbe.getMessage()
	                    + " ].");
	            throw new InternalServerErrorException(
	                    "Unexpected JAXBException raised while marshalling "
	                    + "the output object.  Exception message => [ "
	                    + jbe.getMessage()
	                    + " ].");
	        }
	    	finally {
	    		if (sw != null) {
	    			try { sw.close(); } catch (Exception e) {}
	    		}
	    	}
    	}
    	else {
    		LOGGER.error("Response received from call to "
    				+ "ElevationService.getMinMaxElevations() is null.");
    		throw new InternalServerErrorException(
    				"Unable to generate a valid response for the input "
    				+ "request.  Please see application log files for "
    				+ "more information.");
    	}
    	return result;
    }
    
    /**
     * This method maps the input GET request parameters to the WSDL-generated
     * object types and makes the call to the SOAP-based implementation classes
     * returning the results as a marshalled String.  This method maps the 
     * parameters for operation <code>GetMinMaxElevationsWKT</code>.
     * 
     * @return The response as a marshalled string (XML or JSON depending on 
     * what the client requested.
     */
    public String executeGetMinMaxElevationsWKT() 
    		throws InternalServerErrorException, InvalidParameterException {
    	
       	String                 result = null;
    	StringWriter           sw     = null;
    	GetMinMaxElevationsWKT input  = new GetMinMaxElevationsWKT();
    	
    	input.setSecurity(defaultSecElement);
    	input.setTerrainDataType(parser.getSource());
    	input.setHeightType(parser.getUnits());
    	input.setWkt(parser.getWKTString());
    	
    	GetMinMaxElevationsWKTResponse response = 
    			new ElevationService().getMinMaxElevationsWKT(input);

    	if (response != null) {
    		
	    	// Marshall the return object to a JSON 
	    	try {
		        
	    		// Because we are using JAX-WS generated object classes, they 
		        // don't have a XmlRootElement tag.  That means you cannot directly
		        // marshal the response from the target service, you must use the 
		        // helper classes that were also generated by JAX-WS.
		        ObjectFactory objFactory = new mil.nga.elevation.ObjectFactory();
		        JAXBElement<GetMinMaxElevationsWKTResponse> jaxbResp = 
		                objFactory.createGetMinMaxElevationsWKTResponse(response);
		        JAXBContext context = JAXBContext.newInstance(
		                "mil.nga.elevation");
		        Marshaller marshaller = context.createMarshaller();
		        if (getOutputFormat() == OutputFormatType.JSON) {
		            marshaller.setProperty(
		                    MarshallerProperties.MEDIA_TYPE, 
		                    MediaType.APPLICATION_JSON);
		        }
		        sw = new StringWriter();
		        marshaller.marshal(jaxbResp, sw);
		        
		        // Return the marshalled String
		        result = sw.toString();
	    	}
	        catch (JAXBException jbe) {
	            LOGGER.error("Unexpected JAXBException raised while marshalling "
	                    + "the output object.  Exception message => [ "
	                    + jbe.getMessage()
	                    + " ].");
	            throw new InternalServerErrorException(
	                    "Unexpected JAXBException raised while marshalling "
	                    + "the output object.  Exception message => [ "
	                    + jbe.getMessage()
	                    + " ].");
	        }
	    	finally {
	    		if (sw != null) {
	    			try { sw.close(); } catch (Exception e) {}
	    		}
	    	}
    	}
    	else {
    		LOGGER.error("Response received from call to "
    				+ "ElevationService.GetMinMaxElevationsWKT() is null.");
    		throw new InternalServerErrorException(
    				"Unable to generate a valid response for the input "
    				+ "request.  Please see application log files for "
    				+ "more information.");
    	}
    	return result;
    }
    
    /**
     * Static inner class implementing the builder creation pattern for 
     * objects of type ElevationRESTFilterBuilder.
     * 
     * @author L. Craig Carpenter
     */
    public static class ElevationRESTFilterBuilder {
        
        private Map<String, Object> params;
        private OutputFormatType    outputFormat; // Required for superclass
        private QueryStringParser   parser;
        
        /**
         * Setter method for the parameter map.  The map should be a key/value
         * pair map containing the input GET parameters.
         * 
         * @param value The input <code>Map</code> object containing the 
         * input GET parameters.
         * @return A reference to the builder object.
         */
        public ElevationRESTFilterBuilder withParameterMap(Map<String, Object> value) {
            params = value;
            return this;
        }
        
        /**
         * Extract the requested output format from input parameters.
         * 
         * @return The OutputFormatType object extracted from the input 
         * parameters.
         * @throws InvalidParameterException Thrown if the operation was 
         * not supplied, or it could not be translated to a supported 
         * operation.
         */
        private OutputFormatType getOutputFormat() throws InvalidParameterException {
            return OutputFormatType.fromString(
                    getParameter(
                            params, 
                            OUTPUT_FORMAT_PARAM));
        }
        
        /**
         * Create an instance of the RESTFilter object.
         * 
         * @return A constructed RESTFilter object.
         * @throws InvalidParameterException Thrown if there are problems parsing
         * the input parameters.
         */
        public ElevationRESTFilter build() throws InvalidParameterException {
            if ((params == null) || (params.size() == 0)) {
                throw new InvalidParameterException("Input parameter map is null "
                        + "or empty.  Unable to parse the input parameters.");
            }
            parser = new QueryStringParser.QueryStringParserBuilder()
            		.withParams(params)
            		.build();
            parser.parse();
            outputFormat = getOutputFormat();
            return new ElevationRESTFilter(this);
        }
    }
}
