package mil.nga.npd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.elevation.HeightUnitType;
import mil.nga.elevation.TerrainDataType;
import mil.nga.npd.exceptions.InvalidParameterException;
import mil.nga.npd.types.ElevationOperationType;

/**
 * Segregated the parsing of the query String for the elevation services out 
 * into a separate class.  In order to maintain backwards compatibility with 
 * the older elevation services classes we had to handle an unusual mechanism
 * in which the query String can be submitted in the normal format (a list of 
 * parameters) or a JSON string attached to a parameter called 
 * <code>parameters</code>.
 * 
 * @author L. Craig Carpenter
 */
public class QueryStringParser {

    /**
     * Set up the Logback system for use throughout the class.
     */
    private static final Logger LOGGER = 
            LoggerFactory.getLogger(QueryStringParser.class);
    
    private final Map<String, Object> params;
    private ElevationOperationType    operation;
    private HeightUnitType            units;
    private TerrainDataType           source;
    private List<GeodeticCoordinate>  points;
    private BoundingBox               bBox;
	private String                    wktString;
	
    /**
	 * Default no-arg constructor.
	 */
	protected QueryStringParser(QueryStringParserBuilder builder) {
		params = builder.params;
	}
	
	/**
	 * Accessor method for the requested bounding box.
	 * @return The bounding box.
	 */
	public BoundingBox getBoundingBox() {
		return bBox;
	}
	
	/**
	 * Accessor method for the input query String parameters.  This 
	 * method is used to validate the QueryStringParser object prior
	 * to allowing the parsing to proceed. 
	 * 
	 * @return A reference to the <code>Map</code> containing the 
	 * input query String parameters.
	 */
	protected Map<String, Object> getInputParams() {
		return params;
	}
	
	/**
	 * Accessor method for the operation type.
	 * @return The operation type.
	 */
	public ElevationOperationType getOperation() {
		return operation;
	}
	
	/**
	 * Accessor method for the list of points requested by the caller.
	 * @return The list of points requested.
	 */
	public List<GeodeticCoordinate> getPoints() {
		return points;
	}
	
	/**
	 * Accessor method for the output units.
	 * @return The output units.
	 */
	public HeightUnitType getUnits() {
		return units;
	}
	
	/**
	 * Accessor method for the requested data source.
	 * @return The data source.
	 */
	public TerrainDataType getSource() {
		return source;
	}
	
	/**
	 * Accessor method for the WKT String value.
	 * @return The parsed WKT String value.
	 */
	public String getWKTString() {
		return wktString;
	}
	
	/**
	 * Method to parse a bounding box from an input parameter.  The bounding box
	 * should be in lower-left LON, lower-left LAT, upper-right LON, 
	 * upper-right LAT order.  The input list will be converted to an object 
	 * of type <code>BoundingBox</code>.
	 * 
	 * @param points Input String containing the bounding box.
	 * @throws InvalidParameterException Thrown if the bounding box cannot be 
	 * parsed.
	 */
	protected void parseBoundingBox(String strBBOX) throws InvalidParameterException {
		
		if ((strBBOX == null) || (strBBOX.isEmpty())) {
			throw new InvalidParameterException(
					"Input bounding box must be defined in bbox parameters [ "
					+ "lllon, lllat, urlon, urlat ].");
		}
		
		String [] ptsArray = strBBOX.split(",");
		if (ptsArray.length != 4) {
            throw new InvalidParameterException(
            		"Incomplete point list => [ "
            		+ strBBOX
            		+ " ].  Input bounding box must have exactly 4 points.");
		}
		try {
			bBox = new BoundingBox.BoundingBoxBuilder()
					.lowerLeft(
							new GeodeticCoordinate.GeodeticCoordinateBuilder()
								.lat(ptsArray[1])
								.lon(ptsArray[0])
								.build())
					.upperRight(
							new GeodeticCoordinate.GeodeticCoordinateBuilder()
								.lat(ptsArray[3])
								.lon(ptsArray[2])
								.build())
					.build();
		}
		catch (IllegalStateException ise) {
			LOGGER.error("Unable to parse the bounding box from input [ "
					+ ElevationRESTFilter.BOUNDING_BOX_PARAM
					+ " ] parameter, value [ "
					+ strBBOX
					+ " ].  Error message => [ "
					+ ise.getMessage()
					+ " ].");
        	throw new InvalidParameterException(
        			"Unable to parse the bounding box from input [ "
					+ ElevationRESTFilter.BOUNDING_BOX_PARAM
					+ " ] parameter, value [ "
					+ strBBOX
					+ " ].  Error message => [ "
					+ ise.getMessage()
					+ " ].");
		}
	}
	
