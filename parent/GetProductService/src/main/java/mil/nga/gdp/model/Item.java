//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.22 at 11:18:56 AM CDT 
//


package mil.nga.gdp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mil.nga.gdp.GDPConstantsI;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}prod_name"/>
 *         &lt;element ref="{}prod_tag"/>
 *         &lt;element ref="{}prod_scale"/>
 *         &lt;element ref="{}category"/>
 *         &lt;element ref="{}sub_category"/>
 *         &lt;element ref="{}cat_desc"/>
 *         &lt;element ref="{}prod_cc_view"/>
 *         &lt;element ref="{}prod_aor_view"/>
 *         &lt;element ref="{}prod_source_table"/>
 *         &lt;element ref="{}prod_notify"/>
 *         &lt;element ref="{}prod_popup"/>
 *         &lt;element ref="{}download_columns"/>
 *         &lt;element ref="{}where_clause"/>
 *         &lt;element ref="{}report_columns"/>
 *         &lt;element ref="{}unique_id"/>
 *         &lt;element ref="{}download_oracle_column"/>
 *         &lt;element ref="{}commercial_format_options"/>
 *         &lt;element ref="{}max_download_records"/>
 *         &lt;element ref="{}downloadable"/>
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}grls"/>
 *         &lt;element ref="{}hasTileServer"/>
 *         &lt;element ref="{}tileLayerName"/>
 *         &lt;element ref="{}home_url"/>
 *         &lt;element ref="{}map_base_url"/>
 *         &lt;element ref="{}map_layer_number"/>
 *         &lt;element ref="{}map_query_layer"/>
 *         &lt;element ref="{}bbox_scale_filter"/>
 *         &lt;element ref="{}bbox_scale_relate"/>
 *         &lt;element ref="{}tab_name"/>
 *         &lt;element ref="{}classification"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "prodName",
    "prodTag",
    "prodScale",
    "category",
    "subCategory",
    "catDesc",
    "prodCcView",
    "prodAorView",
    "prodSourceTable",
    "prodNotify",
    "prodPopup",
    "downloadColumns",
    "whereClause",
    "reportColumns",
    "uniqueId",
    "downloadOracleColumn",
    "commercialFormatOptions",
    "maxDownloadRecords",
    "downloadable",
    "description",
    "grls",
    "hasTileServer",
    "tileLayerName",
    "homeUrl",
    "mapBaseUrl",
    "mapLayerNumber",
    "mapQueryLayer",
    "bboxScaleFilter",
    "bboxScaleRelate",
    "tabName",
    "classification"
})
@XmlRootElement(name = "item")
@Entity
public class Item implements Serializable, GDPConstantsI {

