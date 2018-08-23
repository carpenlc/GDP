package mil.nga.gdp.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.exceptions.IllegalTypeException;
import mil.nga.gdp.messages.ProductsByCountry;

/**
 * Class containing the business logic required to generate the SQL query
 * associated with a client request for query of products by country code.
 * Due to the amount of logic embedded, SQL query contruction was segregated
 * out into it's own class.
 * 
 * The class will accept an object of type 
 * <code>mil.nga.gdp.messages.ProductsByCountry</code> and return the 
 * associated SQL query.
 * 
 * The basic rules are the input country code can be either:
 * <li>2 character FIPS code.</li>
 * <li>3 character ISO code.</li>
 * 
 * 
 * @author L. Craig Carpenter
 */
public class CountryQueryGenerator 
		extends QueryGenerator implements GDPConstantsI {

	/** 
	 * Set up the logging subsystem for use throughout the class
	 */
	static final Logger LOG = LoggerFactory.getLogger(
			CountryQueryGenerator.class);
	
	private ProductsByCountry inMessage;
	
	/**
	 * Private constructor used to enforce the singleton design pattern.
	 */
	private CountryQueryGenerator () {}
	
	/**
	 * Create a String representing the SQL query associated with a client 
	 * request for querying by county/AOR.
	 * 
	 * @return The SQL query for products by country/AOR.
	 */
	public String generateQuery() throws IllegalStateException, IllegalTypeException {
		
		StringBuilder sb = new StringBuilder();
		
		if (inMessage.getCountryCode().length() == 2) {
			sb.append(getQueryByFIPSCode(
					inMessage.getCountryCode(),
					inMessage.getState()));
		}
		else if (inMessage.getCountryCode().length() == 3) {
			sb.append(getQueryByISOCode(
					inMessage.getCountryCode(),
					inMessage.getState()));
		}
		else if (inMessage.getCountryCode().equalsIgnoreCase(
				QUERY_BY_COMMAND)) {
			sb.append(getQueryByCommand(
					inMessage.getState().toUpperCase()));
		}
		else if (inMessage.getCountryCode().equalsIgnoreCase(
				QUERY_BY_JUMP_CODE)) {
			sb.append(getQueryByJumpCode(
					inMessage.getState().toUpperCase()));
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
	 * country and/or AOR.
	 * @param message The client-supplied input message.
	 * @throws IllegalStateException Thrown if the input message is null.
	 */
	protected void setMessageObj(ProductsByCountry message) 
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
	public static CountryQueryGenerator getInstance(
			ProductsByCountry message) 
					throws IllegalStateException { 
		return CountryQueryGeneratorHolder.getSingleton(message);
	}
	
	/**
	 * Static inner class used to construct the Singleton object.  This class
	 * exploits the fact that classes are not loaded until they are referenced
	 * therefore enforcing thread safety without the performance hit imposed
	 * by the <code>synchronized</code> keyword.
	 * 
	 * @author L. Craig Carpenter
	 */
	public static class CountryQueryGeneratorHolder {
		
		/**
		 * Reference to the Singleton instance of the OperationFactory
		 */
		private static CountryQueryGenerator _instance = new CountryQueryGenerator();
	
		/**
		 * Accessor method for the singleton instance of the 
		 * <code>CountryQueryGenerator</code>.
		 * @return The Singleton instance of the 
		 * <code>CountryQueryGenerator</code>.
		 * @throws IllegalStateException Thrown if the input message is null.
		 */
	    public static CountryQueryGenerator getSingleton(
	    		ProductsByCountry message) 
	    				throws IllegalStateException {
	    	_instance.setMessageObj(message);
	    	return _instance;
	    }
	    
	}
}
