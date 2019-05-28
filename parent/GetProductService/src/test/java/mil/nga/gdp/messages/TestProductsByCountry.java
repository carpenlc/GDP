package mil.nga.gdp.messages;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import mil.nga.gdp.GDPConstantsI;

public class TestProductsByCountry implements GDPConstantsI {
	
	static Map<String, String> inputParams = new HashMap<String, String>();
	static Map<String, String> inputParamsBad = new HashMap<String, String>();
	
	static SimpleDateFormat df1 = new SimpleDateFormat("yyyy");
	static SimpleDateFormat df2 = new SimpleDateFormat("MM");
	static SimpleDateFormat df3 = new SimpleDateFormat("dd");
	
	@BeforeClass
	public static void initialize() {
		inputParams.put(OPERATION_INPUT_PARAM, "getproductscntry");
		inputParams.put(PRODUCT_TAG_INPUT_PARAM, "dted0");
		inputParams.put(BACKWARDS_COMPATABILITY_INPUT_PARAM, "false");
		inputParams.put(COUNTRY_CODE_INPUT_PARAM, "bycommand");
		inputParams.put(STATE_CODE_INPUT_PARAM, "EUCOM");
		inputParams.put(TO_DATE_INPUT_PARAM, "2018-06-10");
		inputParams.put(FROM_DATE_INPUT_PARAM, "2018-06-01");
		inputParams.put(DIRECT_DOWNLOAD_LINK_INPUT_PARAM, "true");
		inputParamsBad.put(OPERATION_INPUT_PARAM, "getproductscntry");
		inputParamsBad.put(PRODUCT_TAG_INPUT_PARAM, "dted0");
		inputParamsBad.put(BACKWARDS_COMPATABILITY_INPUT_PARAM, "false");
		inputParamsBad.put(COUNTRY_CODE_INPUT_PARAM, "bycommand");
		inputParamsBad.put(TO_DATE_INPUT_PARAM, "2018-06-10");
		inputParamsBad.put(FROM_DATE_INPUT_PARAM, "2018-06-01");
		inputParamsBad.put(DIRECT_DOWNLOAD_LINK_INPUT_PARAM, "true");
	}
	
	@Test
	public void testNormalConstruction() {
		ProductsByCountry message = new ProductsByCountry.ProductsByCountryBuilder()
			    .backwardsCompatible(false)
			    .directDownloadLink(true)
			    .productTag("productTag")
			    .countryCode("US")
			    .state("MO")
			    .build();
		assertEquals("US", message.getCountryCode());
		assertEquals("MO", message.getState());
		assertEquals(false, message.getBackwardsCompatible());
		assertEquals(true, message.getDirectDownloadLink());
	}
	
	@Test
	public void testNormalConstruction2() {
		ProductsByCountry message = new ProductsByCountry.ProductsByCountryBuilder()
			    .backwardsCompatible(false)
			    .directDownloadLink(true)
			    .productTag("productTag")
			    .countryCode("bycommand")
			    .state("EUCOM")
			    .build();
		assertEquals("bycommand", message.getCountryCode());
		assertEquals("EUCOM", message.getState());
		assertEquals(false, message.getBackwardsCompatible());
		assertEquals(true, message.getDirectDownloadLink());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBadNormalConstruction() {
		ProductsByCountry message = new ProductsByCountry.ProductsByCountryBuilder()
			    .backwardsCompatible(false)
			    .directDownloadLink(true)
			    .productTag("productTag")
			    .countryCode("bycommand")
			    .build();
	}
	
	@Test
	public void testConstructionFromMessage() {
		
		ProductsByCountry message = new ProductsByCountry.ProductsByCountryBuilder()
			    .fromMessage(inputParams)
			    .build();
		
		assertEquals("dted0", message.getProductTag());
		assertEquals("EUCOM", message.getState());
		assertEquals("bycommand", message.getCountryCode());
		assertEquals(false, message.getBackwardsCompatible());
		assertEquals(true,  message.getDirectDownloadLink());
		assertEquals("2018", df1.format(message.getFromDate()));
		assertEquals("06",   df2.format(message.getFromDate()));
		assertEquals("01",   df3.format(message.getFromDate()));
		assertEquals("2018", df1.format(message.getToDate()));
		assertEquals("06",   df2.format(message.getToDate()));
		assertEquals("10",   df3.format(message.getToDate()));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBadConstructionFromMessage() {
		ProductsByCountry message = new ProductsByCountry.ProductsByCountryBuilder()
			    .fromMessage(inputParamsBad)
			    .build();
	}
	
	
}