    /**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = 5641621436380971512L;
	
	// Internal members.
	@Column(name=PRODUCT_NAME_COLUMN)
    private String  prodName;
	@Column(name=PRODUCT_TAG_COLUMN)
    private String  prodTag;
	@Column(name=PRODUCT_SCALE_COLUMN)
    private String  prodScale;
	@Column(name=CATEGORY_COLUMN)
    private String  category;
	@Column(name=SUBCATEGORY_COLUMN)
    private String  subCategory;
	@Column(name=CATEGORY_DESCRIPTION_COLUMN)
    private String  catDesc;
	@Column(name=PRODUCT_CC_VIEW_COLUMN)
    private String  prodCcView;
	@Column(name=PRODUCT_AOR_VIEW_COLUMN)
    private String  prodAorView;
	@Column(name=PRODUCT_SOURCE_TABLE_COLUMN)
    private String  prodSourceTable;
	@Column(name=PRODUCT_NOTIFY_COLUMN)
    private String  prodNotify;
	@Column(name=PRODUCT_POPUP_COLUMN)
    private String  prodPopup;
	@Column(name=DOWNLOAD_COLUMNS_COLUMN)
    private String  downloadColumns;
	@Column(name=WHERE_CLAUSE_COLUMN)
    private String  whereClause;
	@Column(name=REPORT_COLUMNS_COLUMN)
    private String  reportColumns;
	@Column(name=UNIQUE_ID_COLUMN)
    private String  uniqueId;
    @Column(name=COMMERCIAL_FORMAT_OPTIONS_COLUMN)
    private String  commercialFormatOptions;
    @Column(name=MAX_DOWNLOAD_RECORDS_COLUMN)
    private int     maxDownloadRecords;
    @Column(name=DOWNLOADABLE_COLUMN)
    private boolean downloadable;
    @Column(name=DESCRIPTION_COLUMN)
    private String  description;
    @Column(name=GRLS_COLUMN )
    private String  grls;
    @Column(name=HAS_TILE_SERVER_COLUMN)
    private boolean hasTileServer;
    @Column(name=TILESERVER_LAYER_COLUMN)
    private String  tileLayerName;
    @Column(name=HOME_URL_COLUMN)
    private String  homeUrl;
    @Column(name=MAP_BASE_URL_COLUMN)
    private String   mapBaseUrl;
    @Column(name=MAP_LAYER_NUMBER_COLUMN)
    private String   mapLayerNumber;
    @Column(name=MAP_QUERY_LAYER_COLUMN)
    private int      mapQueryLayer;
    @Column(name=BBOX_SCALE_FILTER_COLUMN)
    private int      bboxScaleFilter;
    @Column(name=BBOX_SCALE_RELATE_COLUMN)
    private int      bboxScaleRelate;
    @Column(name=TAB_NAME_COLUMN)
    private String   tabName;
    @Column(name=CLASSIFICATION_COLUMN)
    private String   classification;
    @Column(name=PRODUCT_LOAD_DATE_COLUMN)
    private Date   productLoadDate;
    @Column(name=PRODUCT_COUNT_COLUMN)
    private int    productCount;
    @Column(name=SECURITY_RELEASABILITY_COLUMN)
    private String securityReleasability;
    @Column(name=RELEASABILITY_DESCRIPTION_COLUMN)
    private String releasabilityDescription; 
    @Column(name=REPORT_PUB_COLUMN)
    private String reportPub;
    @Column(name=PRODUCT_SIZE_BYTES_COLUMN)
    private int    productSizeBytes;
    @Column(name=KML_LAYER_NUMBER_COLUMN)
    private String kmlLayerNumber;
    
	/**
	 * Default constructor.
	 * @param builder The ItemBuilder object.
	 */
    protected Item (ItemBuilder builder) {
        prodName                 = builder.prodName;
        prodTag                  = builder.prodTag;
        prodScale                = builder.prodScale;
        category                 = builder.category;
        subCategory              = builder.subCategory;
        catDesc                  = builder.catDesc;
        prodCcView               = builder.prodCcView;
        prodAorView              = builder.prodAorView;
        prodSourceTable          = builder.prodSourceTable;
        prodNotify               = builder.prodNotify;
        prodPopup                = builder.prodPopup;
        downloadColumns          = builder.downloadColumns;
        whereClause              = builder.whereClause;
        reportColumns            = builder.reportColumns;
        uniqueId                 = builder.uniqueId;
        commercialFormatOptions  = builder.commercialFormatOptions;
        maxDownloadRecords       = builder.maxDownloadRecords;
        downloadable             = builder.downloadable;
        description              = builder.description;
        grls                     = builder.grls;
        hasTileServer            = builder.hasTileServer;
        tileLayerName            = builder.tileLayerName;
        homeUrl                  = builder.homeUrl;
        mapBaseUrl               = builder.mapBaseUrl;
        mapLayerNumber           = builder.mapLayerNumber;
        mapQueryLayer            = builder.mapQueryLayer;
        bboxScaleFilter          = builder.bboxScaleFilter;
        bboxScaleRelate          = builder.bboxScaleRelate;
        tabName                  = builder.tabName;
    	classification           = builder.classification;
    	
    	// Fields added after the JAX-B class generation.
        productLoadDate          = builder.productLoadDate;
        productCount             = builder.productCount;
        securityReleasability    = builder.securityReleasability;
        releasabilityDescription = builder.releasabilityDescription; 
        reportPub                = builder.reportPub;
        productSizeBytes         = builder.productSizeBytes;
        kmlLayerNumber           = builder.kmlLayerNumber;
    }
    