	/**
	 * Parse the input WKT text string.
	 * 
	 * @param strWKT input String supplied by the user.
	 * @throws InvalidParameterException thrown if the input String is null 
	 * or empty.
	 */
	protected void parseWKT(String strWKT) throws InvalidParameterException {
		if ((strWKT == null) || (strWKT.isEmpty())) {
			throw new InvalidParameterException(
					"Input WKT String is null or not defined.");
		}
		wktString = strWKT.trim();
	}
	
	/**
	 * Method to parse a list of coordinate pairs in longitude, latitude order
	 * and convert them to a list of <code>GeodeticCoordinate</code> objects.
	 * 
	 * @param points Input String containing the points.
	 * @throws InvalidParameterException Thrown if the input list of points 
	 * cannot be parsed.
	 */
	protected void parsePoints(String strPoints) throws InvalidParameterException {
		points = new ArrayList<GeodeticCoordinate>();
		
		if ((strPoints == null) || (strPoints.isEmpty())) {
			throw new InvalidParameterException(
					"Input points must be specified in LON, LAT, LON, "
					+ "LAT format.");
		}
		
		String [] ptsArray = strPoints.split(",");
		if (ptsArray.length % 2 != 0) {
            throw new InvalidParameterException(
            		"Incomplete point list => [ "
            		+ strPoints
            		+ " ].  Each point must have a LON, LAT component.");
		}
		
        try {
            int i = 0;
            while (i < ptsArray.length) {                       
                points.add(new GeodeticCoordinate.GeodeticCoordinateBuilder()
                		.lon(ptsArray[i])
                		.lat(ptsArray[i+1])
                		.build());
                i += 2;
            }
        }
        catch (IllegalStateException ise) {
        	LOGGER.warn("Unable to parse input points [ "
        			+ strPoints
        			+ " ].  IllegalStateException encountered.  Error "
        			+ "message => [ "
        			+ ise.getMessage()
        			+ " ].");
        	throw new InvalidParameterException("Invalid input points [ " 
        			+ strPoints
        			+ " ].  Error message [ "
        			+ ise.getMessage()
        			+ " ].");
        }
        catch (NumberFormatException nfe) {
        	LOGGER.warn("Unable to parse input points [ "
        			+ strPoints
        			+ " ].  NumberFormatException encountered.  Error "
        			+ "message => [ "
        			+ nfe.getMessage()
        			+ " ].");
        	throw new InvalidParameterException("Invalid input points [ " 
        			+ strPoints
        			+ " ].  Error message [ "
        			+ nfe.getMessage()
        			+ " ].");
        }
	}
	
	/**
	 * The user submitted the request as a list of command-line parameters 
	 * (as opposed to JSON).  This method parses the input parameters.
	 * 
	 * @param operation The operation requested.
	 * @throws InvalidParameterException Thrown if there are any problems 
	 * parsing the input parameters.
	 */
	private void parseQueryString(String operationName) throws InvalidParameterException {
		operation = ElevationOperationType.fromString(operationName);
		units     = HeightUnitType.fromValue(
				RESTFilter.getParameter(
						getInputParams(), 
						ElevationRESTFilter.REQUESTED_UNITS_PARAM));
		source    = TerrainDataType.fromValue(
				RESTFilter.getParameter(
						getInputParams(), 
						ElevationRESTFilter.SOURCE_DATA_PARAM));
		switch(operation) {
	    	case GET_ELEVATION_AT:
	    		parsePoints(
	    				RESTFilter.getParameter(
	    						getInputParams(), 
	    						ElevationRESTFilter.POINTS_PARAM));
	    		break;
	    	case GET_MIN_MAX_ELEVATIONS:
	    		parseBoundingBox(
	    				RESTFilter.getParameter(
	    						getInputParams(), 
	    						ElevationRESTFilter.BOUNDING_BOX_PARAM));
	    		break;
	    	case GET_MIN_MAX_ELEVATIONS_WKT:
	    		parseWKT(	    				
	    				RESTFilter.getParameter(
	    						getInputParams(), 
	    						ElevationRESTFilter.WKT_PARAM));
	    		break;
	    	default:
	    		throw new InvalidParameterException(
	                "Invalid operation. See WSDL for valid operations.");
		} 
	}
	
