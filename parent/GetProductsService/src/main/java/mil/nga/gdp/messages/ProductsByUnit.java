package mil.nga.gdp.messages;

import java.io.Serializable;
import java.util.Map;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.exceptions.InvalidParameterException;

/**
 * Class encapsulating the data supplied by clients when they want to extract 
 * products by the product unit.
 * 
 * @author L. Craig Carpenter
 */
public class ProductsByUnit 
		extends ProductMessage 
		implements Serializable, GDPConstantsI {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = 8609416117780574428L;
	
	private String downloadID = null;

	/**
	 * Default constructor required by JAX-B.
	 */
	public ProductsByUnit() {}

	/**
	 * Alternate constructor allowing clients to supply the required input 
	 * parameters embedded in a Map data structure.
	 * 
	 * @param map List of key/value pairs containing all required input 
	 * parameters.
	 */
	public ProductsByUnit(Map<String, String> map) 
			throws InvalidParameterException {
		super(map);
		
		if ((map != null) && (map.size() > 0)) {
			setDownloadID(map.get(DOWNLOAD_ID_INPUT_PARAM));
		}
		else {
			throw new InvalidParameterException("Unable to parse input URL "
					+ "parameters.  The input list of parameters is null or "
					+ "contains no elements.");
		}
	}

	/**
	* Getter method for the requested download ID String.
	* @return Client supplied download ID
	*/
	public String getDownloadID() {
		return downloadID;
	}

	/**
	 * Setter method for the requested download ID.
	 * 
	 * @param value Client supplied download ID.
	 * @throws InvalidParameterException Thrown if the input tag is null or 
	 * empty.
	 */
	public void setDownloadID(String value) throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) { 
			downloadID = value;
		}
		else {
			throw new InvalidParameterException("Parameter defining the "
					+ "download ID is null or empty.");
		}
	}
}