    /**
     * Gets the value of the prodName property.
     * @return possible object is {@link String }    
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * Gets the value of the prodTag property.
     * @return Product tag.  Object is {@link String }
     */
    public String getProdTag() {
        return prodTag;
    }
    
    /**
     * Gets the value of the prodScale property.
     * @return The product scale.  Object is of type {@link String }   
     */
    public String getProdScale() {
        return prodScale;
    }

    /**
     * Gets the value of the category property.
     * @return The product category.  Object is {@link String }   
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the value of the subCategory property.
     * @return Product subcategory.  Object is {@link String }
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * Gets the value of the catDesc property.
     * @return The category description.  Object is {@link String }
     */
    public String getCatDesc() {
        return catDesc;
    }

    /**
     * Gets the value of the prodCcView property.
     * @return The product CC view.  Object is {@link String }
     */
    public String getProdCcView() {
        return prodCcView;
    }

    /**
     * Gets the value of the prodAorView property.
     * @return The product AOR view. Object is {@link String }
     */
    public String getProdAorView() {
        return prodAorView;
    }

    /**
     * Gets the value of the prodSourceTable property.
     * @return Product source data.  Object is {@link String }
     */
    public String getProdSourceTable() {
        return prodSourceTable;
    }

    /**
     * Gets the value of the prodNotify property.
     * @return Product notification data. Object is {@link String }
     */
    public String getProdNotify() {
        return prodNotify;
    }

    /**
     * Gets the value of the prodPopup property.
     * @return The product pop up message.  Object is {@link String } 
     */
    public String getProdPopup() {
        return prodPopup;
    }

    /**
     * Gets the value of the downloadColumns property.
     * @return The download columns.  Object is {@link String }
     */
    public String getDownloadColumns() {
        return downloadColumns;
    }

    /**
     * Gets the value of the whereClause property.
     * @return The where clause.  Object is {@link String }
     */
    public String getWhereClause() {
        return whereClause;
    }
    
    /**
     * Gets the value of the reportColumns property.
     * @return The report columns.  Object is {@link String } 
     */
    public String getReportColumns() {
        return reportColumns;
    }

    /**
     * Gets the value of the uniqueId property.
     * @return The unique ID.  Object is {@link String }
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Gets the value of the commercialFormatOptions property.
     * @return The commercial format options.  Object is {@link String }
     */
    public String getCommercialFormatOptions() {
        return commercialFormatOptions;
    }

    /**
     * Gets the value of the maxDownloadRecords property.
     * @return The maximum number of records that can be downloaded at a time.
     */
    public int getMaxDownloadRecords() {
        return maxDownloadRecords;
    }

    /**
     * Gets the value of the downloadable property.
     * @return Whether or not the product can be downloaded.
     */
    public boolean isDownloadable() {
        return downloadable;
    }

    /**
     * Gets the value of the description property.
     * @return The description.  Object is {@link String }    
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the value of the grls property.
     * @return The GRLS property.  Object is {@link String }     
     */
    public String getGrls() {
        return grls;
    }

    /**
     * Gets the value of the hasTileServer property.
     * @return True if the product has a tile server layer.
     */
    public boolean hasTileServer() {
        return hasTileServer;
    }

    /**
     * Gets the value of the tileLayerName property.
     * @return The name of the tile server layer.  Object is {@link String }
     */
    public String getTileLayerName() {
        return tileLayerName;
    }

    /**
     * Gets the value of the homeUrl property.
     * @return The home URL property.  Object is {@link String }
     */
    public String getHomeUrl() {
        return homeUrl;
    }
    
    /**
     * Gets the value of the mapBaseUrl property.
     * @return The URL for the map URL.  Object is {@link String }
     */
    public String getMapBaseUrl() {
        return mapBaseUrl;
    }

