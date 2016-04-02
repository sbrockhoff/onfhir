package org.ccwdata.web.pojo.nih;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullInteractionType {

	private String comment;
	private List<MinConcept> minConcept;
	private List<InteractionPair> interactionPair = new ArrayList<InteractionPair>();
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * @return The comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            The comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<MinConcept> getMinConcept() {
		return minConcept;
	}

	public void setMinConcept(List<MinConcept> minConcept) {
		this.minConcept = minConcept;
	}

	/**
	 * @return The interactionPair
	 */
	public List<InteractionPair> getInteractionPair() {
		return interactionPair;
	}

	/**
	 * @param interactionPair
	 *            The interactionPair
	 */
	public void setInteractionPair(List<InteractionPair> interactionPair) {
		this.interactionPair = interactionPair;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
