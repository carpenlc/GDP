package mil.nga.gdp.exceptions;

/**
 * Thrown by the various service classes if a particular subsystem cannot 
 * be started (i.e. JPA)
 * 
 * @author L. Craig Carpenter
 */
public class ServiceUnavailableException extends Exception {
	
	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = -4330159340955045735L;

	/**
	 * Default constructor requiring an input message string.
	 * @param msg Description of the error encountered.
	 */
	public ServiceUnavailableException(String msg) {
		super(msg);
	}
}
