package mil.nga.gdp.messages;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Simple POJO holding the classification information.  A separate class was
 * introduced to maintain backwards compatibility when unmarshaled to JSON.
 * 
 * @author L. Craig Carpenter
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value="security")
public class Classification implements Serializable {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = -1401773116895257882L;

	private final String classification;
	private final String releasability;
	
	/**
	 * Default constructor requiring clients to supply the builder object.
	 * @param builder The builder object.
	 */
	public Classification(ClassificationBuilder builder) {
		classification = builder.classification;
		releasability  = builder.releasability;
	} 
	
	/**
	 * Getter method for classification.
	 * @return The classification.
	 */
	@JsonProperty(value="classif")
	public String getClassification() {
		return classification;
	}
	
	/**
	 * Getter method for releasability.
	 * @return The releasability.
	 */
	@JsonProperty(value="rel")
	public String getReleasability() {
		return releasability;
	}

	/**
	 * Convert to human-readable String.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("classification => [ ");
		sb.append(getClassification());
		sb.append(" ], releasability => [ ");
		sb.append(getReleasability());
		sb.append(" ]");
		return sb.toString();
	}
	
	/**
	 * Internal static class implementing the builder creation pattern for new
	 * <code>Classification</code> objects.
	 * 
	 * @author L. Craig Carpenter
	 */
	public static class ClassificationBuilder {
		
		private String classification;
		private String releasability;
		
		/** 
		 * Method used to construct an object of type Classification.
		 * @return An object of type classification.
		 */
		public Classification build() {
			validateClassificationObject();
			return new Classification(this);
		}
		
		/**
		 * Setter method for releasability.
		 * @param value The associated releasability.
		 */
		public ClassificationBuilder releasability(String value) {
			releasability = value;
			return this;
		}
		
		/**
		 * Setter method for classification.
		 * @param value The associated classification.
		 */
		public ClassificationBuilder classification(String value) {
			classification = value;
			return this;
		}

		/**
		 * Validate the internal fields before allowing construction of
		 * a new object.
		 */
		public void validateClassificationObject() {
			if (classification == null) {
				classification = "";
			}
			if (releasability == null) {
				releasability = "";
			}
		}
	}
}
