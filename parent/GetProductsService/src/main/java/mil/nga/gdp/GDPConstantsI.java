package mil.nga.gdp;

public interface GDPConstantsI {

	/**
	 * The input parameter in which the client supplies the AOR.
	 */
	public static final String AOR_INPUT_PARAM = "AorOrCode";
	
	/**
	 * The input parameter in which the client supplies the backwards 
	 * compatability flag.
	 */
	public static final String BACKWARDS_COMPATABILITY_INPUT_PARAM 
			= "origGdnCompatable";
	
	/**
	 * The input parameter in which the client supplies the bounding box.
	 */
	public static final String BBOX_INPUT_PARAM = "Bbox";
	
	/**
	 * Parameter in which clients will supply the JSONP callback function.
	 * This is not a required parameter.
	 */
	public static final String CALLBACK_PARAM = "callback";
	
	/**
	 * The input parameter in which the client supplies the code
	 */
	public static final String CODE_INPUT_PARAM = "CODE";
	
	/**
	 * The input parameter in which the client supplies the country code
	 */
	public static final String COUNTRY_CODE_INPUT_PARAM = "Country_Code";
	
	/**
	 * Parameter in which clients indicate whether or not there is a direct
	 * download link.
	 */
	public static final String DIRECT_DOWNLOAD_LINK_INPUT_PARAM 
			= "directDownloadLink";
	
	/**
	 * Parameter in which clients indicate whether or not there 
	 */
	public static final String DOWNLOAD_ID_INPUT_PARAM = "downloadId";
	
	/**
	 * The input parameter in which the client supplies the start of a date 
	 * range.
	 */
	public static final String FROM_DATE_INPUT_PARAM = "fromDate";
	
	/**
	 * The input parameter in which the client supplies the operation 
	 * requested.
	 */
	public static final String OPERATION_INPUT_PARAM = "operation";
	
	/**
	 * The input parameter in which the client supplies a product tag.
	 */
	public static final String PRODUCT_TAG_INPUT_PARAM = "productTag";
	
	/**
	 * The default outputFormat is JSON, but clients may specify XML.  This is 
	 * the optional input parameter containing the output format requested.
	 */
	public static final String OUTPUT_FORMAT = "outputFormat";
	
	/**
	 * The input parameter in which the client supplies the end of a date 
	 * range.
	 */
	public static final String TO_DATE_INPUT_PARAM = "toDate";
	
	/**
	 * The input parameter in which the client supplies the "well known text"
	 * String associated with a product.
	 */
	public static final String WKT_INPUT_PARAM = "wktString";
	
}
