package mil.nga.gdp.messages;

import java.io.Serializable;
import java.util.Map;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.exceptions.InvalidParameterException;
import mil.nga.gdp.types.BoundingBox;

/**
 * Class encapsulating the data supplied by clients when they want to extract 
 * products intersecting a bounding box.
 * 
 * @author L. Craig Carpenter
 */
public class ProductsByBBox 
		extends ProductMessage implements Serializable, GDPConstantsI {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = 310352907802137029L;
	
	private double  lowerLeftLon  = 0.0;
	private double  lowerLeftLat  = 0.0;
	private double  upperRightLon = 0.0;
	private double  upperRightLat = 0.0;
	
	/**
	 * Default constructor required by JAX-B.
	 */
	public ProductsByBBox() {}
	
	/**
	 * Alternate constructor allowing clients to supply the required input 
	 * parameters embedded in a Map data structure.
	 * 
	 * @param map List of key/value pairs containing all required input 
	 * parameters.
	 */
	public ProductsByBBox (Map<String, String> map) 
			throws InvalidParameterException {
		super(map);
		if ((map != null) && (map.size() > 0)) {
			setBBox(map.get(BBOX_INPUT_PARAM));
		}
		else {
			throw new InvalidParameterException("Unable to parse input URL "
					+ "parameters.  The input list of parameters is null or "
					+ "contains no elements.");
		}
	}
	

	
	/**
	 * Getter method for the bounding box object. 
	 * 
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
     * 
     * @return The lower left latitude of the bounding box.
     */
    public double getLowerLeftLat() {
        return lowerLeftLat;
    }

    /**
     * Sets the lower left latitude value for this bounding box.
     * 
     * @param value The lower left latitude of the bounding box.
     */
    public void setLowerLeftLat(double value) {
        lowerLeftLat = value;
    }
    
    /**
     * Gets the lower left Longitude value for this bounding box.
     * 
     * @return The lower left Longitude of the bounding box.
     */
    public double getLowerLeftLon() {
        return lowerLeftLon;
    }
    
	/**
     * Gets the upper right Latitude value for this bounding box.
     * 
     * @return The upper right Latitude of the bounding box.
     */
    public double getUpperRightLat() {
        return upperRightLat;
    }
    
    /**
     * Gets the upper right Longitude value for this bounding box.
     * 
     * @return The upper right Longitude of a bounding box.
     */
    public double getUpperRightLon() {
        return upperRightLon;
    }
    
	/**
	 * Setter method for the bounding box parameters. 
	 * 
	 * @param value BBOX object from the class 
	 * <code>GetProductsBBOXmessage</code>).
	 */
	public void setBBox(BoundingBox value) {
		lowerLeftLat = value.getLowerLeftLat();
		lowerLeftLon = value.getLowerLeftLon();
		upperRightLat = value.getUpperRightLat();
		upperRightLon = value.getUpperRightLon();
	}
	
	/**
	 * Setter method for the bounding box parameters.  This version accepts a 
	 * String.  Most of the logic was copied from the original GDP 
	 * implementation.
	 * 
	 * @param value A String containing the bounding box parameters in the 
	 * format lower left lon, lower left lat, upper right lon, upper right lat
	 */
	public void setBBox(String value) throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) { 
			String[] coords = value.split(",");
			if (coords.length == 4) {
				lowerLeftLon  = Double.valueOf(coords[0]);
				lowerLeftLat  = Double.valueOf(coords[1]);
				upperRightLon = Double.valueOf(coords[2]);
				upperRightLat = Double.valueOf(coords[3]);
			}
			else {
				throw new InvalidParameterException("Bounding box must be in "
						+ "the following format: \"LON1, LAT1, LON2, LAT2\"");
			}
		}
		else {
			throw new InvalidParameterException("String defining the "
					+ "requested bounding box is null or empty.");
		}
	}
	
    /**
     * Sets the lower left Longitude value for this bounding box.
     * 
     * @param value The lower left Longitude of the bounding box.
     */
    public void setLowerLeftLon(double value) {
        lowerLeftLon = value;
    }
	
    /**
     * Sets the upper right Latitude value for this bounding box.
     * 
     * @param value The upper right Latitude of the bounding box.
     */
    public void setUpperRightLat(double value) {
        upperRightLat = value;
    }
    
    /**
     * Sets the upper right Longitude value for this bounding box.
     * 
     * @param The upper right Longitude of a bounding box.
     */
    public void setUpperRightLon(double value) {
        upperRightLon = value;
    }
}
