package org.ccwdata.web.pojo.nih;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class FullInteractionTypeGroup {

	private String sourceDisclaimer;
	private String sourceName;
	private List<FullInteractionType> fullInteractionType = new ArrayList<FullInteractionType>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * @return The sourceDisclaimer
	 */
	public String getSourceDisclaimer() {
		return sourceDisclaimer;
	}

	/**
	 * @param sourceDisclaimer
	 *            The sourceDisclaimer
	 */
	public void setSourceDisclaimer(String sourceDisclaimer) {
		this.sourceDisclaimer = sourceDisclaimer;
	}

	/**
	 * @return The sourceName
	 */
	public String getSourceName() {
		return sourceName;
	}

	/**
	 * @param sourceName
	 *            The sourceName
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}



	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public List<FullInteractionType> getFullInteractionType() {
		return fullInteractionType;
	}

	public void setFullInteractionType(List<FullInteractionType> fullInteractionType) {
		this.fullInteractionType = fullInteractionType;
	}

}