	/**
	 * Extract the output units requested from the input JSON object.  This 
	 * method is called for all operations.
	 * 
	 * @param jObj Input JSON object.  
	 * @throws InvalidParameterException Thrown if the expected contents of 
	 * the input JSON object do not exist.
	 */
	private void parseUnits(JSONObject jObj) throws InvalidParameterException {
		if (jObj != null) {
			try {
				JSONObject root = jObj.getJSONObject(
						getOperation().getText());
				units = HeightUnitType.fromValue(
						root.getString(
								ElevationRESTFilter.REQUESTED_UNITS_PARAM));
			}
			catch (JSONException je) {
				units = HeightUnitType.METERS;
				LOGGER.warn("JSON element [ "
						+ ElevationRESTFilter.REQUESTED_UNITS_PARAM
						+ " ] not supplied.  Units will be defaulted to [ "
						+ HeightUnitType.METERS.toString()
						+ " ].");
			}
		}
		else {
			throw new InvalidParameterException("Input JSON contained no "
					+ "elements.  Unable to continue processing."); 
		}
	}
	
	/**
	 * Extract the target data source requested from the input JSON object.
	 * This method is called for all operations.
	 * 
	 * @param jObj Input JSON object.  
	 * @throws InvalidParameterException Thrown if the expected contents of 
	 * the input JSON object do not exist.
	 */
	private void parseDataSource(JSONObject jObj) 
			throws InvalidParameterException {
		if (jObj != null) {
			try {
				JSONObject root = jObj.getJSONObject(
						getOperation().getText());
				source = TerrainDataType.fromValue(
						root.getString(
								ElevationRESTFilter.SOURCE_DATA_PARAM));
			}
			catch (JSONException je) {
				source = TerrainDataType.BEST;
				LOGGER.warn("JSONException encountered.  JSON element [ "
						+ ElevationRESTFilter.SOURCE_DATA_PARAM
						+ " ] not supplied.  Source will be defaulted to [ "
						+ TerrainDataType.BEST.toString()
						+ " ].");
			}
		}
		else {
			throw new InvalidParameterException("Input JSON contained no "
					+ "elements.  Unable to continue processing."); 
		}
	}
	
	/**
	 * Method used to parse the "pts" JSON array which contains a list of 
	 * points (lat/lon) for which the caller wants the elevation data. This 
	 * method is called when the user/client requests the GetElevationAt 
	 * operation.
	 * 
	 * @param jObj Input JSON object. 
	 * @throws InvalidParameterException Thrown if the user provided any 
	 * invalid coordinates, or if the JSON is not processed as expected. 
	 */
	private void parsePoints(JSONObject jObj) throws InvalidParameterException {
		
		points = new ArrayList<GeodeticCoordinate>();
		
		if (jObj != null) {
			
			try {
				JSONObject root = jObj.getJSONObject(
						getOperation().getText());
				JSONArray  ptsArray = root.getJSONArray(
						ElevationRESTFilter.POINTS_PARAM);
				for (int i=0; i < ptsArray.length(); i++) {
					JSONObject obj = ptsArray.getJSONObject(i);
					points.add(
							new GeodeticCoordinate.GeodeticCoordinateBuilder()
								.lat(obj.getString(
										ElevationRESTFilter.LATITUDE_PARAM))
								.lon(obj.getString(
										ElevationRESTFilter.LONGITUDE_PARAM))
								.build());
				}
			}
			catch (IllegalStateException ise) {
				LOGGER.error("Invalid coordinates sent by the caller.  "
						+ "Exception message => [ "
						+ ise.getMessage()
						+ " ].");
				throw new InvalidParameterException(
						"Invalid coordinates sent by the caller.  "
						+ "Exception message => [ "
						+ ise.getMessage()
						+ " ].");
			}
			catch (JSONException je) {
				LOGGER.error("JSONException encountered.  JSON element [ "
						+ ElevationRESTFilter.POINTS_PARAM
						+ " ] not supplied.");
				throw new InvalidParameterException("JSON element [ "
						+ ElevationRESTFilter.POINTS_PARAM
						+ " ] not supplied.");
			}
		}
		else {
			throw new InvalidParameterException("Input JSON contained no "
					+ "elements.  Unable to continue processing."); 
		}
	}
	
