package org.ccwdata.web.pojo.nih;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "url"})
public class SourceConceptItem {

	private String id;
	private String name;
	private String url;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            The url
	 */
	public void setUrl(String url) {
		this.url = url;
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
