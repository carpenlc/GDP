package mil.nga.gdp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.gdp.types.OperationType;
import mil.nga.gdp.exceptions.IllegalTypeException;
import mil.nga.gdp.exceptions.InvalidParameterException;
import mil.nga.gdp.messages.ProductsByAORJMPCode;
import mil.nga.gdp.messages.ProductsByBBox;
import mil.nga.gdp.messages.ProductsByCountry;
import mil.nga.gdp.messages.ProductsByUnit;
import mil.nga.gdp.messages.ProductsByWKT;

public class OperationFactory implements GDPConstantsI {

	/** 
	 * Set up the logging subsystem for use throughout the class
	 */
	static final Logger LOG = LoggerFactory.getLogger(
			OperationFactory.class);
	
	/**
	 * Private constructor enforcing the Singleton design pattern.
	 */
	private OperationFactory() { }
	
	/**
	 * Retrieve the operation type from the input parameter list.
	 * 
	 * @param params The servlet input parameters.
	 * @return The operation type requested by the user.
	 */
	private OperationType getOperationType(Map<String, String> params) 
			throws IllegalTypeException, InvalidParameterException, IllegalStateException { 
		if (params != null) {
			String operation = params.get(OPERATION_INPUT_PARAM);
			return OperationType.fromString(operation);
  		}
		else {
			throw new InvalidParameterException(
					"No input parameters supplied.");
		}
	}
	
	
	public void runOperation(Map<String, String> params) 
			throws IllegalTypeException, InvalidParameterException {
		OperationType type = getOperationType(params);
		switch (type) {
			case BY_BBOX:
				new ProductsByBBox.ProductsByBBoxBuilder()
						.fromMessage(params)
						.build();
			case BY_JUMP_CODE:
				new ProductsByAORJMPCode.ProductsByAORJMPCodeBuilder()
						.fromMessage(params)
						.build();
			case BY_WKT:
				new ProductsByWKT.ProductsByWKTBuilder()
						.fromMessage(params)
						.build();
			case BY_UNIT:
				new ProductsByUnit.ProductsByUnitBuilder()
						.fromMessage(params)
						.build();
			case BY_COUNTRY:
				new ProductsByCountry.ProductsByCountryBuilder()
						.fromMessage(params)
						.build();
			default:
				LOG.error("Unsupported operation type submitted.");
		}
	}
	
	/**
	 * Accessor method for the Singleton instance of the OperationFactory 
	 * object.
	 * @return The singleton OperationFactory object.
	 */
	public static OperationFactory getInstance() { 
		return OperationFactoryHolder.getSingleton();
	}
	
	/**
	 * Static inner class used to construct the Singleton object.  This class
	 * exploits the fact that classes are not loaded until they are referenced
	 * therefore enforcing thread safety without the performance hit imposed
	 * by the <code>synchronized</code> keyword.
	 * 
	 * @author L. Craig Carpenter
	 */
	public static class OperationFactoryHolder {
		
		/**
		 * Reference to the Singleton instance of the OperationFactory
		 */
		private static OperationFactory _instance = new OperationFactory();
	
		/**
		 * Accessor method for the singleton instance of the <code>OperationFactory</code>.
		 * @return The Singleton instance of the <code>OperationFactory</code>.
		 */
	    public static OperationFactory getSingleton() {
	    	return _instance;
	    }
	    
	}
}