	/**
	 * Method used to parse the Well-known Text (WKT) String contained in 
	 * the JSON "wkt" element.  
	 * 
	 * @param jObj jObj Input JSON object.
	 * @throws InvalidParameterException Thrown if the expected contents of 
	 * the input JSON object do not exist.
	 */
	private void parseWKT(JSONObject jObj) 
			throws InvalidParameterException {
		if (jObj != null) {
			JSONObject root = jObj.getJSONObject(
					getOperation().getText());
			wktString = root.getString(
							ElevationRESTFilter.WKT_PARAM);
		}		
		else {
			throw new InvalidParameterException("Input JSON contained no "
					+ "elements.  Unable to continue processing."); 
	
		}
	}
	
	/**
	 * Method used to parse the Bounding Box that should be supplied with the
	 * <code>GetMinMaxElevations</code> operation.
	 * 
	 * @param jObj Input JSON object.  
	 * @throws InvalidParameterException Thrown if the expected contents of 
	 * the input JSON object do not exist.
	 */
	private void parseBoundingBox(JSONObject jObj) 
			throws InvalidParameterException {
		
		if (jObj != null) {
			try {
				
				JSONObject root = jObj.getJSONObject(
						getOperation().getText());
				JSONArray  ptsArray = root.getJSONArray(
						ElevationRESTFilter.BOUNDING_BOX_PARAM);
				
				if (ptsArray.length() > 0) {
					// Get the first element
					JSONObject obj = ptsArray.getJSONObject(0);
					bBox = new BoundingBox.BoundingBoxBuilder()
							.lowerLeft(
									new GeodeticCoordinate.GeodeticCoordinateBuilder()
										.lat(obj.getString(
												ElevationRESTFilter.LOWER_LEFT_LATITUDE_PARAM))
										.lon(obj.getString(
												ElevationRESTFilter.LOWER_LEFT_LONGITUDE_PARAM))
										.build())
							.upperRight(
									new GeodeticCoordinate.GeodeticCoordinateBuilder()
										.lat(obj.getString(
												ElevationRESTFilter.UPPER_RIGHT_LATITUDE_PARAM))
										.lon(obj.getString(
												ElevationRESTFilter.UPPER_RIGHT_LONGITUDE_PARAM))
										.build())
							.build();
				}
				else {
					throw new InvalidParameterException(
							"Bounding box [ "
							+ ElevationRESTFilter.BOUNDING_BOX_PARAM 
							+ " element required for peration [ "
							+ operation.getText()
							+ " ] not supplied.");
				}
			}
			catch (IllegalStateException ise) {
				LOGGER.error("Invalid coordinates sent by the caller.  "
						+ "Exception message => [ "
						+ ise.getMessage()
						+ " ].");
				throw new InvalidParameterException(
						"Invalid coordinates sent by the caller.  "
						+ "Exception message => [ "
						+ ise.getMessage()
						+ " ].");
			}
			catch (JSONException je) {
				LOGGER.error("JSONException encountered.  JSON element [ "
						+ ElevationRESTFilter.BOUNDING_BOX_PARAM
						+ " ] not supplied.");
				throw new InvalidParameterException("JSON element [ "
						+ ElevationRESTFilter.BOUNDING_BOX_PARAM
						+ " ] not supplied.");
			}
		}		
		else {
			throw new InvalidParameterException("Input JSON contained no "
					+ "elements.  Unable to continue processing."); 
	
		}	
	}
	
