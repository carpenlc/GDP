package mil.nga.npd.types;

import mil.nga.npd.exceptions.InvalidParameterException;

/**
 * Enumeration object containing a list of the operations supported by the 
 * elevation services application.
 * 
 * @author L. Craig Carpenter
 */
public enum ElevationOperationType {
	GET_ELEVATION_AT("GetElevationAt"),
    GET_MIN_MAX_ELEVATIONS("GetMinMaxElevations"),
    GET_MIN_MAX_ELEVATIONS_WKT("GetMinMaxElevationsWKT");

    /**
     * The internal text field.
     */
    private final String text;
    
    /**
     * Default constructor taking the text name of the operation.
     * @param value The operation requested.
     */
    ElevationOperationType(String value) {
        text = value;
    }
	
    /**
     * Getter method for the text representation of the enumeration type.
     * @return The text associate with the enumeration value.
     */
    public String getText() {
        return text;
    }
    
    /**
     * Convert an input String to it's associated enumeration type.  There is 
     * no default type.
     * 
     * @param value Input text information.
     * @return The matching OperationType.
     * @throws InvalidParameterException Thrown if the input value is null, or 
     * cannot be matched to an operation type.
     */
    public static ElevationOperationType fromString(String value) 
            throws InvalidParameterException {
        if ((value != null) && (!value.isEmpty())) {
            for (ElevationOperationType type : ElevationOperationType.values()) {
                if (value.equalsIgnoreCase(type.getText())) {
                    return type;
                }
            }
            throw new InvalidParameterException(
                    "Unknown elevation operation requested.  Operation requested [ "
                    + value
                    + " ].");
        }
        throw new InvalidParameterException(
                "Unknown elevation operation requested.  Operation requested [ "
                + value
                + " ].");
    }
	
}
