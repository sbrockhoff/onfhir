package org.ccwdata.web.pojo.nih;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MinConcept {

	private String rxcui;
	private String name;
	private String tty;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
	 * @return The tty
	 */
	public String getTty() {
		return tty;
	}

	/**
	 * @param tty
	 *            The tty
	 */
	public void setTty(String tty) {
		this.tty = tty;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
