package mil.nga.gdp.messages;

import java.io.Serializable;
import java.util.Map;

import mil.nga.gdp.types.BoundingBox;

/**
 * Class encapsulating the data supplied by clients when they want to extract 
 * products intersecting a bounding box.
 * 
 * @author L. Craig Carpenter
 */
public class ProductsByBBox 
		extends ProductMessage implements Serializable {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = 310352907802137029L;
	
	private final double lowerLeftLon;
	private final double lowerLeftLat;
	private final double upperRightLon;
	private final double upperRightLat;
	
	/**
	 * Default constructor.
	 * @param builder The builder object.
	 */
	protected ProductsByBBox(ProductsByBBoxBuilder builder) {
		super(builder);
		lowerLeftLon  = builder.lowerLeftLon;
		lowerLeftLat  = builder.lowerLeftLat;
		upperRightLon = builder.upperRightLon;
		upperRightLat = builder.upperRightLat;
	}
	
	/**
	 * Getter method for the bounding box object. 
	 * @return BoundingBox object.
	 */
	public BoundingBox getBBox() {
		BoundingBox box = new BoundingBox();
		box.setLowerLeftLat(lowerLeftLat);
		box.setLowerLeftLon(lowerLeftLon);
		box.setUpperRightLat(upperRightLat);
		box.setUpperRightLon(upperRightLon);
		return box;
	}
	
    /**
     * Gets the left latitude value for this bounding box.
     * @return The lower left latitude of the bounding box.
     */
    public double getLowerLeftLat() {
        return lowerLeftLat;
    }
    
    /**
     * Gets the lower left Longitude value for this bounding box.
     * @return The lower left Longitude of the bounding box.
     */
    public double getLowerLeftLon() {
        return lowerLeftLon;
    }
    
	/**
     * Gets the upper right Latitude value for this bounding box.
     * @return The upper right Latitude of the bounding box.
     */
    public double getUpperRightLat() {
        return upperRightLat;
    }
    
    /**
     * Gets the upper right Longitude value for this bounding box.
     * @return The upper right Longitude of a bounding box.
     */
    public double getUpperRightLon() {
        return upperRightLon;
    }
    
    /**
     * Convert the input message into a String-base format.
     */
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Input request: ");
    	sb.append(super.toString());
    	sb.append("BBox: lower left lat => [ ");
    	sb.append(getLowerLeftLat());
    	sb.append(" ], lower left lon => [ ");
    	sb.append(getLowerLeftLon());
    	sb.append(" ], upper right lat => [ ");
    	sb.append(getUpperRightLat());
    	sb.append(" ], upper right lon => [ ");
    	sb.append(getUpperRightLon());
    	sb.append(" ].");
    	return sb.toString();
    }
    
    /**
     * Internal static class implementing the builder creation pattern for new
     * ProductByBBox objects.
     * 
     * @author L. Craig Carpenter
     */
    public static class ProductsByBBoxBuilder 
    	extends ProductMessage.ProductMessageBuilder
    		<ProductsByBBoxBuilder> {
    	
    	private double lowerLeftLon  = 0.0;
    	private double lowerLeftLat  = 0.0;
    	private double upperRightLon = 0.0;
    	private double upperRightLat = 0.0;
    	
    	/**
    	 * Alternate constructor allowing clients to supply the required input 
    	 * parameters embedded in a Map data structure.
    	 * 
    	 * @param map List of key/value pairs containing all required input 
    	 * parameters.
    	 */
    	public ProductsByBBoxBuilder fromMessage (Map<String, String> map) {
    		if ((map != null) && (map.size() > 0)) {
    			super.fromMessage(map);
    			bBox(map.get(BBOX_INPUT_PARAM));
    		}
    		return this;
    	}
    	
    	/**
    	 * Setter method for the bounding box parameters.  This version accepts a 
    	 * String.  Most of the logic was copied from the original GDP 
    	 * implementation.
    	 * 
    	 * @param value A String containing the bounding box parameters in the 
    	 * format lower left lon, lower left lat, upper right lon, upper right lat
    	 * @return Reference to the builder object.
    	 */
    	public ProductsByBBoxBuilder bBox(String value) throws IllegalStateException {
    		if ((value != null) && (!value.isEmpty())) { 
    			String[] coords = value.split(",");
    			if (coords.length == 4) {
    				try {
    					lowerLeftLon  = Double.valueOf(coords[0]);
    				}
    				catch (NumberFormatException nfe1) {
    					throw new IllegalStateException(
    							"Unable to convert lower-left longitude "
    							+ "to a double.  Value supplied => [ "
    							+ coords[0]
    							+ " ], error message => [ "
    							+ nfe1.getMessage()
    							+ " ].");
    				}
    				try {
    					lowerLeftLat  = Double.valueOf(coords[1]);
    				}
    				catch (NumberFormatException nfe2) {
    					throw new IllegalStateException(
    							"Unable to convert lower-left latitude "
    							+ "to a double.  Value supplied => [ "
    							+ coords[1]
    							+ " ], error message => [ "
    							+ nfe2.getMessage()
    							+ " ].");
    				}
    				try {
    					upperRightLon = Double.valueOf(coords[2]);
    				}
    				catch (NumberFormatException nfe3) {
    					throw new IllegalStateException(
    							"Unable to convert upper-right longitude "
    							+ "to a double.  Value supplied => [ "
    							+ coords[2]
    							+ " ], error message => [ "
    							+ nfe3.getMessage()
    							+ " ].");
    				}
    				try {
    					upperRightLat = Double.valueOf(coords[3]);
    				}
    				catch (NumberFormatException nfe4) {
    					throw new IllegalStateException(
    							"Unable to convert upper-right latitude "
    							+ "to a double.  Value supplied => [ "
    							+ coords[3]
    							+ " ], error message => [ "
    							+ nfe4.getMessage()
    							+ " ].");
    				}
    			}
    			else {
    				throw new IllegalStateException("Bounding box must be in "
    						+ "the following format: \"LON1, LAT1, LON2, "
    						+ "LAT2\"");
    			}
    		}
    		else {
    			throw new IllegalStateException("String defining the "
    					+ "requested bounding box is null or empty.");
    		}
    		return this;
    	}
    	
    	/**
    	 * Setter method for the bounding box parameters. 
    	 * 
    	 * @param value BBOX object from the class 
    	 * <code>GetProductsBBOXmessage</code>).
    	 */
    	public ProductsByBBoxBuilder bBox(BoundingBox value) {
    		lowerLeftLat  = value.getLowerLeftLat();
    		lowerLeftLon  = value.getLowerLeftLon();
    		upperRightLat = value.getUpperRightLat();
    		upperRightLon = value.getUpperRightLon();
    		return this;
    	}
    	
    	/**
    	 * Method to actually construct a concrete object of type ProductByBBox
    	 */
    	public ProductsByBBox build() throws IllegalStateException {
    		ProductsByBBox obj = new ProductsByBBox(this);
    		validateProductByBBox(obj);
    		return obj;
    	}
    	
    	/**
    	 * Setter method for the lower-left longitude value of the 
    	 * bounding box.
    	 * 
    	 * @param value The lower-left longitude.
    	 * @return Reference to the builder object.
    	 */
    	public ProductsByBBoxBuilder lowerLeftLon(double value) {
    		lowerLeftLon = value;
    		return this;
    	}
    	
        /**
         * Setter method for the lower left latitude value of the 
         * bounding box.
         * 
         * @param value The lower left latitude.
         * @return Reference to the builder object.
         */
        public ProductsByBBoxBuilder lowerLeftLat(double value) {
            lowerLeftLat = value;
            return this;
        }
        
    	/**
    	 * Setter method for the upper-right longitude value of the 
    	 * bounding box.
    	 * 
    	 * @param value The upper-right longitude.
    	 * @return Reference to the builder object.
    	 */
    	public ProductsByBBoxBuilder upperRightLon(double value) {
    		upperRightLon = value;
    		return this;
    	}
    	
        /**
         * Setter method for the upper right latitude value of the 
         * bounding box.
         * @param value The upper right latitude.
         * @return Reference to the builder object.
         */
        public ProductsByBBoxBuilder upperRightLat(double value) {
        	upperRightLat = value;
            return this;
        }
        
        /**
         * Validation for the bounding box.
         * 
         * @param obj Constructed object to test.
         * @throws IllegalStateException Thrown if there are inconsistencies 
         * in the input data.
         */
        public void validateProductByBBox(ProductsByBBox obj) 
        		throws IllegalStateException {
        	if (lowerLeftLat > upperRightLat) {
        		throw new IllegalStateException("Inconsistent bounding box.  "
        				+ "Lower left lat is greater than upper right lat.");
        	}
        	if (lowerLeftLon > upperRightLon) {
        		throw new IllegalStateException("Inconsistent bounding box.  "
        				+ "Lower left lon is greater than upper right lon.");
        	}
        }
    }
}
