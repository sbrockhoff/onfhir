package org.ccwdata.web.pojo.nih;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FullInteraction {

	private String nlmDisclaimer;

	private UserInput userInput;

	private List<FullInteractionTypeGroup> fullInteractionTypeGroup = new ArrayList<FullInteractionTypeGroup>();

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();


	public FullInteraction() {}

	public String getNlmDisclaimer() {
		return nlmDisclaimer;
	}

	public void setNlmDisclaimer(String nlmDisclaimer) {
		this.nlmDisclaimer = nlmDisclaimer;
	}

	public UserInput getUserInput() {
		return userInput;
	}

	public void setUserInput(UserInput userInput) {
		this.userInput = userInput;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public List<FullInteractionTypeGroup> getFullInteractionTypeGroup() {
		return fullInteractionTypeGroup;
	}

	public void setFullInteractionTypeGroup(List<FullInteractionTypeGroup> fullInteractionTypeGroup) {
		this.fullInteractionTypeGroup = fullInteractionTypeGroup;
	}


}
