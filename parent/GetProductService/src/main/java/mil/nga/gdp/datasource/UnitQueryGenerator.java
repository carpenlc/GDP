package mil.nga.gdp.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.exceptions.IllegalTypeException;
import mil.nga.gdp.messages.ProductsByUnit;

/**
 * 
 * 
 * @author L. Craig Carpenter
 */
public class UnitQueryGenerator 
		extends QueryGenerator implements GDPConstantsI {

	/** 
	 * Set up the logging subsystem for use throughout the class
	 */
	static final Logger LOG = LoggerFactory.getLogger(
			UnitQueryGenerator.class);
	
	/**
	 * Input message.
	 */
	private ProductsByUnit inMessage;
	
	/**
	 * Private constructor used to enforce the singleton design pattern.
	 */
	private UnitQueryGenerator () {}
	
	/**
	 * Create a String representing the SQL query associated with a client 
	 * request for querying by county/AOR.
	 * 
	 * @return The SQL query for products by country/AOR.
	 */
	public String generateQuery() throws IllegalStateException, IllegalTypeException {
		
		StringBuilder sb = new StringBuilder();
		
		if ((inMessage.getDownloadID() != null) && 
				(!inMessage.getDownloadID().isEmpty())) {
			
			
			
			// Add the date where clause if required.
			sb.append(getDateWhereClause(
					inMessage.getFromDateAsString(), 
					inMessage.getToDateAsString()));
			
		}
		else {
			throw new IllegalStateException("The input message [ "
					+ ProductsByUnit.class.getName()
					+ " ] contains a null downloadID value.");
		}
		return sb.toString();
	}
	
	/**
	 * Accessor method for the Singleton instance of the OperationFactory 
	 * object.
	 * @return The singleton OperationFactory object.
	 * @throws IllegalStateException Thrown if the input message is null.
	 */
	public static UnitQueryGenerator getInstance(
			ProductsByUnit message) 
					throws IllegalStateException { 
		return UnitQueryGeneratorHolder.getSingleton(message);
	}
	
	/**
	 * Setter method for the incoming message object requesting a query by 
	 * unit.
	 * @param message The client-supplied input message.
	 * @throws IllegalStateException Thrown if the input message is null.
	 */
	protected void setMessageObj(ProductsByUnit message) 
			throws IllegalStateException {
		if (message != null) {
			inMessage = message;
		}
		else {
			throw new IllegalStateException("ERROR: Input ProductsByUnit "
					+ "message is null.");
		}
	}
	
	/**
	 * Static inner class used to construct the Singleton object.  This class
	 * exploits the fact that classes are not loaded until they are referenced
	 * therefore enforcing thread safety without the performance hit imposed
	 * by the <code>synchronized</code> keyword.
	 * 
	 * @author L. Craig Carpenter
	 */
	public static class UnitQueryGeneratorHolder {
		
		/**
		 * Reference to the Singleton instance of the UnitQueryGenerator
		 */
		private static UnitQueryGenerator _instance = new UnitQueryGenerator();
	
		/**
		 * Accessor method for the singleton instance of the 
		 * <code>CountryQueryGenerator</code>.
		 * @return The Singleton instance of the 
		 * <code>CountryQueryGenerator</code>.
		 * @throws IllegalStateException Thrown if the input message is null.
		 */
	    public static UnitQueryGenerator getSingleton(
	    		ProductsByUnit message) 
	    				throws IllegalStateException {
	    	_instance.setMessageObj(message);
	    	return _instance;
	    }
	    
	}
	
}
