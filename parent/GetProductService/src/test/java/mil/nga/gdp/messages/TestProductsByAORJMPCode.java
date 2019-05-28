package mil.nga.gdp.messages;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import mil.nga.gdp.GDPConstantsI;

public class TestProductsByAORJMPCode implements GDPConstantsI {

	static Map<String, String> inputParams = new HashMap<String, String>();
	static Map<String, String> badInputParams = new HashMap<String, String>();
	
	static SimpleDateFormat df1 = new SimpleDateFormat("yyyy");
	static SimpleDateFormat df2 = new SimpleDateFormat("MM");
	static SimpleDateFormat df3 = new SimpleDateFormat("dd");
	
	@BeforeClass
	public static void initialize() {
		inputParams.put(OPERATION_INPUT_PARAM, "getProductsAorJmp");
		inputParams.put(PRODUCT_TAG_INPUT_PARAM, "dted0");
		inputParams.put(BACKWARDS_COMPATABILITY_INPUT_PARAM, "false");
		inputParams.put(AOR_INPUT_PARAM, "EUCOM");
		inputParams.put(CODE_INPUT_PARAM, "codeValue");
		inputParams.put(TO_DATE_INPUT_PARAM, "2018-06-10");
		inputParams.put(FROM_DATE_INPUT_PARAM, "2018-06-01");
		inputParams.put(DIRECT_DOWNLOAD_LINK_INPUT_PARAM, "true");
		badInputParams.put(OPERATION_INPUT_PARAM, "getProductsAorJmp");
		badInputParams.put(PRODUCT_TAG_INPUT_PARAM, "dted0");
		badInputParams.put(BACKWARDS_COMPATABILITY_INPUT_PARAM, "xxxx");
		badInputParams.put(DIRECT_DOWNLOAD_LINK_INPUT_PARAM, "true");
		badInputParams.put(AOR_INPUT_PARAM, "xxx");
		badInputParams.put(CODE_INPUT_PARAM, "codeValue");
	}
	
	@Test
	public void testNormalConstruction() {
		ProductsByAORJMPCode message = new ProductsByAORJMPCode.ProductsByAORJMPCodeBuilder()
									    .backwardsCompatible(false)
									    .directDownloadLink(true)
									    .productTag("productTag")
									    .aorOrCode("EUCOM")
									    .code("This-is-a-code")
									    .build();
		assertEquals("EUCOM", message.getAorOrCode());
		assertEquals("This-is-a-code", message.getCode());
		assertEquals(false, message.getBackwardsCompatible());
		assertEquals(true, message.getDirectDownloadLink());
	}
	
	@Test
	public void testConstructionFromMessage() {
		
		ProductsByAORJMPCode message = new ProductsByAORJMPCode.ProductsByAORJMPCodeBuilder()
			    .fromMessage(inputParams)
			    .build();
		
		assertEquals("dted0", message.getProductTag());
		assertEquals("EUCOM", message.getAorOrCode());
		assertEquals("codeValue", message.getCode());
		assertEquals(false, message.getBackwardsCompatible());
		assertEquals(true,  message.getDirectDownloadLink());
		assertEquals("2018", df1.format(message.getFromDate()));
		assertEquals("06",   df2.format(message.getFromDate()));
		assertEquals("01",   df3.format(message.getFromDate()));
		assertEquals("2018", df1.format(message.getToDate()));
		assertEquals("06",   df2.format(message.getToDate()));
		assertEquals("10",   df3.format(message.getToDate()));
	}
		
}
