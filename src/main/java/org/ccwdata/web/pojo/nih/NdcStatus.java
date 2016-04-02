package org.ccwdata.web.pojo.nih;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NdcStatus {
	private String status;
	
	@JsonProperty("ndcHistory")
	private List<NdcHistory> ndcHistoryList;
	
	
	

	
	public List<NdcHistory> getNdcHistoryList() {
		return ndcHistoryList;
	}

	
	public void setNdcHistoryList(List<NdcHistory> ndcHistoryList) {
		this.ndcHistoryList = ndcHistoryList;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
