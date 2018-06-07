package mil.nga.gdp.messages;

import java.io.Serializable;
import java.util.Map;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.exceptions.InvalidParameterException;

/**
 * Class encapsulating the data supplied by clients when they want to extract 
 * products by the well known text (WKT) field.
 * 
 * @author L. Craig Carpenter
 */
public class ProductsByWKT 
		extends ProductMessage 
		implements Serializable, GDPConstantsI {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = 7398073403771859591L;
	
	private String wktString = null;
	
	/**
	 * Default constructor required by JAX-B.
	 */
	public ProductsByWKT() {}
	
	/**
	 * Alternate constructor allowing clients to supply the required input 
	 * parameters embedded in a Map data structure.
	 * 
	 * @param map List of key/value pairs containing all required input 
	 * parameters.
	 */
	public ProductsByWKT(Map<String, String> map) 
			throws InvalidParameterException {
		super(map);
		
		if ((map != null) && (map.size() > 0)) {
			setWKTString(map.get(WKT_INPUT_PARAM));
		}
		else {
			throw new InvalidParameterException("Unable to parse input URL "
					+ "parameters.  The input list of parameters is null or "
					+ "contains no elements.");
		}
	}
	
	/**
	 * Getter method for the requested well known text (WKT) String.
	 * @return Client supplied WKT String.
	 */
	public String getWKTString() {
		return wktString;
	}
	
	/**
	 * Setter method for the requested well known text (WKT) String.
	 * 
	 * @param value Client supplied WKT String.
	 * @throws InvalidParameterException Thrown if the input tag is null or 
	 * empty.
	 */
	public void setWKTString(String value) throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) { 
			wktString = value;
		}
		else {
			throw new InvalidParameterException("Parameter defining the "
					+ "WKT String is null or empty.");
		}
	}
}
