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
public class ProductsByCountry
		extends ProductMessage 
		implements Serializable, GDPConstantsI {
	
	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = 7025174127790410855L;
	
	private String countryCode = null;
	
	/**
	 * Default constructor required by JAX-B.
	 */
	public ProductsByCountry() {}
	
	/**
	 * Alternate constructor allowing clients to supply the required input 
	 * parameters embedded in a Map data structure.
	 * 
	 * @param map List of key/value pairs containing all required input 
	 * parameters.
	 */
	public ProductsByCountry(Map<String, String> map) 
			throws InvalidParameterException {
		super(map);
		
		if ((map != null) && (map.size() > 0)) {
			setCountryCode(map.get(COUNTRY_CODE_INPUT_PARAM));
		}
		else {
			throw new InvalidParameterException("Unable to parse input URL "
					+ "parameters.  The input list of parameters is null or "
					+ "contains no elements.");
		}
	}
	
	/**
	 * Getter method for the requested country code.
	 * @return Client supplied country code.
	 */
	public String getCountryCode() {
		return countryCode;
	}
	
	/**
	 * Setter method for the requested country code String.
	 * 
	 * @param value Client supplied country code.
	 * @throws InvalidParameterException Thrown if the input tag is null or 
	 * empty.
	 */
	public void setCountryCode(String value) throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) { 
			countryCode = value;
		}
		else {
			throw new InvalidParameterException("Parameter defining the "
					+ "country code is null or empty.");
		}
	}
}
