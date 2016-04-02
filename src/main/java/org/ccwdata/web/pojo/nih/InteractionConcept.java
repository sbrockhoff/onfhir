package org.ccwdata.web.pojo.nih;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"minConceptItem", "sourceConceptItem"})
public class InteractionConcept {

	private MinConcept minConceptItem;
	private SourceConceptItem sourceConceptItem;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * @return The minConceptItem
	 */
	public MinConcept getMinConceptItem() {
		return minConceptItem;
	}

	/**
	 * @param minConceptItem
	 *            The minConceptItem
	 */
	public void setMinConceptItem(MinConcept minConceptItem) {
		this.minConceptItem = minConceptItem;
	}

	/**
	 * @return The sourceConceptItem
	 */
	public SourceConceptItem getSourceConceptItem() {
		return sourceConceptItem;
	}

	/**
	 * @param sourceConceptItem
	 *            The sourceConceptItem
	 */
	public void setSourceConceptItem(SourceConceptItem sourceConceptItem) {
		this.sourceConceptItem = sourceConceptItem;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
