package org.ccwdata.web.pojo.nih;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RxNorm {
	private NdcStatus ndcStatus;
	
	private PropConceptGroup propConceptGroup;

	
	
	public PropConceptGroup getPropConceptGroup() {
		return propConceptGroup;
	}
	
	public void setPropConceptGroup(PropConceptGroup propConceptGroup) {
		this.propConceptGroup = propConceptGroup;
	}
	public NdcStatus getNdcStatus() {
		return ndcStatus;
	}
	public void setNdcStatus(NdcStatus ndcStatus) {
		this.ndcStatus = ndcStatus;
	}
}
