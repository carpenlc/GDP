package mil.nga.gdp.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.exceptions.IllegalTypeException;
import mil.nga.gdp.types.CommandType;

/**
 * Superclass for the various SQL query generation classes.  It contains
 * logic common to all of the SQL generation algorithms.
 * 
 * @author L. Craig Carpenter
 */
public class QueryGenerator implements GDPConstantsI {

	/** 
	 * Set up the logging subsystem for use throughout the class
	 */
	static final Logger LOG = LoggerFactory.getLogger(
			QueryGenerator.class);
	/**
	 * Construct an SQL where clause searching the database by ISO Code.
	 * @param code 3-digit country code
	 * @param state Used only if the the input code us 'USA'
	 * @return Query by ISO Code.
	 * @throws IllegalTypeException Thrown if the input code is not supplied.
	 */
	public String getQueryByISOCode(
			String code,
			String state) throws IllegalStateException {
		
		StringBuilder sb = new StringBuilder();
		
		if ((code != null) && (!code.isEmpty())) {
			if (code.equalsIgnoreCase("USA")) {
				if ((state != null) && (!state.isEmpty())) {
					sb.append(" ");
					sb.append(JUMP_CODE_COLUMN);
					sb.append(" like 'US_");
					sb.append(state.trim().toUpperCase());
					sb.append("'");
				}
				else {
					sb.append(" ");
					sb.append(JUMP_CODE_COLUMN);
					sb.append(" in ('US','US_AK','US_HI')");
				}
			}
			else {
				sb.append(" ");
				sb.append(ISO_3_CHAR_COLUMN);
				sb.append(" like '");
				sb.append(code.trim().toUpperCase());
				sb.append("'");
			}
		}
		else {
			throw new IllegalStateException("Invalid state.  Query by "
					+ "column [ "
					+ ISO_3_CHAR_COLUMN
					+ " ] requested, but column value not supplied.");
		}
		return sb.toString();

	}
	
	/**
	 * Construct an SQL where clause searching the database by FIPS Code.
	 * @param code 2-digit country code
	 * @param state Used only if the the input code us 'US'
	 * @return Query by FIPS Code.
	 * @throws IllegalTypeException Thrown if the input code is not supplied.
	 */
	public String getQueryByFIPSCode(
			String code, 
			String state) throws IllegalStateException {
		
		StringBuilder sb = new StringBuilder();
		
		if ((code != null) && (!code.isEmpty())) {
			if (code.equalsIgnoreCase("US")) {
				if ((state != null) && (!state.isEmpty())) {
					sb.append(" ");
					sb.append(JUMP_CODE_COLUMN);
					sb.append(" like 'US_");
					sb.append(state.trim().toUpperCase());
					sb.append("'");
				}
				else {
					sb.append(" ");
					sb.append(JUMP_CODE_COLUMN);
					sb.append(" in ('US','US_AK','US_HI')");
				}
			}
			else {
				sb.append(" ");
				sb.append(FIPS_CODE_COLUMN);
				sb.append(" like '");
				sb.append(code.toUpperCase());
				sb.append("'");
			}
		}
		else {
			throw new IllegalStateException("Invalid state.  Query by "
					+ "column [ "
					+ FIPS_CODE_COLUMN
					+ " ] requested, but column value not supplied.");
		}
		return sb.toString();
	}
	
	/**
	 * Create a where clause query to search by an input <code>AOR_CODE</code>.
	 * 
	 * @param command The military command to issue a query for.
	 * @return Query using the <code>AOR_CODE</code> field for a specific 
	 * military command.
	 * @throws IllegalTypeException Thrown if any issues are encountered 
	 * translating the user-supplied command.
	 */
	public String getQueryByCommand(String command) throws IllegalTypeException {
		StringBuilder sb = new StringBuilder();
		CommandType cmdType = CommandType.fromString(command);
		sb.append(" ");
		sb.append(AOR_CODE_COLUMN);
		sb.append(" like '");
		sb.append(cmdType.getText().toUpperCase());
		sb.append("'");
		return sb.toString();
	}
	
	/**
	 * Create a where clause query to search by an input <code>JUMP_CODE</code>.
	 * 
	 * @param command The military command to issue a query for.
	 * @return Query using the <code>JUMP_CODE</code> field for a specific military 
	 * command.
	 * @throws IllegalTypeException Thrown if any issues are encountered 
	 * translating the user-supplied command.
	 */
	public String getQueryByJumpCode(String code) throws IllegalStateException {
		StringBuilder sb = new StringBuilder();
		if ((code != null) && (!code.isEmpty())) {
			sb.append(" ");
			sb.append(JUMP_CODE_COLUMN);
			sb.append(" like '");
			sb.append(code.trim().toUpperCase());
			sb.append("'");
		}
		else {
			throw new IllegalStateException("Invalid state.  Query by "
					+ "column [ "
					+ JUMP_CODE_COLUMN
					+ " ] requested, but column value not supplied.");
		}
		return sb.toString();
	}
	
	/**
	 * Construct a where clause specifying a date range.
	 * 
	 * @param fromDate The start date for the query.
	 * @param toDate The end date for the query.
	 * @return A SQL where clause specifying a date range.
	 */
	public String getDateWhereClause(String fromDate, String toDate) {
		StringBuilder sb = new StringBuilder();
		if ((fromDate != null) && (!fromDate.isEmpty())) {
			if ((toDate != null) && (!toDate.isEmpty())) {
				if (fromDate.equalsIgnoreCase(toDate)) {
					sb.append(" LOAD_DATE >= to_date('");
					sb.append(fromDate);
					sb.append("')");
				}
				else {
					sb.append(" LOAD_DATE >= to_date('");
					sb.append(fromDate);
					sb.append("') and LOAD_DATE <= to_date('");
					sb.append(toDate);
					sb.append("')");
				}
			}
			else {
				sb.append(" LOAD_DATE >= to_date('");
				sb.append(fromDate);
				sb.append("')");
			}
		}
		else if ((toDate != null) && (!toDate.isEmpty())) {
			sb.append(" LOAD_DATE <= to_date('");
			sb.append(toDate);
			sb.append("')");
		}
		else {
			LOG.info("Date fields are null.  No date-based where clause "
					+ "will be added.");
		}
		return sb.toString();
	}
}
