package mil.nga.gdp.messages;

import java.io.Serializable;
import java.util.Map;

import mil.nga.gdp.GDPConstantsI;

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
	
	private final String code;
	private final String aorOrCode;
	
	/**
	 * Default constructor required by JAX-B.
	 */
	protected ProductsByAORJMPCode(ProductsByAORJMPCodeBuilder builder) {
		super(builder);
		code      = builder.code;
		aorOrCode = builder.aorOrCode;
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
     * Convert the input message into a String-base format.
     */
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Input request: ");
    	sb.append(super.toString());
    	sb.append("Code => [ ");
    	sb.append(getCode());
    	sb.append(" ], aorOrCode => [ ");
    	sb.append(getAorOrCode());
    	sb.append(" ].");
    	return sb.toString();
    }

    /**
     * Internal static class implementing the builder creation pattern for new
     * ProductByBBox objects.
     * 
     * @author L. Craig Carpenter
     */
    public static class ProductsByAORJMPCodeBuilder 
    	extends ProductMessage.ProductMessageBuilder
    		<ProductsByAORJMPCodeBuilder> {
    	
    	private String code      = null;
    	private String aorOrCode = null;
    	
    	/**
    	 * Method used to actually construct the concrete object.
    	 * @throws IllegalStateException Thrown if there are inconsistencies
    	 * in the input request.
    	 */
    	public ProductsByAORJMPCode build() throws IllegalStateException {
    		ProductsByAORJMPCode obj = new ProductsByAORJMPCode(this);
    		validateProductsByAORJMPCodeObj(obj);
    		return obj;
    	}
    	
    	/**
    	 * Setter method for the requested code String.
    	 * @param value Client supplied code.
    	 */
    	public ProductsByAORJMPCodeBuilder code(String value) {
    		code = value;
    		return this;
    	}
    	
    	/**
    	 * Setter method for the requested AOR String.
    	 * @param value Client supplied AOR String
    	 */
    	public ProductsByAORJMPCodeBuilder aorOrCode(String value) {
    		aorOrCode = value;
    		return this;
    	}
    	
    	/**
    	 * Alternate constructor allowing clients to supply the required input 
    	 * parameters embedded in a Map data structure.
    	 * 
    	 * @param map List of key/value pairs containing all required input 
    	 * parameters.
    	 * @throws IllegalStateException Thrown if the input map is not 
    	 * populated.
    	 */
    	public ProductsByAORJMPCodeBuilder fromMessage(
    			Map<String, String> map) throws IllegalStateException {
    		if ((map != null) && (map.size() > 0)) {
    			super.fromMessage(map);
    			code(map.get(CODE_INPUT_PARAM));
    			aorOrCode(map.get(AOR_INPUT_PARAM));
    		}
    		return this;
    	}
    	
    	/**
    	 * Validate the constructed message object.
    	 * @param obj Object to validate.
   	     * @throws IllegalStateException Thrown if there are inconsistencies
    	 * in the constructed object.
    	 */
    	public void validateProductsByAORJMPCodeObj(ProductsByAORJMPCode obj) 
    			throws IllegalStateException {
    		if (((obj.getAorOrCode() == null) || 
    				(obj.getAorOrCode().isEmpty()))
    			&& ((obj.getCode() == null) || 
    					(obj.getCode().isEmpty()))) {
    			throw new IllegalStateException("Either the AorOrCode or Code field "
    					+ "must be populated.  Both cannot be empty.");
    		}
    	}
    }
}