package mil.nga.gdp.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.exceptions.IllegalTypeException;
import mil.nga.gdp.messages.ProductsByAORJMPCode;

/**
 * Class containing the business logic required to generate the SQL query
 * associated with a client request for query of products by AOR or JUMP codes.
 * Due to the amount of logic embedded, SQL query construction was segregated
 * out into it's own class.
 * 
 * The class will accept an object of type 
 * <code>mil.nga.gdp.messages.ProductsByAORJMPCode</code> and return the 
 * associated SQL query.
 * 
 * The basic rules are the input country code can be either:
 * <li>2 character FIPS code.</li>
 * <li>3 character ISO code.</li>
 * 
 * 
 * @author L. Craig Carpenter
 */
public class AorOrJumpCodeQueryGenerator 
		extends QueryGenerator implements GDPConstantsI {

	/** 
	 * Set up the logging subsystem for use throughout the class
	 */
	static final Logger LOG = LoggerFactory.getLogger(
			AorOrJumpCodeQueryGenerator.class);

	private ProductsByAORJMPCode inMessage;

	/**
	 * Private constructor used to enforce the singleton design pattern.
	 */
	private AorOrJumpCodeQueryGenerator () {}
	
	/**
	 * Create a String representing the SQL query associated with a client 
	 * request for querying by AOR/JUMP code.
	 * 
	 * @return The SQL query for products by AOR/JUMP code.
	 */
	public String generateQuery() throws IllegalStateException, IllegalTypeException {
		
		StringBuilder sb = new StringBuilder();
		
		if (inMessage.getAorOrCode().length() == 2) {
			sb.append(getQueryByFIPSCode(
					inMessage.getAorOrCode(),
					inMessage.getCode()));
		}
		else if (inMessage.getAorOrCode().length() == 3) {
			sb.append(getQueryByISOCode(
					inMessage.getAorOrCode(),
					inMessage.getCode()));
		}
		else if (inMessage.getAorOrCode().equalsIgnoreCase(
				QUERY_BY_COMMAND)) {
			sb.append(getQueryByCommand(
					inMessage.getCode().toUpperCase()));
		}
		else if (inMessage.getAorOrCode().equalsIgnoreCase(
				QUERY_BY_JUMP_CODE)) {
			sb.append(getQueryByJumpCode(
					inMessage.getCode().toUpperCase()));
		}
		else {
			
		}
		
		// Add the date where clause if required.
		sb.append(getDateWhereClause(
				inMessage.getFromDateAsString(), 
				inMessage.getToDateAsString()));
		
		return sb.toString();
	}
	
	/**
	 * Setter method for the incoming message object requesting a query by 
	 * AOR or JUMP code.
	 * @param message The client-supplied input message.
	 * @throws IllegalStateException Thrown if the input message is null.
	 */
	protected void setMessageObj(ProductsByAORJMPCode message) 
			throws IllegalStateException {
		if (message != null) {
			inMessage = message;
		}
		else {
			throw new IllegalStateException("ERROR: Input ProductsByCountry "
					+ "message is null.");
		}
	}
	
	/**
	 * Accessor method for the Singleton instance of the OperationFactory 
	 * object.
	 * @return The singleton OperationFactory object.
	 * @throws IllegalStateException Thrown if the input message is null.
	 */
	public static AorOrJumpCodeQueryGenerator getInstance(
			ProductsByAORJMPCode message) 
					throws IllegalStateException { 
		return AorOrJumpCodeQueryGeneratorHolder.getSingleton(message);
	}
	
	/**
	 * Static inner class used to construct the Singleton object.  This class
	 * exploits the fact that classes are not loaded until they are referenced
	 * therefore enforcing thread safety without the performance hit imposed
	 * by the <code>synchronized</code> keyword.
	 * 
	 * @author L. Craig Carpenter
	 */
	public static class AorOrJumpCodeQueryGeneratorHolder {
		
		/**
		 * Reference to the Singleton instance of the AorOrJumpCodeQueryGenerator
		 */
		private static AorOrJumpCodeQueryGenerator _instance = new AorOrJumpCodeQueryGenerator();
	
		/**
		 * Accessor method for the singleton instance of the 
		 * <code>AorOrJumpCodeQueryGenerator</code>.
		 * @return The Singleton instance of the 
		 * <code>AorOrJumpCodeQueryGenerator</code>.
		 * @throws IllegalStateException Thrown if the input message is null.
		 */
	    public static AorOrJumpCodeQueryGenerator getSingleton(
	    		ProductsByAORJMPCode message) 
	    				throws IllegalStateException {
	    	_instance.setMessageObj(message);
	    	return _instance;
	    }
	    
	}
}
