package mil.nga.gdp.messages;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class ProductMessage implements Serializable {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = -8500153684233549741L;
	
	/**
	 * Formatter object for dates used throughout the GDP application.
	 */
	private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	// Internal members
	private final boolean backwardsCompatible;
	private final boolean directDownloadLink;
	private final Date    fromDate;
	private final Date    toDate;
	private final String  productTag;
	
	/**
	 * Default constructor.
	 * @param builder The ProductMessageBuilder object.
	 */
	protected ProductMessage(ProductMessageBuilder<?> builder) { 
		backwardsCompatible = builder.backwardsCompatible;
		directDownloadLink  = builder.directDownloadLink;
		fromDate            = builder.fromDate;
		toDate              = builder.toDate;
		productTag          = builder.productTag;
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
	 * The earliest date to use in a query specifying a time slice formatted
	 * as a String.
	 * @return The start date of a query.
	 */
	public String getFromDateAsString() {
		String date = "";
		if (fromDate != null) {
			date = df.format(fromDate);
		}
		return date;
	}
	
	/**
	 * Getter method for the product tag.
	 * @return The input product tag.
	 */
	public String getProductTag() {
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
	 * The latest date to use in a query specifying a time slice formatted
	 * as a String.
	 * @return The start date of a query.
	 */
	public String getToDateAsString() {
		String date = "";
		if (toDate != null) {
			date = df.format(toDate);
		}
		return date;
	}
	
    /**
     * Convert the input message into a String-base format.
     */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("backwards compatible => [ ");
		sb.append(getBackwardsCompatible());
		sb.append(" ], direct download => [ ");
		sb.append(getDirectDownloadLink());
		sb.append(" ], ");
		if (getFromDate() != null) {
			sb.append("from date => [ ");
			sb.append(getFromDateAsString());
			sb.append(" ], ");
		}
		if (getToDate() != null) {
			sb.append("to date => [ ");
			sb.append(getToDateAsString());
			sb.append(" ], ");
		}
		return sb.toString();
	}
	
	/**
	 * Generic static inner class implementing the builder creation pattern
	 * for objects of type ProductMessage.
	 * 
	 * @author L. Craig Carpenter
	 *
	 * @param <T> Subclass builder object.
	 */
	public static class ProductMessageBuilder <T extends ProductMessageBuilder<T>> 
			implements GDPConstantsI {
		
		private boolean backwardsCompatible = false;
		private boolean directDownloadLink  = false;
		private Date    fromDate            = null;
		private Date    toDate              = null;
		private String  productTag          = null;
		
		/**
		 * Method used to construct an object of type ProductMessage.
		 * @return A newly constructed object.
		 */
		public ProductMessage build() {
			return new ProductMessage(this);
		}
		
		/**
		 * Determines whether or not the request should be treated as compatible 
		 * with the older GDN software.  
		 * @param value True if backwards compatible, false otherwise.
		 */
		@SuppressWarnings("unchecked")
		public T backwardsCompatible(boolean value) {
			backwardsCompatible = value;
			return (T)this;
		}
		
		/**
		 * Determines whether or not the request should be treated as compatible 
		 * with the older GDN software.  
		 * @param value True if a direct download link exists, false otherwise.
		 */
		@SuppressWarnings("unchecked")
		public T backwardsCompatible(String value) {
			if ((value != null) && (!value.isEmpty())) {
				backwardsCompatible = Boolean.valueOf(value);
			}
			return (T)this;
		}
		
		/**
		 * Indicates whether a direct download link exists.   
		 * @param value True if a direct download link exists, false otherwise.
		 */
		@SuppressWarnings("unchecked")
		public T directDownloadLink(boolean value) {
			directDownloadLink = value;
			return (T)this;
		}
		
		/**
		 * Indicates whether a direct download link exists.  
		 * @param value True if a direct download link exists, false otherwise.
		 */
		@SuppressWarnings("unchecked")
		public T directDownloadLink(String value) {
			if ((value != null) && (!value.isEmpty())) {
				directDownloadLink = Boolean.valueOf(value);
			}
			return (T)this;
		}
		
		/**
		 * Setter method for the earliest date to use in a query specifying a time 
		 * slice.
		 * @param value The start date of a query.  This value is optional.
		 */
		@SuppressWarnings("unchecked")
		public T fromDate(Date value) {
			fromDate = value;
			return (T)this;
		}
		
		/**
		 * Setter method for the earliest date to use in a query specifying a time 
		 * slice.
		 * @param value The start date of a query.
		 */
		@SuppressWarnings("unchecked")
		public T fromDate(String value) 
				throws IllegalStateException {
			if ((value != null) && (!value.isEmpty())) { 
				fromDate = DateUtils.parse(value);
				if (fromDate == null) {
					throw new IllegalStateException("Unable to parse the input "
							+ "input fromDate field supplied by the client.  Data "
							+ "supplied => [ "
							+ value
							+ " ].");
				}
			}
			return (T)this;
		}
		
		/**
		 * Setter method for the latest date to use in a query specifying a time 
		 * slice.
		 * @param value The end date of a query.  This value is optional.
		 */
		@SuppressWarnings("unchecked")
		public T toDate(Date value) {
			toDate = value;
			return (T)this;
		}
		
		/**
		 * Setter method for the latest date to use in a query specifying a time 
		 * slice.
		 * @param value The end date of a query.
		 */
		@SuppressWarnings("unchecked")
		public T toDate(String value) 
				throws IllegalStateException {
			if ((value != null) && (!value.isEmpty())) { 
				toDate = DateUtils.parse(value);
				if (toDate == null) {
					throw new IllegalStateException("Unable to parse the input "
							+ "input toDate field supplied by the client.  Date "
							+ "supplied => [ "
							+ value
							+ " ].");
				}
			}
			return (T)this;
		}
		
		/**
		 * Setter method for the product tag.
		 * @param value The input product tag.
		 */
		@SuppressWarnings("unchecked")
		public T productTag(String value) {
			productTag = value;
			return (T)this;
		}

		/**
		 * Alternate constructor populating the common parameters from the input
		 * Map object.
		 * 
		 * @param map Map containing input URL parameters.
		 * @throws InvalidParameterException Thrown if any of the required 
		 * parameters are not supplied.
		 */
		@SuppressWarnings("unchecked")
		public T fromMessage(Map<String, String> map) 
				throws IllegalStateException {
			
			if ((map != null) && (map.size() > 0)) {

				backwardsCompatible(
						map.get(BACKWARDS_COMPATABILITY_INPUT_PARAM));
				directDownloadLink(
						map.get(DIRECT_DOWNLOAD_LINK_INPUT_PARAM));
				
				// Only attempt to set the dates if they were supplied.
				String temp = map.get(FROM_DATE_INPUT_PARAM);
				if ((temp != null) && (!temp.isEmpty())) { 
					fromDate(temp);
				}
				
				temp = map.get(TO_DATE_INPUT_PARAM);
				if ((temp != null) && (!temp.isEmpty())) { 
					toDate(temp);
				}
				productTag(map.get(PRODUCT_TAG_INPUT_PARAM));
			}
			else {
				throw new IllegalStateException("Unable to parse input URL "
						+ "parameters.  The input list of parameters is null or "
						+ "contains no elements.");
			}
			return (T)this;
		}
		
	}
}