    /**
     * Gets the value of the mapLayerNumber property.
     * @return The map layer number.  Object is {@link String }
     */
    public String getMapLayerNumber() {
        return mapLayerNumber;
    }

    /**
     * Gets the value of the mapQueryLayer property.
     * @return The map query layer number.
     */
    public int getMapQueryLayer() {
        return mapQueryLayer;
    }

    /**
     * Gets the value of the bboxScaleFilter property.
     * @return the bboxScaleFilter value
     */
    public int getBboxScaleFilter() {
        return bboxScaleFilter;
    }
    
    /**
     * Gets the value of the product load date property.
     * @return the product load date
     */
    public Date getProductLoadDate() {
    	return productLoadDate;
    }
    
    /**
     * Gets the value of the product count information.
     * @return the product count
     */
    public int getProductCount() {
    	return productCount;
    }
    
    /**
     * Gets the value of the security releasability
     * @return the security releasability
     */
    public String getSecurityReleasability() { 
    	return securityReleasability;
    }
    
    /**
     * Gets the value of the releasability description
     * @return the releasability description
     */
    public String getReleasabilityDescription() { 
    	return securityReleasability;
    }
    
    /**
     * Gets the value of the report pub
     * @return the report pub
     */
    public String getReportPub() { 
    	return reportPub;
    }
    
    /**
     * Gets the value of the product size
     * @return the product size.
     */
    public int getProductSizeBytes() {
    	return productSizeBytes;
    }
    
    /**
     * Gets the value of the KML layer number.
     * @return the KML layer number.
     */
    public String getKmlLayerNumber() {
    	return kmlLayerNumber;
    }
    
    /**
     * Gets the value of the bboxScaleRelate property.
     * @return the bboxScaleRelate value
     */
    public int getBboxScaleRelate() {
        return bboxScaleRelate;
    }

    /**
     * Gets the value of the tabName property.
     * @return possible object is {@link String } 
     */
    public String getTabName() {
        return tabName;
    }

    /**
     * Gets the value of the classification property.
     * @return possible object is {@link String }
     */
    public String getClassification() {
        return classification;
    }
    
    

    /**
     * Static inner class implementing the builder creation pattern
	 * for objects of type Item.
	 * 
	 * @author L. Craig Carpenter
     */
    public static class ItemBuilder {
        
        protected String  prodName;
        protected String  prodTag;
        protected String  prodScale;
        protected String  category;
        protected String  subCategory;
        protected String  catDesc;
        protected String  prodCcView;
        protected String  prodAorView;
        protected String  prodSourceTable;
        protected String  prodNotify;
        protected String  prodPopup;
        protected String  downloadColumns;
        protected String  whereClause;
        protected String  reportColumns;
        protected String  uniqueId;
        protected String  commercialFormatOptions;
        protected int     maxDownloadRecords = -1;
        protected boolean downloadable  = false;
        protected String  description;
        protected String  grls;
        protected boolean hasTileServer = false;
        protected String  tileLayerName;
        protected String  homeUrl;
        protected String  mapBaseUrl;
        protected String  mapLayerNumber;
        protected int     mapQueryLayer   = -1;
        protected int     bboxScaleFilter = -1;
        protected int     bboxScaleRelate = -1;
        protected String  tabName;
        protected String  classification;
        
        // Fields added after the JAX-B class generation.
        protected Date    productLoadDate = null;
        protected int     productCount = -1;
        protected String  securityReleasability;
        protected String  releasabilityDescription; 
        protected String  reportPub;
        protected int     productSizeBytes = -1;
        protected String  kmlLayerNumber;
        
        /**
         * Sets the value of the bboxScaleFilter property.
         * @param value Bounding box scale filter.
         * @return Reference to the builder object.
         */
        public ItemBuilder bboxScaleFilter(int value) {
            bboxScaleFilter = value;
            return this;
        }
        
        /**
         * Sets the value of the bboxScaleRelate property.
         * @param value Bonding box scale
         * @return Reference to the builder object.
         */
        public ItemBuilder bboxScaleRelate(int value) {
            bboxScaleRelate = value;
            return this;
        }
        
