package mil.nga.npd.utils;

import mil.nga.elevation.BboxBean;
import mil.nga.elevation.GeodeticCoordinateBean;
import mil.nga.npd.BoundingBox;
import mil.nga.npd.GeodeticCoordinate;

/** 
 * Singleton convenience class used to convert between WSDL-generated types
 * and associated internal types.
 * 
 * @author L. Craig Carpenter
 */
public class TypeConverter {

	/**
	 * Convert a <code>BoundingBox</code> to a new object of WSDL-generated
	 * type <code>BboxBean</code>.
	 * 
	 * @param bbox A populated object of type <code>BoundingBox</code>.
	 * @return An equivalent object of type <code>BboxBean</code>.
	 * @throws IllegalStateException Thrown if the input data is null.
	 */
	public static BboxBean convert(BoundingBox bbox) {
		BboxBean bean = null;
		if (bbox != null) {
			bean = new BboxBean();
			bean.setLllat(Double.toString(bbox.getLowerLeftLat()));
			bean.setLllon(Double.toString(bbox.getLowerLeftLon()));
			bean.setUrlat(Double.toString(bbox.getUpperRightLat()));
			bean.setUrlon(Double.toString(bbox.getUpperRightLon()));
		}
		else {
			throw new IllegalStateException("The input BoundingBox is null.");
		}
		return bean;
	}

	/**
	 * Create a <code>GeodeticCoordinateBean</code> object from the 
	 * data contained by this object.
	 * @return A constructed <code>GeodeticCoordinateBean</code> object.
	 */
	public static GeodeticCoordinateBean convert(GeodeticCoordinate coord) {
		GeodeticCoordinateBean bean = new GeodeticCoordinateBean();
		if (coord != null) {
			bean = new GeodeticCoordinateBean();
			bean.setLat(String.valueOf(coord.getLat()));
			bean.setLon(String.valueOf(coord.getLon()));
		}
		else {
			throw new IllegalStateException("The input GeodeticCoordinate is null.");
		}
		return bean;
	}
}
