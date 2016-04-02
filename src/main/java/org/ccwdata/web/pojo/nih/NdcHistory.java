package org.ccwdata.web.pojo.nih;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NdcHistory {
	private String activeRxcui;

	
	public String getActiveRxcui() {
		return activeRxcui;
	}

	
	public void setActiveRxcui(String activeRxcui) {
		this.activeRxcui = activeRxcui;
	}
}
