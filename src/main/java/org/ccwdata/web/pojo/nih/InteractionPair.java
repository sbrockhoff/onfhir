package org.ccwdata.web.pojo.nih;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InteractionPair {

	private List<InteractionConcept> interactionConcept = new ArrayList<InteractionConcept>();
	private String severity;
	private String description;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * @return The interactionConcept
	 */
	public List<InteractionConcept> getInteractionConcept() {
		return interactionConcept;
	}

	/**
	 * @param interactionConcept
	 *            The interactionConcept
	 */
	public void setInteractionConcept(List<InteractionConcept> interactionConcept) {
		this.interactionConcept = interactionConcept;
	}

	/**
	 * @return The severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity
	 *            The severity
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @return The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            The description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
