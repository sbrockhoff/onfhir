package org.ccwdata.web.pojo.nih;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RxNorm {
	private NdcStatus ndcStatus;

	
	public NdcStatus getNdcStatus() {
		return ndcStatus;
	}
	public void setNdcStatus(NdcStatus ndcStatus) {
		this.ndcStatus = ndcStatus;
	}
}
