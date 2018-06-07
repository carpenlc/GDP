package mil.nga.gdp.util;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

	/**
	 * This method accepts a date in format yyyy-mm-dd format and generates a 
	 * corresponding Date object.  This was copied from the legacy GDN/GDP and
	 * corrected.
	 * 
	 * @param value String containing data used to construct a date.
	 * @return A Date Object.
	 */
	public static Date parse(String value) {
		Date date = null;
		if ((value != null) && (!value.isEmpty())) {
			String[] parts = value.split("-");
			if ((parts != null) && (parts.length == 3)) {
				int year = Integer.getInteger(parts[0]);
				int month = Integer.getInteger(parts[1]);
				int day = Integer.getInteger(parts[2]);
				date = (new GregorianCalendar(year,  month, day)).getTime();
			}
		}
		return date;
	}
}
