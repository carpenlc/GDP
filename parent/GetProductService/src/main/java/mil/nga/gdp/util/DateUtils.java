package mil.nga.gdp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

	/**
	 * Generate a String in the format yyyy-mm-dd representing todays date.
	 * @return A String representing todays date.
	 */
	public static String today() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
	
	/**
	 * This method accepts a date in format yyyy-mm-dd format and generates a 
	 * corresponding Date object.  This was copied from the legacy GDN/GDP and
	 * corrected.
	 * 
	 * @param value String containing data used to construct a date.
	 * @return A Date Object.
	 * @throws NumberFormatException Thrown if we cannot parse any of the 
	 * date fields.
	 */
	public static Date parse(String value) throws NumberFormatException {
		Date date = null;
		if ((value != null) && (!value.isEmpty())) {
			String[] parts = value.split("-");
			if ((parts != null) && (parts.length == 3)) {
				int year = Integer.parseInt(parts[0]);
				int month = Integer.parseInt(parts[1]);
				// Note: the older java Date classes index the month starting 
				// at 0
				if ((month > 0) && (month < 13)) {
					month = month - 1;
				}
				else {
					throw new NumberFormatException("Invalid month value.  "
							+ "Month must be between 1 and 12.");
				}
				int day = Integer.parseInt(parts[2]);
				date = (new GregorianCalendar(year,  month, day)).getTime();
			}
		}
		return date;
	}
}
