package mil.nga.npd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import mil.nga.elevation.HeightUnitType;
import mil.nga.elevation.TerrainDataType;
import mil.nga.npd.exceptions.InvalidParameterException;
import mil.nga.npd.types.ElevationOperationType;

public class TestQueryStringParser {

	public static final String TEST_WKT_STRING = "1.0,2.0,3.0,4.0,5.0";
	
	@Test
	public void testParsePoints() throws InvalidParameterException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(
				ElevationRESTFilter.SOURCE_DATA_PARAM, 
				TerrainDataType.SRTM_1_F.value()); 
		params.put(
				ElevationRESTFilter.REQUESTED_UNITS_PARAM,
				HeightUnitType.METERS.value());			
		params.put(
				RESTFilter.OPERATION_PARAM, 
				ElevationOperationType.GET_ELEVATION_AT.getText());
		params.put(
				ElevationRESTFilter.POINTS_PARAM, 
				"-107.3,38.1,-108.3,39.1");
		QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_ELEVATION_AT, parser.getOperation());
		assertEquals(HeightUnitType.METERS, parser.getUnits());
		assertEquals(TerrainDataType.SRTM_1_F, parser.getSource());	
		assertEquals(parser.getPoints().get(0).getLat(), 38.1, 0);
		assertEquals(parser.getPoints().get(0).getLon(), -107.3, 0);
		assertEquals(parser.getPoints().get(1).getLat(), 39.1, 0);
		assertEquals(parser.getPoints().get(1).getLon(), -108.3, 0);
	}
	
	@Test
	public void testParseBBOX() throws InvalidParameterException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(
				ElevationRESTFilter.SOURCE_DATA_PARAM, 
				TerrainDataType.SRTM_1_F.value()); 
		params.put(
				ElevationRESTFilter.REQUESTED_UNITS_PARAM,
				HeightUnitType.METERS.value());			
		params.put(
				RESTFilter.OPERATION_PARAM, 
				ElevationOperationType.GET_MIN_MAX_ELEVATIONS.getText());
		params.put(
				ElevationRESTFilter.BOUNDING_BOX_PARAM, 
				"-108.3,38.1,-107.3,39.1");
		QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_MIN_MAX_ELEVATIONS, parser.getOperation());
		assertEquals(HeightUnitType.METERS, parser.getUnits());
		assertEquals(TerrainDataType.SRTM_1_F, parser.getSource());	
		System.out.println(parser.getBoundingBox().toString());
		//assertEquals(parser.getPoints().get(0).getLat(), 38.1, 0);
		//assertEquals(parser.getPoints().get(0).getLon(), -107.3, 0);
		//assertEquals(parser.getPoints().get(1).getLat(), 39.1, 0);
		//assertEquals(parser.getPoints().get(1).getLon(), -108.3, 0);
	}
	
	@Test(expected = InvalidParameterException.class)
	public void testParseBBOXBad() throws InvalidParameterException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(
				ElevationRESTFilter.SOURCE_DATA_PARAM, 
				TerrainDataType.SRTM_1_F.value()); 
		params.put(
				ElevationRESTFilter.REQUESTED_UNITS_PARAM,
				HeightUnitType.METERS.value());			
		params.put(
				RESTFilter.OPERATION_PARAM, 
				ElevationOperationType.GET_MIN_MAX_ELEVATIONS.getText());
		params.put(
				ElevationRESTFilter.BOUNDING_BOX_PARAM, 
				"-108.3,38.1,ABC,39.1");
		QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
	}
	
	@Test(expected = InvalidParameterException.class)
	public void testParseBBOXBad2() throws InvalidParameterException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(
				ElevationRESTFilter.SOURCE_DATA_PARAM, 
				TerrainDataType.SRTM_1_F.value()); 
		params.put(
				ElevationRESTFilter.REQUESTED_UNITS_PARAM,
				HeightUnitType.METERS.value());			
		params.put(
				RESTFilter.OPERATION_PARAM, 
				ElevationOperationType.GET_MIN_MAX_ELEVATIONS.getText());
		params.put(
				ElevationRESTFilter.BOUNDING_BOX_PARAM, 
				"-108.3,38.1,39.1");
		QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
	}
	
	@Test(expected = InvalidParameterException.class)
	public void testParseBadPoints() throws InvalidParameterException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(
				ElevationRESTFilter.SOURCE_DATA_PARAM, 
				TerrainDataType.SRTM_1_F.value()); 
		params.put(
				ElevationRESTFilter.REQUESTED_UNITS_PARAM,
				HeightUnitType.METERS.value());			
		params.put(
				RESTFilter.OPERATION_PARAM, 
				ElevationOperationType.GET_ELEVATION_AT.getText());
		params.put(
				ElevationRESTFilter.POINTS_PARAM, 
				"-107.3,38.1,-108.3,ABC");
		QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_ELEVATION_AT, parser.getOperation());
		assertEquals(HeightUnitType.METERS, parser.getUnits());
		assertEquals(TerrainDataType.SRTM_1_F, parser.getSource());	
	}
	
	@Test(expected = InvalidParameterException.class)
	public void testParseBadPoints2() throws InvalidParameterException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(
				ElevationRESTFilter.SOURCE_DATA_PARAM, 
				TerrainDataType.SRTM_1_F.value()); 
		params.put(
				ElevationRESTFilter.REQUESTED_UNITS_PARAM,
				HeightUnitType.METERS.value());			
		params.put(
				RESTFilter.OPERATION_PARAM, 
				ElevationOperationType.GET_ELEVATION_AT.getText());
		params.put(
				ElevationRESTFilter.POINTS_PARAM, 
				"-107.3,38.1,-108.3");
		QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_ELEVATION_AT, parser.getOperation());
		assertEquals(HeightUnitType.METERS, parser.getUnits());
		assertEquals(TerrainDataType.SRTM_1_F, parser.getSource());	
	}
	
	@Test(expected = InvalidParameterException.class)
	public void testBadConstruction() throws InvalidParameterException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("params", TEST_WKT_STRING);
        QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
	}
	
	@Test(expected = InvalidParameterException.class)
	public void testBadJSON() throws InvalidParameterException {
		// Malformed JSON
		String json = "{\"GetElevationAt\":"
				+ "\"pts\":{\"lon\":\"-107.3\",\"lat\":\"38.1\"},"
				+ "{\"lon\":\"-108.3\",\"lat\":\"39.1\"}],"
				+ "\"heightType\":\"METERS\"\"terrainDataType\":\"DTED0\"}}";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parameters", json);
		QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
	}
	
	@Test(expected = InvalidParameterException.class)
	public void testGetElevationAtJSONBadPoints() throws InvalidParameterException {
		// Test a regular good message
		String json = "{\"GetElevationAt\":{"
				+ "\"pts\":[{},"
				+ "{\"lon\":\"-108.3\",\"lat\":\"39.1\"}],"
				+ "\"heightType\":\"METERS\",\"terrainDataType\":\"DTED0\"}}";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parameters", json);
		QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
	}
	
	@Test
	public void testGetElevationAtJSON() throws InvalidParameterException {
		
		// Test a regular good message
		String json = "{\"GetElevationAt\":{"
				+ "\"pts\":[{\"lon\":\"-107.3\",\"lat\":\"38.1\"},"
				+ "{\"lon\":\"-108.3\",\"lat\":\"39.1\"}],"
				+ "\"heightType\":\"METERS\",\"terrainDataType\":\"DTED0\"}}";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parameters", json);
		QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_ELEVATION_AT, parser.getOperation());
		assertEquals(HeightUnitType.METERS, parser.getUnits());
		assertEquals(TerrainDataType.DTED_0, parser.getSource());
		List<GeodeticCoordinate> points = parser.getPoints();
		assertNotNull(points);
		assertEquals(points.size(), 2);
		assertEquals(38.1, points.get(0).getLat(), 0);
		assertEquals(-107.3, points.get(0).getLon(), 0);
		assertEquals(39.1, points.get(1).getLat(), 0);
		assertEquals(-108.3, points.get(1).getLon(), 0);
		points.get(0).getLon();
		parser.getSource();
		
		// Test a message that defaults the terrain data type
		String json2 = "{\"GetElevationAt\":{"
				+ "\"pts\":[{\"lon\":\"-107.3\",\"lat\":\"38.1\"},"
				+ "{\"lon\":\"-108.3\",\"lat\":\"39.1\"}],"
				+ "\"heightType\":\"METERS\"}}";
		params = new HashMap<String, Object>();
        params.put("parameters", json2);
		parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_ELEVATION_AT, parser.getOperation());
		assertEquals(HeightUnitType.METERS, parser.getUnits());
		assertEquals(TerrainDataType.BEST, parser.getSource());
		points = parser.getPoints();
		assertNotNull(points);
		assertEquals(points.size(), 2);
		assertEquals(38.1, points.get(0).getLat(), 0);
		assertEquals(-107.3, points.get(0).getLon(), 0);
		assertEquals(39.1, points.get(1).getLat(), 0);
		assertEquals(-108.3, points.get(1).getLon(), 0);
		points.get(0).getLon();
		parser.getSource();
		
		// Test another good message with different enum values
		String json3 = "{\"GetElevationAt\":{"
				+ "\"pts\":[{\"lon\":\"-107.3\",\"lat\":\"38.1\"},"
				+ "{\"lon\":\"-108.3\",\"lat\":\"39.1\"}],"
				+ "\"heightType\":\"FEET\",\"terrainDataType\":\"SRTM1\"}}";
		params = new HashMap<String, Object>();
        params.put("parameters", json3);
		parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_ELEVATION_AT, parser.getOperation());
		assertEquals(HeightUnitType.FEET, parser.getUnits());
		assertEquals(TerrainDataType.SRTM_1, parser.getSource());
		points = parser.getPoints();
		assertNotNull(points);
		assertEquals(points.size(), 2);
		assertEquals(38.1, points.get(0).getLat(), 0);
		assertEquals(-107.3, points.get(0).getLon(), 0);
		assertEquals(39.1, points.get(1).getLat(), 0);
		assertEquals(-108.3, points.get(1).getLon(), 0);
		points.get(0).getLon();
		parser.getSource();
	}
	
	@Test
	public void testGetMinMaxElevationsJSON() throws InvalidParameterException {
		
		// Test a regular good message
		String json = "{\"GetMinMaxElevations\":{"
				+ "\"bbox\":[{\"lllon\":\"-107.3\",\"lllat\":\"38.1\","
				+ "\"urlon\":\"-106.3\",\"urlat\":\"39.1\"}],"
				+ "\"heightType\":\"METERS\",\"terrainDataType\":\"DTED0\"}}";
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("parameters", json);
        QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_MIN_MAX_ELEVATIONS, parser.getOperation());
		assertEquals(HeightUnitType.METERS, parser.getUnits());
		assertEquals(TerrainDataType.DTED_0, parser.getSource());
		assertEquals(38.1, parser.getBoundingBox().getLowerLeftLat(), 0);
		assertEquals(-107.3, parser.getBoundingBox().getLowerLeftLon(), 0);
		assertEquals(39.1, parser.getBoundingBox().getUpperRightLat(), 0);
		assertEquals(-106.3, parser.getBoundingBox().getUpperRightLon(), 0);
		
		String json2 = "{\"GetMinMaxElevations\":{"
				+ "\"bbox\":[{\"lllon\":\"-107.3\",\"lllat\":\"38.1\","
				+ "\"urlon\":\"-106.3\",\"urlat\":\"39.1\"}],"
				+ "\"heightType\":\"METERS\"}}";
		params = new HashMap<String, Object>();
        params.put("parameters", json2);
        parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_MIN_MAX_ELEVATIONS, parser.getOperation());
		assertEquals(HeightUnitType.METERS, parser.getUnits());
		assertEquals(TerrainDataType.BEST, parser.getSource());
		assertEquals(38.1, parser.getBoundingBox().getLowerLeftLat(), 0);
		assertEquals(-107.3, parser.getBoundingBox().getLowerLeftLon(), 0);
		assertEquals(39.1, parser.getBoundingBox().getUpperRightLat(), 0);
		assertEquals(-106.3, parser.getBoundingBox().getUpperRightLon(), 0);
		
		String json3 = "{\"GetMinMaxElevations\":{"
				+ "\"bbox\":[{\"lllon\":\"-107.3\",\"lllat\":\"38.1\","
				+ "\"urlon\":\"-106.3\",\"urlat\":\"39.1\"}],"
				+ "\"heightType\":\"FEET\",\"terrainDataType\":\"SRTM1F\"}}";
		params = new HashMap<String, Object>();
        params.put("parameters", json3);
        parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_MIN_MAX_ELEVATIONS, parser.getOperation());
		assertEquals(HeightUnitType.FEET, parser.getUnits());
		assertEquals(TerrainDataType.SRTM_1_F, parser.getSource());
		assertEquals(38.1, parser.getBoundingBox().getLowerLeftLat(), 0);
		assertEquals(-107.3, parser.getBoundingBox().getLowerLeftLon(), 0);
		assertEquals(39.1, parser.getBoundingBox().getUpperRightLat(), 0);
		assertEquals(-106.3, parser.getBoundingBox().getUpperRightLon(), 0);
	}
	
	@Test
	public void testGetMinMaxElevationsWKTJSON() throws InvalidParameterException {
		
		// Test a regular good message
		String json = "{\"GetMinMaxElevationsWKT\":{"
				+ "\"wkt\":\"" 
				+ TEST_WKT_STRING
				+ "\",\"heightType\":\"METERS\",\"terrainDataType\":\"DTED0\"}}";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parameters", json);
		QueryStringParser parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_MIN_MAX_ELEVATIONS_WKT, parser.getOperation());
		assertEquals(HeightUnitType.METERS, parser.getUnits());
		assertEquals(TerrainDataType.DTED_0, parser.getSource());
		assertEquals(TEST_WKT_STRING, parser.getWKTString());
		
		String json2 = "{\"GetMinMaxElevationsWKT\":{"
				+ "\"wkt\":\"" 
				+ TEST_WKT_STRING
				+ "\",\"heightType\":\"FEET\",\"terrainDataType\":\"SRTM2F\"}}";
        params = new HashMap<String, Object>();
        params.put("parameters", json2);
		parser = new QueryStringParser.QueryStringParserBuilder()
				.withParams(params)
				.build();
		parser.parse();
		assertEquals(ElevationOperationType.GET_MIN_MAX_ELEVATIONS_WKT, parser.getOperation());
		assertEquals(HeightUnitType.FEET, parser.getUnits());
		assertEquals(TerrainDataType.SRTM_2_F, parser.getSource());
		assertEquals(TEST_WKT_STRING, parser.getWKTString());
	}
}