	/**
	 * This method (and supporting methods) utilize the Google Gson library to
	 * parse the input JSON string.  Because the JSON structure varies depending
	 * on the requested operation we could not use Jackson to deserialize.  
	 * @param json String containing unprocessed JSON data.
	 */
	private void parseJSONString(String json) throws InvalidParameterException {
		if ((json != null) && (!json.isEmpty())) { 
			
			try {
				JSONObject jObj = new JSONObject(json);
				
				// Get the operation from the root element name.
				String[] elementNames = JSONObject.getNames(jObj);
				
				if ((elementNames != null) && (elementNames.length > 0)) { 
					operation = ElevationOperationType.fromString(elementNames[0]);
					parseUnits(jObj);
					parseDataSource(jObj);
					switch(operation) {
			        	case GET_ELEVATION_AT:
			        		parsePoints(jObj);
			        		break;
			        	case GET_MIN_MAX_ELEVATIONS:
			        		parseBoundingBox(jObj);
			        		break;
			        	case GET_MIN_MAX_ELEVATIONS_WKT:
			        		parseWKT(jObj);
			        		break;
			        	default:
			        		throw new InvalidParameterException(
		                        "Invalid operation. See WSDL for valid operations.");
					} 
				}
				else {
					throw new InvalidParameterException("Input JSON contained no "
							+ "elements.  Unable to continue processing.");  
				}
			}
			catch (JSONException je) {
				LOGGER.error("Invalid JSON encountered.  Exception "
						+ "message => [ "
						+ je.getMessage()
						+ " ].");
				throw new InvalidParameterException(
						"JSONException encountered.  Unable to parse the "
						+ "input JSON data.");
			}
		}
	}
	
	public void parse() throws InvalidParameterException {
		String operation = RESTFilter
				.getParameter(params, RESTFilter.OPERATION_PARAM);
		if ((operation != null) && (!operation.isEmpty())) {
			parseQueryString(operation);
		}
		else {
			String parameters = RESTFilter
					.getParameter(params, RESTFilter.PARAMETER_PARAM);
			if ((parameters != null) && (!parameters.isEmpty())) {
				parseJSONString(parameters);
			}
			else {

			}
		}
 	}
	
    /**
     * Static inner class implementing the builder creation pattern for 
     * objects of type <code>QueryStringParser</code>.
     * 
     * @author L. Craig Carpenter
     */
	public static class QueryStringParserBuilder {
		
		private Map<String, Object> params;
		
		/**
		 * Setter method for the input query String parameters.
		 * @param inputParams The input query string parameters.
		 * @return Reference to the builder object.
		 */
		public QueryStringParserBuilder withParams(
				Map<String, Object> inputParams) {
			params = inputParams;
			return this;
		}
		
		/**
		 * Public method used to construct a concrete object of type 
		 * <code>QueryStringParser</code>.
		 * 
		 * @return A constructed, validated <code>QueryStringParser</code>
		 * object.
		 */
		public QueryStringParser build() 
				throws IllegalStateException, InvalidParameterException {
			QueryStringParser obj = new QueryStringParser(this);
			validate(obj);
			return obj;
		}
		
		/**
		 * Validate the consistency of the input data before returning the object.
		 * @param obj The constructed <code>QueryStringParser</code> object.
		 */
		private void validate(QueryStringParser obj) 
				throws IllegalStateException, InvalidParameterException {
			if ((obj.getInputParams() == null) || 
					(obj.getInputParams().size() < 1)) {
				throw new IllegalStateException("Input parameter Map is null "
						+ "or contains no elements.  Unable to parse the "
						+ "input parameters.");
			}
			if ((RESTFilter
					.getParameter(
							params, 
							RESTFilter.OPERATION_PARAM) == null) ||
					(RESTFilter
							.getParameter(
									params, 
									RESTFilter.OPERATION_PARAM).isEmpty())) {
				if ((RESTFilter
						.getParameter(
								params, 
								RESTFilter.PARAMETER_PARAM) == null) ||
						(RESTFilter
								.getParameter(
										params, 
										RESTFilter.PARAMETER_PARAM).isEmpty())) {
					throw new InvalidParameterException(
							"Either operation or parameters must be "
							+ "supplied.  For operation, use a value "
							+ "specified in WSDL and additional parameters "
							+ "as needed.  For parameters, a JSON object "
							+ "must be supplied containing data as "
							+ "specified in the WSDL.");
				}
			}
		}
	}
}
