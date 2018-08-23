package mil.nga.gdp.messages;

import java.io.Serializable;
import java.util.Map;

import mil.nga.gdp.GDPConstantsI;

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
	 * Default constructor.
	 * @param builder The builder object.
	 */
	protected ProductsByWKT(ProductsByWKTBuilder builder) {
		super(builder);
		wktString  = builder.wktString;
	}
	
	/**
	 * Getter method for the requested well known text (WKT) String.
	 * @return Client supplied WKT String.
	 */
	public String getWKTString() {
		return wktString;
	}

    /**
     * Internal static class implementing the builder creation pattern for new
     * ProductsByUnit objects.
     * 
     * @author L. Craig Carpenter
     */
    public static class ProductsByWKTBuilder
    	extends ProductMessage.ProductMessageBuilder
    		<ProductsByWKTBuilder> {
    	
    	private String wktString = null;
    	
    	/**
    	 * Method to actually construct a concrete object of type 
    	 * ProductsByWKT.
    	 */
    	public ProductsByWKT build() throws IllegalStateException {
    		ProductsByWKT obj = new ProductsByWKT(this);
    		validateProductsByWKT(obj);
    		return obj;
    	}
    	
    	/**
    	 * Setter method for the requested well-known-text String.
    	 * 
    	 * @param value Client supplied well-known-text String.
    	 */
    	public ProductsByWKTBuilder wktString(String value) {
    		wktString = value;
    		return this;
    	}
    	
    	/**
    	 * Alternate constructor allowing clients to supply the required input 
    	 * parameters embedded in a Map data structure.
    	 * 
    	 * @param map List of key/value pairs containing all required input 
    	 * parameters.
    	 */
    	public ProductsByWKTBuilder fromMessage(Map<String, String> map) {
    		if ((map != null) && (map.size() > 0)) {
    			super.fromMessage(map);
    			wktString(map.get(WKT_INPUT_PARAM));
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
        public void validateProductsByWKT(ProductsByWKT obj) 
        		throws IllegalStateException {
        	if ((obj.getWKTString() == null) || 
        			(obj.getWKTString().isEmpty())) {  
        		throw new IllegalStateException("WKT string is null or not "
        				+ "defined.");
        	}
        }
    }
}
