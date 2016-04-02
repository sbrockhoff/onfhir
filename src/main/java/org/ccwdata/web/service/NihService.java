package org.ccwdata.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Encoded;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.pattern.NDCPatternConverter;
import org.ccwdata.web.pojo.nih.FullInteraction;
import org.ccwdata.web.pojo.nih.NdcStatus;
import org.ccwdata.web.pojo.nih.RxNorm;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

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
			if(rxNorm.getNdcStatus() != null && rxNorm.getNdcStatus().getNdcHistoryList() != null && !rxNorm.getNdcStatus().getNdcHistoryList().isEmpty()) {
				String rxcuid = rxNorm.getNdcStatus().getNdcHistoryList().get(0).getActiveRxcui();
				return rxcuid;
			}
			return null;
		}else {
			return null;
		}
	}

	@Encoded
	private String rxcui = new String();

	public FullInteraction retrieveInteractionForList(List<String> rxcuiList) {
		FullInteraction fullInteraction = null;
		rxcui = new String();
		// MultivaluedMap<String, String> rxMap = new MultivaluedMapImpl();
		for(String rx : rxcuiList) {
			if(!rxcui.isEmpty()) {
				rxcui = rxcui + " " + rx;
			}else {
				rxcui = rx;
			}
			// rxMap.add("rxcuis", rx);
		}
//		Builder ndcResource = baseResource.path("interaction/list").queryParam("rxcuis", rxcui).accept(MediaType.TEXT_PLAIN);

		WebResource ndcResource = baseResource.path("interaction/list").queryParam("rxcuis", rxcui);
		// WebResource ndcResource = baseResource.path("interaction/list").queryParams(rxMap);
		ClientResponse response = ndcResource.accept("application/json").get(ClientResponse.class);

		if(response.getStatus() == 200) {
			fullInteraction = response.getEntity(FullInteraction.class);
		}

		return fullInteraction;
	}

}
