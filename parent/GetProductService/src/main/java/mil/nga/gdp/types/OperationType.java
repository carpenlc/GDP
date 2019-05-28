package mil.nga.gdp.types;

import mil.nga.gdp.exceptions.IllegalTypeException;

/**
 * Enumeration type holding a list of the various operations supported by the
 * GDP/GDN download services.
 * 
 * @author L. Craig Carpenter
 */
public enum OperationType {
	BY_BBOX("getproductsbbox"),
	BY_WKT("getproductswkt"),
	BY_UNIT("getproductsunit"),
	BY_COUNTRY("getproductscntry"),
	BY_JUMP_CODE("getproductsaorjmp");
	
	/**
	 * The text field
	 */
	private final String text;
	
	/**
	 * Default constructor
	 * @param value The text associated with the enumeration value.
	 */
	private OperationType(String value) {
		text = value;
	}
	
	/**
	 * Getter method for the text associated with the enumeration type.
	 * @return The text associated with the instanced enum.
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Convert an input String to it's associated enumeration type.  There is 
	 * no default type.  If the OperationType is not supplied an exception is
	 * raised.
	 * 
	 * @param value Input text information.
	 * @return The matching OperationType.
	 * @throws IllegalTypeException Thrown if the input value is null, or 
	 * cannot be matched to an operation type.
	 */
	public static OperationType fromString(String value) 
			throws IllegalTypeException {
		if ((value != null) && (!value.isEmpty())) {
			for (OperationType type : OperationType.values()) {
				if (value.equalsIgnoreCase(type.getText())) {
					return type;
				}
			}
			throw new IllegalTypeException (
					"[OperationType] Unknown operation requested.  "
					+ "Operation requested => [ "
					+ value
					+ " ].");
		}
		throw new IllegalTypeException (
				"[OperationType] Operation not supplied.  "
				+ "Input value is null or empty.");
	}
}