        /**
         * Sets the value of the category property.
         * @param value The product category.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder category(String value) {
            category = value;
            return this;
        }
        
        /**
         * Sets the value of the catDesc property.
         * @param value The category description.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder categoryDesc(String value) {
            catDesc = value;
            return this;
        }
        
        /**
         * Sets the value of the classification property.
         * @param value The classification.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder classification(String value) {
        	classification = value;
            return this;
        }
        
        /**
         * Sets the value of the commercialFormatOptions property.
         * @param value The commercial format options.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder commercialFormatOptions(String value) {
            commercialFormatOptions = value;
            return this;
        }
        
        /**
         * Sets the value of the description property.
         * @param value The product description.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder description(String value) {
            this.description = value;
            return this;
        }
        
        /**
         * Sets the value of the downloadable property.
         * @param value True if the product can be downloaded.
         * @return Reference to the builder object.
         */
        public ItemBuilder downloadable(boolean value) {
            downloadable = value;
            return this;
        }
        
        /**
         * Sets the value of the downloadColumns property.
         * @param value The download columns.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder downloadColumns(String value) {
            downloadColumns = value;
            return this;
        }
        
        /**
         * Sets the value of the grls property.
         * @param value Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder grls(String value) {
            grls = value;
            return this;
        }
        
        /**
         * Sets the value of the hasTileServer property.
         * @param value Indicates whether or not a tile server layer exists. 
         * @return Reference to the builder object.
         */
        public ItemBuilder hasTileServer(boolean value) {
            hasTileServer = value;
            return this;
        }
        
        /**
         * Sets the value of the homeUrl property.
         * @param value The home URL.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder homeUrl(String value) {
            homeUrl = value;
            return this;
        }
        
        /**
         * Sets the value of the kmlLayerNumber property.
         * @param value The KML layer number.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder kmlLayerNumber(String value) {
        	kmlLayerNumber = value;
            return this;
        }
        
        /**
         * Sets the value of the mapLayerNumber property.
         * @param value The map layer number.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder mapLayerNumber(String value) {
            mapLayerNumber = value;
            return this;
        }
        
        /**
         * Sets the value of the mapBaseUrl property.
         * @param value The map base URL.  Object is {@link String } 
         * @return Reference to the builder object.
         */
        public ItemBuilder mapBaseUrl(String value) {
            this.mapBaseUrl = value;
            return this;
        }
        
        /**
         * Sets the value of the mapQueryLayer property.
         * @param value The map query layer number. 
         * @return Reference to the builder object.
         */
        public ItemBuilder mapQueryLayer(int value) {
            mapQueryLayer = value;
            return this;
        }
        
        /**
         * Sets the value of the maxDownloadRecords property.
         * @param value The maximum number of downloadable records. 
         * @return Reference to the builder object.
         */
        public ItemBuilder maxDownloadRecords(int value) {
            this.maxDownloadRecords = value;
            return this;
        }
        
        /**
         * Sets the value of the prodAorView property.
         * @param value The product AOR view.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder prodAorView(String value) {
            prodAorView = value;
            return this;
        }
        
        /**
         * Sets the value of the prodCcView property.
         * @param value Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder prodCcView(String value) {
            prodCcView = value;
            return this;
        }
        
        /**
         * Sets the number of products contained.
         * @param value Number of individual products stored. 
         * @return Reference to the builder object.
         */
        public ItemBuilder prodCount(int value) {
            productCount = value;
            return this;
        }
        
        /**
         * Sets the value of the prodName property.
         * @param value The product name.  Object is {@link String }
         * @return Reference to the builder object.   
         */
        public ItemBuilder prodName(String value) {
            prodName = value;
            return this;
        }
        
        /**
         * Sets the value of the prodNotify property.
         * @param value Information associated with the product.  
         * Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder prodNotify(String value) {
            prodNotify = value;
            return this;
        }
        
        /**
         * Sets the value for the last product load date.
         * @param value The product load date. 
         * Object is {@link Date }
         * @return Reference to the builder object.
         */
        public ItemBuilder prodLoadDate(Date value) {
            productLoadDate = value;
            return this;
        }
        
