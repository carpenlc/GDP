package mil.nga.npd;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbn.openmap.dataAccess.dted.DTEDFrame;

import mil.nga.elevation.HeightUnitType;
import mil.nga.elevation.TerrainDataType;

/**
 * This class is responsible for retrieving the elevation extremes from a 
 * from a target DEM file.  It will query a DEM file, or subset of a DEM 
 * file (defined by polygon) to find the minimum and maximum elevation posts
 * contained.
 */
public class ElevationExtremesFactory implements Constants {

    /**
     * Set up the Logback system for use throughout the class.
     */
    private static final Logger LOGGER = 
            LoggerFactory.getLogger(ElevationExtremesFactory.class);
    
    private final String          filePath;
	private final String          classificationMarking;
    private final HeightUnitType  units;
    private final TerrainDataType sourceType;
    
	/**
	 * Default constructor enforcing the builder creation pattern.
	 * @param builder Object containing default values for the private final
	 * internal parameters.
	 */
    protected ElevationExtremesFactory(
    		ElevationExtremesFactoryBuilder builder) {
    	filePath              = builder.filePath;
    	sourceType            = builder.sourceType;
    	units                 = builder.units;
    	classificationMarking = builder.classificationMarking;
    }
    
    /**
     * The classification marking associated with the target DEM file.
     * @return The classification marking.
     */
    public String getClassificationMarking() {
    	return classificationMarking;
    }
    
