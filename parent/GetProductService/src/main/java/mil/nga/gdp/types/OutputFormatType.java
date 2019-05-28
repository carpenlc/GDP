package mil.nga.gdp.types;

import mil.nga.gdp.exceptions.InvalidParameterException;

/**
 * Enumeration type holding a list of the various output types provided by the
 * GDP/GDN download services.
 * 
 * @author L. Craig Carpenter
 */
public enum OutputFormatType {
	XML("xml"),
	JSON("json");
	
	/**
	 * The text field
	 */
	private final String text;
	
	/**
	 * Default constructor
	 * @param value The text associated with the enumeration value.
	 */
	private OutputFormatType(String value) {
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
	 * no default type.  The default type is JSON.
	 * 
	 * @param value Input text information.
	 * @return The matching OperationType.
	 * @throws InvalidParameterException Thrown if the input value is null, or 
	 * cannot be matched to an operation type.
	 */
	public static OutputFormatType fromString(String value) 
			throws InvalidParameterException {
		if ((value != null) && (!value.isEmpty())) {
			for (OutputFormatType type : OutputFormatType.values()) {
				if (value.equalsIgnoreCase(type.getText())) {
					return type;
				}
			}
			throw new InvalidParameterException(
					"Unknown output format requested.  Operation requested [ "
					+ value
					+ " ].");
		}
		return OutputFormatType.JSON;
	}
}
