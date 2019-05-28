package mil.nga.gdp;

public interface GDPConstantsI {

	/**
	 * Boolean value indicating whether or not incoming requests should be
	 * archived.
	 */
	public static final String ARCHIVE_REQUEST_PROP = "gdp.archive_requests";
	
	/** 
	 * The name of the properties file to load from the classpath
	 */
	public static final String PROPERTY_FILE_NAME = "gdp.properties.file";
	
	/**
	 * On-disk path in which to store archive requests.
	 */
	public static final String REQUEST_DIRECTORY_PROP = "gdp.archive_requests.path";
	
	public static final String PRODUCT_NAME_COLUMN = "PROD_NAME";
	public static final String PRODUCT_TAG_COLUMN = "PROD_TAG";
	public static final String PRODUCT_SCALE_COLUMN = "PROD_SCALE";
	public static final String CATEGORY_COLUMN = "CATEGORY";
	public static final String SUBCATEGORY_COLUMN = "SUB_CATEGORY";
	public static final String CATEGORY_DESCRIPTION_COLUMN = "CAT_DESC";
	public static final String PRODUCT_CC_VIEW_COLUMN = "PROD_CC_VIEW";
	public static final String PRODUCT_AOR_VIEW_COLUMN = "PROD_AOR_VIEW";
	public static final String PRODUCT_SOURCE_TABLE_COLUMN = "PROD_AOR_VIEW";
	public static final String PRODUCT_NOTIFY_COLUMN = "PROD_NOTIFY";
	public static final String PRODUCT_POPUP_COLUMN = "PROD_POPUP";
	public static final String DOWNLOAD_COLUMNS_COLUMN = "DOWNLOAD_COLUMNS";
	public static final String REPORT_COLUMNS_COLUMN = "REPORT_COLUMNS";
	public static final String UNIQUE_ID_COLUMN = "UNIQUE_ID";
	public static final String COMMERCIAL_FORMAT_OPTIONS_COLUMN = "COMMERCIAL_FORMAT_OPTIONS";
	public static final String MAX_DOWNLOAD_RECORDS_COLUMN = "MAX_DOWNLOAD_RECORDS";
	public static final String DOWNLOADABLE_COLUMN = "DOWNLOADABLE";
	public static final String WHERE_CLAUSE_COLUMN = "WHERE_CLAUSE";
	public static final String DESCRIPTION_COLUMN = "DESCRIPTION";
	public static final String GRLS_COLUMN = "GRLS";
	public static final String HAS_TILE_SERVER_COLUMN = "HASTILESERVER";
	public static final String TILESERVER_LAYER_COLUMN = "TILELAYERNAME";
	public static final String HOME_URL_COLUMN = "HOME_URL";
	public static final String MAP_BASE_URL_COLUMN = "MAP_BASE_URL";
	public static final String MAP_LAYER_NUMBER_COLUMN = "MAP_LAYER_NUMBER";
	public static final String MAP_QUERY_LAYER_COLUMN = "MAP_QUERY_LAYER";
	public static final String BBOX_SCALE_FILTER_COLUMN = "BBOX_SCALE_FILTER";
	public static final String BBOX_SCALE_RELATE_COLUMN = "BBOX_SCALE_RELATE";
	public static final String TAB_NAME_COLUMN = "TAB_NAME";
	public static final String CLASSIFICATION_COLUMN= "CLASSIFICATION";
	public static final String PRODUCT_LOAD_DATE_COLUMN = "PROD_LOAD_DATE";
	public static final String PRODUCT_COUNT_COLUMN = "PROD_COUNT";
	public static final String SECURITY_RELEASABILITY_COLUMN = "SEC_REL";
	public static final String RELEASABILITY_DESCRIPTION_COLUMN = "REL_DESC";
	public static final String REPORT_PUB_COLUMN = "REPORT_PUB";
	public static final String PRODUCT_SIZE_BYTES_COLUMN = "PRODUCT_SIZE_BYTES";
	public static final String KML_LAYER_NUMBER_COLUMN = "KML_LAYER_NUMBER";
	
	/**
	 * The input parameter in which the client supplies the AOR.
	 */
	public static final String AOR_INPUT_PARAM = "aororcode";
	
	/**
	 * The input parameter in which the client supplies the backwards 
	 * compatability flag.
	 */
	public static final String BACKWARDS_COMPATABILITY_INPUT_PARAM 
			= "origgdncompatable";
	
	/**
	 * The input parameter in which the client supplies the bounding box.
	 */
	public static final String BBOX_INPUT_PARAM = "bbox";
	
	/**
	 * Parameter in which clients will supply the JSONP callback function.
	 * This is not a required parameter.
	 */
	public static final String CALLBACK_PARAM = "callback";
	
	/**
	 * The input parameter in which the client supplies the code
	 */
	public static final String CODE_INPUT_PARAM = "code";
	
	/**
	 * The input parameter in which the client supplies the country code
	 */
	public static final String COUNTRY_CODE_INPUT_PARAM = "country_code";
	
	/**
	 * Parameter in which clients indicate whether or not there is a direct
	 * download link.
	 */
	public static final String DIRECT_DOWNLOAD_LINK_INPUT_PARAM 
			= "directdownloadlink";
	
	/**
	 * Parameter in which clients indicate whether or not there 
	 */
	public static final String DOWNLOAD_ID_INPUT_PARAM = "downloadid";
	
	/**
	 * Column to use for querying for the FIPS country code.
	 */
	public static final String FIPS_CODE_COLUMN = "FIPS_CODE";
	
	/**
	 * Column to use for querying for the ISO country code.
	 */
	public static final String ISO_3_CHAR_COLUMN = "ISO3CHR";
	
	/**
	 * Column used to search for AOR_CODE 
	 */
	public static final String AOR_CODE_COLUMN = "AOR_CODE";
	
	/**
	 * Column used to search by JUMP_CODE
	 */
	public static final String JUMP_CODE_COLUMN = "JUMP_CODE";
	
	/**
	 * Query by AOR (military command)
	 */
	public static final String QUERY_BY_COMMAND = "bycommand";
	
	/**
	 * Query by jump code
	 */
	public static final String QUERY_BY_JUMP_CODE = "byjumpcode";
	
	/**
	 * The input parameter in which the client supplies the start of a date 
	 * range.
	 */
	public static final String FROM_DATE_INPUT_PARAM = "fromdate";
	
	/**
	 * The input parameter in which the client supplies the operation 
	 * requested.
	 */
	public static final String OPERATION_INPUT_PARAM = "operation";
	
	/**
	 * The input parameter in which the client supplies a product tag.
	 */
	public static final String PRODUCT_TAG_INPUT_PARAM = "producttag";
	
	/**
	 * The default outputFormat is JSON, but clients may specify XML.  This is 
	 * the optional input parameter containing the output format requested.
	 */
	public static final String OUTPUT_FORMAT = "outputformat";
	
	/**
	 * The input parameter in which a state code is supplied. 
	 */
	public static final String STATE_CODE_INPUT_PARAM = "state";
	
	/**
	 * The input parameter in which the client supplies the end of a date 
	 * range.
	 */
	public static final String TO_DATE_INPUT_PARAM = "todate";
	
	/**
	 * The input parameter in which the client supplies the "well known text"
	 * String associated with a product.
	 */
	public static final String WKT_INPUT_PARAM = "wktstring";
	
	/**
	 * The name of the JPA persistence context.
	 */
	public static final String APPLICATION_PERSISTENCE_CONTEXT = "GDP-JPA-Context";
	
	/**
	 * The length of generated request IDs.
	 */
	public static final int REQUEST_ID_LENGTH = 4;
	
}
