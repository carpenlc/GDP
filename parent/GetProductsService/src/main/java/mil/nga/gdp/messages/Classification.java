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

	private String classification = "";
	private String releasability = "";
	
	/**
	 * Default no-arg constructor required by JAX-B
	 */
	public Classification() {} 
	
	/**
	 * Alternate constructor allowing clients to set internal members on 
	 * construction.
	 * @param classification The classification
	 * @param releasability The releasability
	 */
	public Classification(String classification, String releasability) { 
		setClassification(classification);
		setReleasability(releasability);
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
	 * Setter method for classification.
	 * @param value The associated classification.
	 */
	public void setClassification(String value) {
		classification = value;
	}
	
	/**
	 * Setter method for releasability.
	 * @param value The associated releasability.
	 */
	public void setReleasability(String value) {
		releasability = value;
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
}
