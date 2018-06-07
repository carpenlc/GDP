package mil.nga.gdp.messages;

import java.io.Serializable;
import java.util.Map;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.exceptions.InvalidParameterException;

/**
 * Class encapsulating the data supplied by clients when they want to extract 
 * products by their country code.
 * 
 * @author L. Craig Carpenter
 */
public class ProductsByAORJMPCode
		extends ProductMessage 
		implements Serializable, GDPConstantsI {
	
	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = -9073932447033857074L;
	
	private String code = null;
	private String aorOrCode = null;
	
	/**
	 * Default constructor required by JAX-B.
	 */
	public ProductsByAORJMPCode() {}
	
	/**
	 * Alternate constructor allowing clients to supply the required input 
	 * parameters embedded in a Map data structure.
	 * 
	 * @param map List of key/value pairs containing all required input 
	 * parameters.
	 */
	public ProductsByAORJMPCode(Map<String, String> map) 
			throws InvalidParameterException {
		
		super(map);
		
		if ((map != null) && (map.size() > 0)) {
			setCode(map.get(CODE_INPUT_PARAM));
			setAorOrCode(map.get(AOR_INPUT_PARAM));
		}
		else {
			throw new InvalidParameterException("Unable to parse input URL "
					+ "parameters.  The input list of parameters is null or "
					+ "contains no elements.");
		}
	}
	
	/**
	 * Getter method for the requested code.
	 * @return Client supplied code.
	 */
	public String getAorOrCode() {
		return aorOrCode;
	}
	
	/**
	 * Getter method for the requested code.
	 * @return Client supplied code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Setter method for the requested code String.
	 * 
	 * @param value Client supplied code.
	 * @throws InvalidParameterException Thrown if the input tag is null or 
	 * empty.
	 */
	public void setCode(String value) throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) { 
			code = value;
		}
		else {
			throw new InvalidParameterException("Parameter defining the "
					+ "code is null or empty.");
		}
	}
	
	/**
	 * Setter method for the requested AOR String.
	 * 
	 * @param value Client supplied AOR String
	 * @throws InvalidParameterException Thrown if the input value is null or 
	 * empty.
	 */
	public void setAorOrCode(String value) throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) { 
			aorOrCode = value;
		}
		else {
			throw new InvalidParameterException("Parameter defining the "
					+ "code is null or empty.");
		}
	}
}