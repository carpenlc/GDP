package mil.nga.gdp.messages;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple POJO holding the error message data.  This class is unmarshaled to
 * JSON for providing feedback to callers.
 * 
 * @author L. Craig Carpenter
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorMessage implements Serializable {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = 854276464397186435L;

	private boolean        error          = false;
	private String         message        = null;;
	private Classification classification = null;
	
	/**
	 * Default no-arg constructor required by JAX-B
	 */
	public ErrorMessage() {}
	
	/**
	 * Alternate constructor allowing clients to set internal members on 
	 * construction.
	 * 
	 * @param error The error condition.
	 * @param message The error message.
	 * @param classification The classification
	 * @param releasability The releasability
	 */
	public ErrorMessage(
			boolean error, 
			String message, 
			String classification, 
			String releasability) {
		setError(error);
		setMessage(message);
		setClassification(classification);
		setReleasability(releasability);
	}
	
	/**
	 * Getter method for the classification data.
	 * @return The Classification object.
	 */
	@JsonProperty(value="security")
	public Classification getClassification() {
		if (classification == null) {
			classification = new Classification();
		}
		return classification;
	}
	
	/**
	 * Getter method for the flag indicating whether it is an error condition.
	 * @param value True if error, false otherwise.
	 */
	@JsonProperty(value="error")
	public boolean getError() {
		return error;
	}
	
	/**
	 * Getter method for the error message.
	 * @return The error message.
	 */
	@JsonProperty(value="message")
	public String getMessage() {
		return message;
	}
	
	/**
	 * Setter method for the classification data.
	 * @param classification The classification.
	 */
	public void setClassification(String classification) {
		if (this.classification == null) {
			this.classification = new Classification();
		}
		this.classification.setClassification(classification);
	}
	
	/**
	 * Flag indicating whether it is an error condition.
	 * @param value True if error, false otherwise.
	 */
	public void setError(boolean value) {
		error = value;
	}
	
	/**
	 * Setter method for the error message.
	 * @param value The error message.
	 */
	public void setMessage(String value) {
		message = value;
	}
	
	/**
	 * Setter method for the releasability data.
	 * @param releasability The releasability.
	 */
	public void setReleasability(String value) {
		if (this.classification == null) {
			this.classification = new Classification();
		}
		this.classification.setReleasability(value);
	}
	
	/**
	 * Convert to human-readable String.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("error => [ ");
		sb.append(Boolean.toString(getError()));
		sb.append(" ], message => [ ");
		sb.append(getMessage());
		sb.append(" ], ");
		if (this.classification != null) {
			sb.append(this.classification.toString());
		}
		else {
			sb.append("classification => [ ], releasability => [ ].");
		}
		return sb.toString();
	}
}
