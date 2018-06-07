package mil.nga.gdp;

import mil.nga.gdp.types.OperationType;

public class OperationFactory {

	/**
	 * Private constructor enforcing the Singleton design pattern.
	 */
	private OperationFactory() { }
	
	
	public OperationI getOperationImpl(OperationType type) {
		OperationI concrete = null;
		if (type == OperationType.BY_BBOX) {
			
		}
		
		return concrete;
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
