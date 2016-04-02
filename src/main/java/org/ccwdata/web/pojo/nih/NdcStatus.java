package org.ccwdata.web.pojo.nih;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NdcStatus {
	private String status;
//	private NdcHistory ndcHistory; TODO::map ndc history correctly
	
	
//	public NdcHistory getNdcHistory() {
//		return ndcHistory;
//	}
//
//	
//	public void setNdcHistory(NdcHistory ndcHistory) {
//		this.ndcHistory = ndcHistory;
//	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
