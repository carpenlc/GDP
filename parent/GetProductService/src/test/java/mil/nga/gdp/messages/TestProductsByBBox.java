package mil.nga.gdp.messages;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import mil.nga.gdp.GDPConstantsI;

/**
 * JUnit tests for the ProductsByBBox message class.
 * 
 * @author L. Craig Carpenter
 */
public class TestProductsByBBox implements GDPConstantsI {
	
	static Map<String, String> inputParams = new HashMap<String, String>();
	static Map<String, String> badInputParams = new HashMap<String, String>();
	static Map<String, String> badInputParams2 = new HashMap<String, String>();
	
	static SimpleDateFormat df1 = new SimpleDateFormat("yyyy");
	static SimpleDateFormat df2 = new SimpleDateFormat("MM");
	static SimpleDateFormat df3 = new SimpleDateFormat("dd");
	
	@BeforeClass
	public static void initialize() {
		inputParams.put(OPERATION_INPUT_PARAM, "getProductsBbox");
		inputParams.put(PRODUCT_TAG_INPUT_PARAM, "dted0");
		
		inputParams.put(BACKWARDS_COMPATABILITY_INPUT_PARAM, "false");
		inputParams.put(BBOX_INPUT_PARAM, "0.0,0.0,1.0,1.0");
		inputParams.put(DIRECT_DOWNLOAD_LINK_INPUT_PARAM, "true");
		badInputParams.put(OPERATION_INPUT_PARAM, "getProductsBbox");
		badInputParams.put(PRODUCT_TAG_INPUT_PARAM, "dted0");
		badInputParams.put(BACKWARDS_COMPATABILITY_INPUT_PARAM, "xxxx");
		//badInputParams.put(BBOX_INPUT_PARAM, "0.0,0.0,1.0,1.0");
		badInputParams.put(BBOX_INPUT_PARAM, "0.0,0.0,1.0");
		badInputParams.put(DIRECT_DOWNLOAD_LINK_INPUT_PARAM, "true");
		badInputParams2.put(OPERATION_INPUT_PARAM, "getProductsBbox");
		badInputParams2.put(PRODUCT_TAG_INPUT_PARAM, "dted0");
		badInputParams2.put(BACKWARDS_COMPATABILITY_INPUT_PARAM, "xxxx");
		badInputParams2.put(BBOX_INPUT_PARAM, "0.0,0.0,1.0,AAA");
		badInputParams2.put(DIRECT_DOWNLOAD_LINK_INPUT_PARAM, "true");
	}
	
	@Test
	public void testNormalConstruction() {
		ProductsByBBox message = new ProductsByBBox.ProductsByBBoxBuilder()
									    .backwardsCompatible(false)
									    .directDownloadLink(false)
									    .productTag("productTag")
									    .fromDate("2018-06-01")
									    .toDate("2018-06-10")
									    .lowerLeftLat(0.0)
									    .lowerLeftLon(0.0)
									    .upperRightLat(1.0)
									    .upperRightLon(1.0)
									    .build();
		assertEquals(0.0, message.getLowerLeftLat(), 0);
		assertEquals(0.0, message.getLowerLeftLon(), 0);
		assertEquals(1.0, message.getUpperRightLat(), 0);
		assertEquals(1.0, message.getUpperRightLon(), 0);
		assertEquals("2018", df1.format(message.getFromDate()));
		assertEquals("06",   df2.format(message.getFromDate()));
		assertEquals("01",   df3.format(message.getFromDate()));
		assertEquals("2018", df1.format(message.getToDate()));
		assertEquals("06",   df2.format(message.getToDate()));
		assertEquals("10",   df3.format(message.getToDate()));
		assertEquals(false, message.getBackwardsCompatible());
		assertEquals(false, message.getDirectDownloadLink());
	}
	
	@Test
	public void testConstructionWithStringBBox() {
		ProductsByBBox message = new ProductsByBBox.ProductsByBBoxBuilder()
									    .backwardsCompatible(false)
									    .directDownloadLink(false)
									    .fromDate("2017-12-30")
									    .toDate("2018-01-30")
									    .productTag("productTag")
									    .bBox("0.0,0.0,1.0,1.0")
									    .build();
		assertEquals(0.0, message.getLowerLeftLat(), 0);
		assertEquals(0.0, message.getLowerLeftLon(), 0);
		assertEquals(1.0, message.getUpperRightLat(), 0);
		assertEquals(1.0, message.getUpperRightLon(), 0);
		assertEquals("2017", df1.format(message.getFromDate()));
		assertEquals("12",   df2.format(message.getFromDate()));
		assertEquals("30",   df3.format(message.getFromDate()));
		assertEquals("2018", df1.format(message.getToDate()));
		assertEquals("01",   df2.format(message.getToDate()));
		assertEquals("30",   df3.format(message.getToDate()));
		assertEquals(false, message.getBackwardsCompatible());
		assertEquals(false, message.getDirectDownloadLink());
	}
	
	@Test
	public void testConstructionFromMessage() {
		ProductsByBBox message = new ProductsByBBox.ProductsByBBoxBuilder()
			    .fromMessage(inputParams)
			    .build();
		assertEquals(0.0, message.getLowerLeftLat(), 0);
		assertEquals(0.0, message.getLowerLeftLon(), 0);
		assertEquals(1.0, message.getUpperRightLat(), 0);
		assertEquals(1.0, message.getUpperRightLon(), 0);
		assertEquals(false, message.getBackwardsCompatible());
		assertEquals(true, message.getDirectDownloadLink());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testConstructionFromBadMessage() {
		ProductsByBBox message = new ProductsByBBox.ProductsByBBoxBuilder()
			    .fromMessage(badInputParams)
			    .build();
		assertEquals(0.0, message.getLowerLeftLat(), 0);
		assertEquals(0.0, message.getLowerLeftLon(), 0);
		assertEquals(1.0, message.getUpperRightLat(), 0);
		assertEquals(1.0, message.getUpperRightLon(), 0);
		assertEquals(false, message.getBackwardsCompatible());
		assertEquals(true, message.getDirectDownloadLink());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testConstructionFromBadMessage2() {
		ProductsByBBox message = new ProductsByBBox.ProductsByBBoxBuilder()
			    .fromMessage(badInputParams2)
			    .build();
		assertEquals(0.0, message.getLowerLeftLat(), 0);
		assertEquals(0.0, message.getLowerLeftLon(), 0);
		assertEquals(1.0, message.getUpperRightLat(), 0);
		assertEquals(1.0, message.getUpperRightLon(), 0);
		assertEquals(false, message.getBackwardsCompatible());
		assertEquals(true, message.getDirectDownloadLink());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBadBoundingBox() {
		ProductsByBBox message = new ProductsByBBox.ProductsByBBoxBuilder()
			    .backwardsCompatible(false)
			    .directDownloadLink(false)
			    .productTag("productTag")
			    .lowerLeftLat(1.0)
			    .lowerLeftLon(1.0)
			    .upperRightLat(0.0)
			    .upperRightLon(0.0)
			    .build();
	}
}
