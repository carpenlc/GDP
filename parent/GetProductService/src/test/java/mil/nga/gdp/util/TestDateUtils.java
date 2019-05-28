package mil.nga.gdp.util;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

public class TestDateUtils {
	
	@Test
	public void testVariousDates() {
		
		SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy");
		SimpleDateFormat df2 = new SimpleDateFormat("MM");
		SimpleDateFormat df3 = new SimpleDateFormat("dd");
		
		Date d1 = DateUtils.parse("2018-12-31");
		assertEquals("2018", df1.format(d1));
		assertEquals("12",   df2.format(d1));
		assertEquals("31",   df3.format(d1));
		
		Date d2 = DateUtils.parse("2017-11-30");
		assertEquals("2017", df1.format(d2));
		assertEquals("11",   df2.format(d2));
		assertEquals("30",   df3.format(d2));
		
		Date d3 = DateUtils.parse("2016-01-01");
		assertEquals("2016", df1.format(d3));
		assertEquals("01",   df2.format(d3));
		assertEquals("01",   df3.format(d3));
		
		Date d4 = DateUtils.parse("2018-06-01");
		assertEquals("2018", df1.format(d4));
		assertEquals("06",   df2.format(d4));
		assertEquals("01",   df3.format(d4));
	}
}
