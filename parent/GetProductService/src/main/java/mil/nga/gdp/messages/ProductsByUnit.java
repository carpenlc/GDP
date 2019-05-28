package mil.nga.gdp.messages;

import java.io.Serializable;
import java.util.Map;

import mil.nga.gdp.GDPConstantsI;

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
	
	private final String downloadID;

	/**
	 * Default constructor.
	 * @param builder The builder object.
	 */
	protected ProductsByUnit(ProductsByUnitBuilder builder) {
		super(builder);
		downloadID  = builder.downloadID;
	}

	/**
	* Getter method for the requested download ID String.
	* @return Client supplied download ID
	*/
	public String getDownloadID() {
		return downloadID;
	}

    /**
     * Internal static class implementing the builder creation pattern for new
     * ProductsByUnit objects.
     * 
     * @author L. Craig Carpenter
     */
    public static class ProductsByUnitBuilder
    	extends ProductMessage.ProductMessageBuilder
    		<ProductsByUnitBuilder> {
    	
    	private String downloadID = null;
    	
    	/**
    	 * Method to actually construct a concrete object of type 
    	 * ProductsByUnit.
    	 */
    	public ProductsByUnit build() throws IllegalStateException {
    		ProductsByUnit obj = new ProductsByUnit(this);
    		validateProductsByUnit(obj);
    		return obj;
    	}
    	
    	/**
    	 * Setter method for the requested download ID.
    	 * 
    	 * @param value Client supplied download ID.
    	 */
    	public ProductsByUnitBuilder downloadID(String value) {
    		downloadID = value;
    		return this;
    	}
    	
    	/**
    	 * Alternate constructor allowing clients to supply the required input 
    	 * parameters embedded in a Map data structure.
    	 * 
    	 * @param map List of key/value pairs containing all required input 
    	 * parameters.
    	 */
    	public ProductsByUnitBuilder fromMessage(Map<String, String> map) {
    		if ((map != null) && (map.size() > 0)) {
    			super.fromMessage(map);
    			downloadID(map.get(DOWNLOAD_ID_INPUT_PARAM));
    		}
    		return this;
    	}
    	
        /**
         * Validation for the input request.
         * 
         * @param obj Constructed object to test.
         * @throws IllegalStateException Thrown if there are inconsistencies 
         * in the input data.
         */
        public void validateProductsByUnit(ProductsByUnit obj) 
        		throws IllegalStateException {
        	if ((obj.getDownloadID() == null) || 
        			(obj.getDownloadID().isEmpty())) {  
        		throw new IllegalStateException("Download ID is null or not "
        				+ "defined.");
        	}
        }
    }
}
