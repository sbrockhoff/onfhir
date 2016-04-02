package org.ccwdata.web.pojo.nih;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropConcept {
	private String propValue;

	
	public String getPropValue() {
		return propValue;
	}

	
	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}
}
