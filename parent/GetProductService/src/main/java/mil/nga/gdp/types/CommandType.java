package mil.nga.gdp.types;

import mil.nga.gdp.exceptions.IllegalTypeException;

/**
 * Enumeration type holding a list of the various military commands.
 * 
 * @author L. Craig Carpenter
 */
public enum CommandType {
    NORTHCOM("northcom"), 
    SOUTHCOM("southcom"),
    AFRICOM("africom"),
    PACOM("pacom"),
    EUCOM("eucom"),
    CENTCOM("centcom");

	/**
	 * The text field
	 */
	private final String text;
	
	/**
	 * Default constructor
	 * @param value The text associated with the enumeration value.
	 */
	private CommandType(String value) {
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
	 * no default type.  If the CommandType is not supplied an exception is
	 * raised.
	 * 
	 * @param value Input text information.
	 * @return The matching CommandType.
	 * @throws IllegalTypeException Thrown if the input value is null, or 
	 * cannot be matched to an command type.
	 */
	public static CommandType fromString(String value) 
			throws IllegalTypeException {
		if ((value != null) && (!value.isEmpty())) {
			for (CommandType type : CommandType.values()) {
				if (value.equalsIgnoreCase(type.getText())) {
					return type;
				}
			}
			throw new IllegalTypeException(
					"[CommandType] Unknown Command.  Command requested => [ "
					+ value
					+ " ].");
		}
		throw new IllegalTypeException(
				"[CommandType] Command not supplied.  "
				+ "Input value is null or empty.");
	}
}
