package mil.nga.gdp.messages;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple POJO holding the error message data.  This class is serialized to
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

	private final boolean  error;
	private final String   message;
	private final Classification classification;
	
	/**
	 * Default no-arg constructor required by JAX-B
	 */
	public ErrorMessage(ErrorMessageBuilder builder) {
		error   = builder.error;
		message = builder.message;
		classification = new Classification.ClassificationBuilder()
				.releasability(builder.releasability)
				.classification(builder.classification)
				.build();
	}
	
	/**
	 * Getter method for the classification data.
	 * @return The Classification object.
	 */
	@JsonProperty(value="security")
	public Classification getClassification() {
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
	
	/**
	 * Internal static class implementing the builder creation pattern for new
	 * <code>ErrorMessage</code> objects.
	 * 
	 * @author L. Craig Carpenter
	 */
	public static class ErrorMessageBuilder {
		
		private boolean error = false;
		private String  message;
		private String  classification;
		private String  releasability;
		
		/** 
		 * Method used to construct an object of type ErrorMessage.
		 * @return An object of type ErrorMessage.
		 */
		public ErrorMessage build() {
			return new ErrorMessage(this);
		}
		
		/**
		 * Setter method for classification.
		 * @param value The associated classification.
		 */
		public ErrorMessageBuilder classification(String value) {
			classification = value;
			return this;
		}
		
		/**
		 * Flag indicating whether it is an error condition.
		 * @param value True if error, false otherwise.
		 */
		public ErrorMessageBuilder error(boolean value) {
			error = value;
			return this;
		}
		
		/**
		 * Setter method for the error message.
		 * @param value The error message.
		 */
		public ErrorMessageBuilder message(String value) {
			message = value;
			return this;
		}
		
		/**
		 * Setter method for releasability.
		 * @param value The associated releasability.
		 */
		public ErrorMessageBuilder releasability(String value) {
			releasability = value;
			return this;
		}
	}
}
