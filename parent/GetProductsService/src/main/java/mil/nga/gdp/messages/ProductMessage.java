package mil.nga.gdp.messages;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.exceptions.InvalidParameterException;
import mil.nga.gdp.util.DateUtils;

/**
 * Super class containing the data common to all input GDP data request 
 * messages.
 * 
 * @author L. Craig Carpenter
 */
public class ProductMessage implements Serializable, GDPConstantsI {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = -8500153684233549741L;
	
	private boolean backwardsCompatible = false;
	private boolean directDownloadLink  = false;
	private Date    fromDate            = null;
	private Date    toDate              = null;
	private String  productTag          = null;
	
	/**
	 * Default constructor required for JAX-B
	 */
	public ProductMessage() { }
	
	/**
	 * Alternate constructor populating the common parameters from the input
	 * Map object.
	 * 
	 * @param map Map containing input URL parameters.
	 * @throws InvalidParameterException Thrown if any of the required 
	 * parameters are not supplied.
	 */
	public ProductMessage(Map<String, String> map) 
			throws InvalidParameterException {
		
		if ((map != null) && (map.size() > 0)) {

			setBackwardsCompatible(
					map.get(BACKWARDS_COMPATABILITY_INPUT_PARAM));
			setDirectDownloadLink(
					map.get(DIRECT_DOWNLOAD_LINK_INPUT_PARAM));
			
			// Only attempt to set the dates if they were supplied.
			String temp = map.get(FROM_DATE_INPUT_PARAM);
			if ((temp != null) && (temp.isEmpty())) { 
				setFromDate(temp);
			}
			
			temp = map.get(TO_DATE_INPUT_PARAM);
			if ((temp != null) && (temp.isEmpty())) { 
				setToDate(temp);
			}
			setProductTag(map.get(PRODUCT_TAG_INPUT_PARAM));
		}
		else {
			throw new InvalidParameterException("Unable to parse input URL "
					+ "parameters.  The input list of parameters is null or "
					+ "contains no elements.");
		}
	}
	
	/**
	 * Determines whether or not the request should be treated as compatible 
	 * with the older GDN software.  
	 * 
	 * @return True if backwards compatible, false otherwise.
	 */
	public boolean getBackwardsCompatible() {
		return backwardsCompatible;
	}
	
	/**
	 * Indicates whether a direct download link exists.  
	 * 
	 * @return True if a direct download link exists, false otherwise.
	 */
	public boolean getDirectDownloadLink() {
		return directDownloadLink;
	}
	
	/**
	 * The earliest date to use in a query specifying a time slice.
	 * 
	 * @return The start date of a query.
	 */
	public Date getFromDate() {
		return fromDate;
	}
	
	/**
	 * Getter method for the product tag.
	 * 
	 * @return The input product tag.
	 */
	public String getProductTag(String value) {
		return productTag;
	}
	
	/**
	 * The latest date to use in a query specifying a time slice.
	 * 
	 * @return The end date of a query.
	 */
	public Date getToDate() {
		return toDate;
	}
	
	/**
	 * Determines whether or not the request should be treated as compatible 
	 * with the older GDN software.  
	 * 
	 * @param value True if backwards compatible, false otherwise.
	 */
	public void setBackwardsCompatible(boolean value) {
		backwardsCompatible = value;
	}
	
	/**
	 * Indicates whether a direct download link exists.  
	 * 
	 * @param value True if a direct download link exists, false otherwise.
	 */
	public void setBackwardsCompatible(String value) 
			throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) {
			backwardsCompatible = Boolean.valueOf(value);
		}
		else {
			throw new InvalidParameterException("The input boolean value is "
					+ "null or empty.");
		}
	}
	
	/**
	 * Indicates whether a direct download link exists.  
	 * 
	 * @param value True if a direct download link exists, false otherwise.
	 */
	public void setDirectDownloadLink(boolean value) {
		directDownloadLink = value;
	}
	
	/**
	 * Indicates whether a direct download link exists.  
	 * 
	 * @param value True if a direct download link exists, false otherwise.
	 */
	public void setDirectDownloadLink(String value) 
			throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) {
			directDownloadLink = Boolean.valueOf(value);
		}
		else {
			throw new InvalidParameterException("The input boolean value is "
					+ "null or empty.");
		}
	}
	
	/**
	 * Setter method for the earliest date to use in a query specifying a time 
	 * slice.
	 * 
	 * @param value The start date of a query.
	 */
	public void setFromDate(String value) throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) { 
			fromDate = DateUtils.parse(value);
			if (fromDate == null) {
				throw new InvalidParameterException("Unable to parse the input "
						+ "input fromDate field supplied by the client.  Data "
						+ "supplied [ "
						+ value
						+ " ].");
			}
		}
		else {
			throw new InvalidParameterException("Unable to parse the input "
					+ "input fromDate field supplied by the client.  Data "
					+ "supplied was null or empty.");
		}
	}
	
	/**
	 * Setter method for the earliest date to use in a query specifying a time 
	 * slice.
	 * 
	 * @param value The start date of a query.
	 */
	public void setFromDate(Date value) {
		fromDate = value;
	}
	
	/**
	 * Setter method for the product tag.
	 * 
	 * @param value The input product tag.
	 * @throws InvalidParameterException Thrown if the input tag is null or 
	 * empty.
	 */
	public void setProductTag(String value) throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) { 
			productTag = value;
		}
		else {
			throw new InvalidParameterException("Parameter defining the "
					+ "product tag is null or empty.");
		}
	}
	
	/**
	 * Setter method for the latest date to use in a query specifying a time 
	 * slice.
	 * 
	 * @param value The end date of a query.
	 */
	public void setToDate(String value) throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) { 
			toDate = DateUtils.parse(value);
			if (toDate == null) {
				throw new InvalidParameterException("Unable to parse the input "
						+ "input toDate field supplied by the client.  Data "
						+ "supplied [ "
						+ value
						+ " ].");
			}
		}
		else {
			throw new InvalidParameterException("Unable to parse the input "
					+ "input toDate field supplied by the client.  Data "
					+ "supplied was null or empty.");
		}
	}
	
	/**
	 * Setter method for the latest date to use in a query specifying a time 
	 * slice.
	 * 
	 * @param value The end date of a query.
	 */
	public void setToDate(Date value) {
		toDate = value;
	}
}
