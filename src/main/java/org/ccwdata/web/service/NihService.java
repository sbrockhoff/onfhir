package org.ccwdata.web.service;

import org.ccwdata.web.pojo.nih.NdcStatus;
import org.ccwdata.web.pojo.nih.RxNorm;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

@SuppressWarnings("deprecation")
public class NihService {
	private Client client;
	private WebResource baseResource;
	private String serviceUrl = "https://rxnav.nlm.nih.gov/REST/";
	
	public NihService() {
		ClientConfig clientConfig = new DefaultClientConfig();
		client = Client.create(clientConfig);
		client.addFilter(new LoggingFilter(System.out));
		baseResource = client.resource(serviceUrl);
	}
	
	public String getRxcuidByNdc(String ndc) {
		WebResource ndcResource = baseResource.path("ndcstatus").queryParam("ndc", ndc);
		
		ClientResponse response = ndcResource.accept("application/json").get(ClientResponse.class);
		
		if(response.getStatus() == 200) {
			RxNorm rxNorm = response.getEntity(RxNorm.class);
//			return ndcStatus.getNdcHistory().getActiveRxcui();
			return null;
		}
		else {
			return null;
		}
	}
}
