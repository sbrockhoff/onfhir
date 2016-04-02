package org.ccwdata.web.pojo.nih;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropConceptGroup {
	@JsonProperty("propConcept")
	private List<PropConcept> propConceptList;

	
	public List<PropConcept> getPropConceptList() {
		return propConceptList;
	}

	
	public void setPropConceptList(List<PropConcept> propConceptList) {
		this.propConceptList = propConceptList;
	}
	
	
}
