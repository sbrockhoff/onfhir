package org.ccwdata.web.pojo.nih;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"sources", "rxcui"})
public class UserInput {

	private List<String> sources = new ArrayList<String>();
	private String rxcui;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * @return The sources
	 */
	public List<String> getSources() {
		return sources;
	}

	/**
	 * @param sources
	 *            The sources
	 */
	public void setSources(List<String> sources) {
		this.sources = sources;
	}

	/**
	 * @return The rxcui
	 */
	public String getRxcui() {
		return rxcui;
	}

	/**
	 * @param rxcui
	 *            The rxcui
	 */
	public void setRxcui(String rxcui) {
		this.rxcui = rxcui;
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