        /**
         * Sets the value for the size of the products.
         * @param value The product size. 
         * Object is {@link int }
         * @return Reference to the builder object.
         */
        public ItemBuilder productSizeBytes(int value) {
        	productSizeBytes = value;
            return this;
        }
        
        
        /**
         * Sets the value of the releasability description.
         * @param value The releasability description.  Object is {@link String }    
         * @return Reference to the builder object.
         */
        public ItemBuilder releasabilityDescription(String value) {
        	releasabilityDescription = value;
            return this;
        }
        
        /**
         * Sets the value of the report publication.
         * @param value The report publication.  Object is {@link String }    
         * @return Reference to the builder object.
         */
        public ItemBuilder reportPub(String value) {
        	reportPub = value;
            return this;
        }
        
        /**
         * Sets the value of the prodPopup property.
         * @param value The product pop-up information.  Object is {@link String }    
         * @return Reference to the builder object.
         */
        public ItemBuilder prodPopup(String value) {
            prodPopup = value;
            return this;
        }
        
        /**
         * Sets the value of the prodScale property.
         * @param value The product scale.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder prodScale(String value) {
            prodScale = value;
            return this;
        }
        
        /**
         * Sets the value of the prodSourceTable property.
         * @param value The product source table.  Object is {@link String }
         * @return Reference to the builder object. 
         */
        public ItemBuilder prodSourceTable(String value) {
            prodSourceTable = value;
            return this;
        }
        
        /**
         * Sets the value of the prodTag property.
         * @param value The product tag.  Object is {@link String }
         * @return Reference to the builder object. 
         */
        public ItemBuilder prodTag(String value) {
            prodTag = value;
            return this;
        }
        
        /**
         * Sets the value of the reportColumns property.
         * @param value The name of the report columns.  
         * Object is {@link String }  
         */
        public ItemBuilder reportColumns(String value) {
            reportColumns = value;
            return this;
        }
        
        /**
         * Sets the value of the security releasability property.
         * @param value The releasability of the product.  
         * Object is {@link String }
         */
        public ItemBuilder securityReleasability(String value) {
            securityReleasability = value;
            return this;
        }
        
        /**
         * Sets the value of the subCategory property.
         * @param value The product sub-category.  Object is {@link String }
         */
        public ItemBuilder subCategory(String value) {
            this.subCategory = value;
            return this;
        }
        
        /**
         * Sets the value of the tabName property.
         * @param value Allowed object is {@link String }
         * @return Reference to the builder object.   
         */
        public ItemBuilder tabName(String value) {
            tabName = value;
            return this;
        }
        
        /**
         * Sets the value of the tileLayerName property.
         * @param value Object is {@link String }
         * @return Reference to the builder object.     
         */
        public ItemBuilder tileLayerName(String value) {
            tileLayerName = value;
            return this;
        }

        /**
         * Sets the value of the uniqueId property.
         * @param value The unique ID.  Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder uniqueId(String value) {
            uniqueId = value;
            return this;
        }
        
        /**
         * Sets the value of the whereClause property.
         * @param value The where clause for the actual product information.
         * Object is {@link String }
         * @return Reference to the builder object.
         */
        public ItemBuilder whereClause(String value) {
            whereClause = value;
            return this;
        }
        
        /**
         * Validate the product record.
         * @param product The product record to validate.
         * @throws IllegalStateException Thrown if any issues are discovered 
         * with the product object. 
         */
        public void validateProduct(Item product) 
        		throws IllegalStateException {
        	
        	if ((product.getProdTag() == null) || 
        			(product.getProdTag().isEmpty())) { 
        		throw new IllegalStateException("Product found with product "
        				+ "tag [ "
        				+ " ] null or not populated.");
        	}
        	if ((product.getProdName() == null) || 
        			(product.getProdName().isEmpty())) { 
        		throw new IllegalStateException("Product found with product "
        				+ "name [ "
        				+ " ] null or not populated.");
        	}
        }
    }
}