    /**
     * This method will construct a <code>BoundingBox</code> object that 
     * represents the intersection of the two input <code>BoundingBox</code>
     * objects.  If there is no intersection the return value will be null.
     * 
     * @param bbox1
     * @param bbox2
     * @return
     */
    public BoundingBox getIntersection(
    		BoundingBox bbox1, 
    		BoundingBox bbox2) {
    	BoundingBox intersection = null;
    	
    	return intersection;
    }
    /**
     * This method will determine the minimum and maximum elevation points 
     * that fall within the DEM frame identified by the input file path.
     * 
     * @return Data structure containing the miniumum and maximum elevation
     * points.
     * @throws IllegalStateException Thrown if there are any validation 
     * problems with the any of the return data.  Callers should check the
     * exception message for more information.
     */
	public MinMaxElevation getMinMaxElevation() {
		
		int       minElevation    = 32767;
		int       maxElevation    = -32767;
		int       postCounter     = 0;
		long      startTime       = System.currentTimeMillis();
		double    maxElevationLat = 0.0;
		double    maxElevationLon = 0.0;
		double    minElevationLat = 0.0;
		double    minElevationLon = 0.0;
		double    currentLat      = 0;
		double    currentLon      = 0;
		
		DTEDFrame       frame  = null;
		MinMaxElevation result = null;
		
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Loading DEM frame file [ "
						+ getFilePath()
						+ " ].");
			}
			frame = new DTEDFrame(getFilePath());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("DEM frame file [ "
						+ getFilePath()
						+ " ] loaded in [ "
						+ (System.currentTimeMillis() - startTime)
						+ " ] ms.");
			}
			
			// Reset the time
			startTime = System.currentTimeMillis();
			
			// Generate the bounding box that contains the entire target
			// frame
			BoundingBox frameBounds = new BoundingBox.BoundingBoxBuilder()
					.lowerLeftLat(frame.getOMGrid().getLatitude())
					.lowerLeftLon(frame.getOMGrid().getLongitude())
					.upperRightLat(frame.getOMGrid().getLatitude()+1.0)
					.upperRightLon(frame.getOMGrid().getLongitude()+1.0)
					.build();
            
			// Collect the frame accuracy data
			DEMFrameAccuracy accuracy = 
					new DEMFrameAccuracy.DEMFrameAccuracyBuilder()
						.absHorzAccuracy(frame.acc.abs_horz_acc)
						.absVertAccuracy(frame.acc.abs_vert_acc)
						.relHorzAccuracy(frame.acc.rel_horz_acc)
						.relVertAccuracy(frame.acc.rel_vert_acc)
						.units(getUnits())
						.build();
			
			// The lat/lon post spacing allows us to calculate the lat/lon 
			// position of each elevation post.
			double latPostSpacing = frame.getOMGrid().getVerticalResolution();
			double lonPostSpacing = frame.getOMGrid().getHorizontalResolution();
			
			// Retrieve the posts from the DEM frame as a 2D array of shorts
			short[][] posts = frame.getElevations(
					(float)frameBounds.getUpperLeftLat(),
					(float)frameBounds.getUpperLeftLon(),
					(float)frameBounds.getLowerRightLat(),
					(float)frameBounds.getLowerRightLon());
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Elevation posts loaded in [ "
						+ (System.currentTimeMillis() - startTime)
						+ " ] ms.");
			}
			
			// Reset the time
			startTime = System.currentTimeMillis();
						
			// Loop through the 2D array and look for the min/max
			for (int row=0; row < posts.length; row++) {
				
				currentLat = frameBounds.getLowerLeftLat() + 
						(row * latPostSpacing);
				
				for (int column=0; column < posts[row].length; column++) {
					currentLon = frameBounds.getLowerLeftLon() + 
							(column * lonPostSpacing);
					
					postCounter++;
					
					// Check to see if the elevation is lower than the current
					// max elevation.
					if ((posts[row][column] < (short)minElevation) && 
							(posts[row][column] != INVALID_ELEVATION_VALUE)) {
						
						// Save the minimum elevation and associated point
						minElevation    = posts[row][column];
						minElevationLat = currentLat;
						minElevationLon = currentLon;
						
					}
					
					// Check to see if the elevation is higher than the current
					// max elevation.
					if ((posts[row][column] > (short)maxElevation) && 
							(posts[row][column] != INVALID_ELEVATION_VALUE)) {
						
						// Save the max elevation and associated point
						maxElevation    = posts[row][column];
						maxElevationLat = currentLat;
						maxElevationLon = currentLon;
					}
				}
			}
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Completed processing [ "
						+ postCounter
						+ " ] elevation posts in [ "
						+ (System.currentTimeMillis() - startTime)
						+ " ].");
			}
			
			// Construct the return data structure.  This could result
			// in a IllegalStateException exception.
			result = new MinMaxElevation.MinMaxElevationBuilder()
					.maxElevation(
							new ElevationDataPoint.ElevationDataPointBuilder()
								.elevation(maxElevation)
								.classificationMarking(getClassificationMarking())
								.units(getUnits())
								.withDEMFrameAccuracy(accuracy)
								.withGeodeticCoordinate(
										new GeodeticCoordinate.GeodeticCoordinateBuilder()
										.lat(maxElevationLat)
										.lon(maxElevationLon)
										.build())
								.build())
					.minElevation(
							new ElevationDataPoint.ElevationDataPointBuilder()
							.elevation(minElevation)
							.classificationMarking(getClassificationMarking())
							.units(getUnits())
							.withDEMFrameAccuracy(accuracy)
							.withGeodeticCoordinate(
									new GeodeticCoordinate.GeodeticCoordinateBuilder()
									.lat(minElevationLat)
									.lon(minElevationLon)
									.build())
							.build())
					.build();
			
		}
		finally {
			if (frame != null) {
				frame.close(true);
			}
		}
		return result;
	}
	
	
    /**
     * This method will determine the minimum and maximum elevation points 
     * that fall within the bounding box supplied.  
     * 
     * @param bbox client-defined bounding box.
     * @return Data structure containing the miniumum and maximum elevation
     * points.
     * @throws IllegalStateException Thrown if there are any validation 
     * problems with the any of the return data.  Callers should check the
     * exception message for more information.
     */
	public MinMaxElevation getMinMaxElevation(BoundingBox bbox) {
		
		long      startTime       = System.currentTimeMillis();
		
		DTEDFrame        frame    = null;
		DEMFrameAccuracy accuracy = null;
		MinMaxElevation  result   = null;
		
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Loading DEM frame file [ "
						+ getFilePath()
						+ " ].");
			}
			frame = new DTEDFrame(getFilePath());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("DTED frame file [ "
						+ getFilePath()
						+ " ] loaded in [ "
						+ (System.currentTimeMillis() - startTime)
						+ " ] ms.");
			}
			
			// Reset the time
			startTime = System.currentTimeMillis();
			
			// Generate the bounding box that contains the entire target
			// frame
			BoundingBox frameBounds = new BoundingBox.BoundingBoxBuilder()
						.lowerLeftLat(frame.getOMGrid().getLatitude())
						.lowerLeftLon(frame.getOMGrid().getLongitude())
						.upperRightLat(frame.getOMGrid().getLatitude()+1.0)
						.upperRightLon(frame.getOMGrid().getLongitude()+1.0)
					.build();
            
			// Get the intersection of the DTED frame with the user-defined 
			// bounding box.
			BoundingBox intersection = getIntersection(bbox, frameBounds);
			
			if (intersection != null) {
			
				// Collect the frame accuracy data
				accuracy = new DEMFrameAccuracy.DEMFrameAccuracyBuilder()
							.absHorzAccuracy(frame.acc.abs_horz_acc)
							.absVertAccuracy(frame.acc.abs_vert_acc)
							.relHorzAccuracy(frame.acc.rel_horz_acc)
							.relVertAccuracy(frame.acc.rel_vert_acc)
							.units(getUnits())
							.build();
				
				// The lat/lon post spacing allows us to calculate the lat/lon 
				// position of each elevation post.
				double latPostSpacing = frame.getOMGrid().getVerticalResolution();
				double lonPostSpacing = frame.getOMGrid().getHorizontalResolution();
				
				// Retrieve the posts from the DEM frame as a 2D array of shorts
				short[][] posts = frame.getElevations(
						(float)frameBounds.getUpperLeftLat(),
						(float)frameBounds.getUpperLeftLon(),
						(float)frameBounds.getLowerRightLat(),
						(float)frameBounds.getLowerRightLon());
				
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Elevation posts loaded in [ "
							+ (System.currentTimeMillis() - startTime)
							+ " ] ms.");
				}
			}
			else {
				LOGGER.warn("The input bounding box [ "
						+ bbox.toString()
						+ " ] does not overlap the DTED frame [ "
						+ frameBounds.toString()
						+ " ].  The returned MinMaxElevation object "
						+ "will be null.");
			}
		}
		finally {
			if (frame != null) {
				frame.close(true);
			}
		}
		return result;
	}
	
	/**
	 * Getter method for the path to the target DEM file.
	 * @return The path to the target DEM file.
	 */
	public String getFilePath() {
		return filePath;
	}
	
	/**
     * Getter method for the source DEM type data.
     * return The source DEM type.
	 */
	public TerrainDataType getSourceType() {
		return sourceType;
	}
	
	/** 
	 * Getter method for the output length (height) units.
	 * @return The client-requested output units.
	 */
	public HeightUnitType getUnits() {
		return units;
	}
	
    /**
     * Static inner class implementing the builder creation pattern for 
     * objects of type <code>ElevationExtremesFactory</code>.
     * 
     * @author L. Craig Carpenter
     */
	public static class ElevationExtremesFactoryBuilder {
		
		private String          filePath;
		private String          classificationMarking = "";
		private TerrainDataType sourceType;
		private HeightUnitType  units = HeightUnitType.METERS;
		
		/**
		 * Setter method for the path to the target DEM file.
		 * 
		 * @param value The path to the target DEM file.
		 * @return Reference to the builder object.
		 * @throws IllegalStateException Thrown if the input data is 
		 * invalid (null or empty).
		 */
		public ElevationExtremesFactoryBuilder filePath(String value) {
			if ((value == null) || (value.isEmpty())) {
				throw new IllegalStateException(
						"Invalid value for target file path.  Input value "
						+ "is null or empty.");
			}
			filePath = value;
			return this;
		}
		
		/**
		 * Setter method for the source classification marking.
		 * @param value The source classification marking.
		 * @return Reference to the builder object.
		 */
		public ElevationExtremesFactoryBuilder classificationMarking(String value) {
			classificationMarking = value;
			return this;
		}
		
		/**
		 * Setter method for the source DEM type data.
		 * @param value The source DEM type.
		 * @return Reference to the builder object.
		 */
		public ElevationExtremesFactoryBuilder sourceType(TerrainDataType value) {
			sourceType = value;
			return this;
		}
		
		/**
		 * Setter method for the units associated with the height and accuracy 
		 * data.
		 * @param value The units for the height and accuracy data.
		 * @return Reference to the builder object.
		 */
		public ElevationExtremesFactoryBuilder units(HeightUnitType value) {
			units = value;
			return this;
		}
		
		/**
		 * Build the target <code>ElevationExtremesFactory</code> object.
		 * 
		 * @return A constructed <code>ElevationExtremesFactory</code>.
		 * @throws IllegalStateException Thrown if the constructed object 
		 * fails any validation checks.
		 */
		public ElevationExtremesFactory build() throws IllegalStateException {
			ElevationExtremesFactory factory = 
					new ElevationExtremesFactory(this);
			validate(factory);
			return factory;
		}
		
		/**
		 * Validate the required input date.
		 * @param obj Candidate <code>ElevationExtremesFactory</code> object.
		 */
		private void validate(ElevationExtremesFactory obj) {
			Path p = Paths.get(obj.getFilePath());
			if (!Files.exists(p)) {
				throw new IllegalStateException("Target DEM file => [ "
						+ obj.getFilePath()
						+ " ] does not exist.");
			}
		}
	}
	
	public static void main(String[] args) {
		ElevationExtremesFactory factory = 
				new ElevationExtremesFactory.ElevationExtremesFactoryBuilder()
				.filePath("/mnt/terrain/srtm/srtmf/srt2f_1/srtf280/dted/w069/s15.dt2")
				.units(HeightUnitType.METERS)
				.sourceType(TerrainDataType.SRTM_2_F)
				.build();
		System.out.println(factory.getMinMaxElevation().toString());
	}
}
