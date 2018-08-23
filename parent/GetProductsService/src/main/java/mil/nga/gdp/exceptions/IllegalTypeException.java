package mil.nga.gdp.exceptions;

/**
 * Thrown by the various enumeration classes if operations are attempted
 * using something invalid for that type. 
 * 
 * @author L. Craig Carpenter
 */
public class IllegalTypeException extends Exception {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = -6062034988016072894L;

	/**
	 * Default constructor requiring an input message string.
	 * @param msg Description of the error encountered.
	 */
	public IllegalTypeException(String msg) {
		super(msg);
	}
}
