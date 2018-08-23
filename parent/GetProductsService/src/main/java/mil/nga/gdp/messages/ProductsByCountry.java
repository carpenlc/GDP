package mil.nga.gdp.messages;

import java.io.Serializable;
import java.util.Map;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.exceptions.InvalidParameterException;
import mil.nga.gdp.messages.ProductsByAORJMPCode.ProductsByAORJMPCodeBuilder;
import mil.nga.gdp.messages.ProductsByBBox.ProductsByBBoxBuilder;

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
	
	private final String countryCode;
	private final String state;
	
	/**
	 * Default constructor.
	 * @param builder The builder object.
	 */
	protected ProductsByCountry(ProductsByCountryBuilder builder) {
		super(builder);
		countryCode = builder.countryCode;
		state       = builder.state;
	}
	
	/**
	 * Getter method for the requested country code.
	 * @return Client supplied country code.
	 */
	public String getCountryCode() {
		return countryCode;
	}
	
	
	/**
	 * Getter method for the State
	 * @return Client supplied State.
	 */
	public String getState() {
		return state;
	}
	
    /**
     * Convert the input message into a String-base format.
     */
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Input request (ProductsByCountry) : ");
    	sb.append(super.toString());
    	sb.append("Country => [ ");
    	sb.append(getCountryCode());
    	if (getState() != null) {
    		sb.append(" ], State => [ ");
    		sb.append(getState());
    	}
    	sb.append(" ].");
    	
    	return sb.toString();
    }
    
    /**
     * Internal static class implementing the builder creation pattern for new
     * ProductsByCountry objects.
     * 
     * @author L. Craig Carpenter
     */
    public static class ProductsByCountryBuilder 
    	extends ProductMessage.ProductMessageBuilder
    		<ProductsByCountryBuilder> {
    	
    	private String countryCode = null; 
    	private String state       = null;
    	
    	/**
    	 * Method to actually construct a concrete object of type 
    	 * ProductsByCountry
    	 */
    	public ProductsByCountry build() throws IllegalStateException {
    		ProductsByCountry obj = new ProductsByCountry(this);
    		validateProductsByCountry(obj);
    		return obj;
    	}
    	
    	/**
    	 * Setter method for the requested country code String.
    	 * 
    	 * @param value Client supplied country code.
    	 * @throws InvalidParameterException Thrown if the input tag is null or 
    	 * empty.
    	 */
    	public ProductsByCountryBuilder countryCode(String value) {
    		countryCode = value;
    		return this;
    	}
    	
    	/**
    	 * Setter method for the requested state String.
    	 * 
    	 * @param value Client supplied state.
    	 * @throws InvalidParameterException Thrown if the input tag is null or 
    	 * empty.
    	 */
    	public ProductsByCountryBuilder state(String value) {
    		state = value;
    		return this;
    	}
    	
    	/**
    	 * Method allowing clients to supply the required input 
    	 * parameters embedded in a Map data structure.
    	 * 
    	 * @param map List of key/value pairs containing all required input 
    	 * parameters.
    	 */
    	public ProductsByCountryBuilder fromMessage(Map<String, String> map) {
    		if ((map != null) && (map.size() > 0)) {
    			super.fromMessage(map);
    			countryCode(map.get(COUNTRY_CODE_INPUT_PARAM));
    			state(map.get(STATE_CODE_INPUT_PARAM));
    		}
    		return this;
    	}
    	
        /**
         * Validation for the query by country code.
         * 
         * @param obj Constructed object to test.
         * @throws IllegalStateException Thrown if there are inconsistencies 
         * in the input data.
         */
        public void validateProductsByCountry(ProductsByCountry obj) 
        		throws IllegalStateException {
        	if ((obj.getCountryCode() == null) || 
        			(obj.getCountryCode().isEmpty())) {  
        		throw new IllegalStateException("Country code is null or not "
        				+ "defined.");
        	}
        	else {
        		if (obj.getCountryCode().equalsIgnoreCase(QUERY_BY_COMMAND)) { 
        			if ((obj.getState() == null) || (obj.getState().isEmpty())) {
        				throw new IllegalStateException("Client requested a "
        						+ "query by command code [ "
        						+ QUERY_BY_COMMAND
        						+ " ] but the command field [ "
        						+ STATE_CODE_INPUT_PARAM
        						+ " ] is empty");
        			}
        		}
        		if (obj.getCountryCode().equalsIgnoreCase(QUERY_BY_JUMP_CODE)) { 
        			if ((obj.getState() == null) || (obj.getState().isEmpty())) {
        				throw new IllegalStateException("Client requested a "
        						+ "query by jump code [ "
        						+ QUERY_BY_JUMP_CODE
        						+ " ] but the code field [ "
        						+ STATE_CODE_INPUT_PARAM
        						+ " ] is empty");
        			}
        		}
        	}
        }
    }
}
