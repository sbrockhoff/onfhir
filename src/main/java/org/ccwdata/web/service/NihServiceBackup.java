//package org.ccwdata.web.service;
//
//import java.io.BufferedInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.ccwdata.pojo.json.FullInteraction;
//import org.ccwdata.pojo.json.Interaction;
//import org.ccwdata.web.pojo.NdcStatusPojo;
//import org.codehaus.jackson.map.ObjectMapper;
//
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//import com.sun.jersey.api.client.config.ClientConfig;
//import com.sun.jersey.api.client.config.DefaultClientConfig;
//
//@SuppressWarnings("deprecation")
//public class NihServiceBackup {
//	private Client client;
//	private WebResource baseResource;
//	private String serviceUrl = "https://rxnav.nlm.nih.gov/REST/";
//	
//	public void init() {
//		ClientConfig clientConfig = new DefaultClientConfig();
//		client = Client.create(clientConfig);
//		//client.addFilter(new LoggingFilter(System.out));
//		baseResource = client.resource(serviceUrl);
//	}
//	
//	public String getRxcuidByNdc(String ndc) {
//		WebResource ndcResource = baseResource.path("ndcstatus").queryParam("ndc", ndc);
//		
//		ClientResponse response = ndcResource.accept("application/json").get(ClientResponse.class);
//		
//		if(response.getStatus() == 200) {
//			NdcStatusPojo ndcPojo = response.getEntity(NdcStatusPojo.class);
//			return ndcPojo.getRcxui();
//		}
//		else {
//			return null;
//		}
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//	public Interaction retrieveInteraction(String drugName) {
//		// Get interactions
//		String rxcui = retrieveRxCui(drugName);
//
//		if(rxcui != null && !rxcui.isEmpty()) {
//			Interaction interaction = retrieveInteractions(rxcui);
//			if(interaction != null) {
//				interaction.setDrugName(drugName);
//				return interaction;
//			}
//		}
//
//		return null;
//	}
//
//	public FullInteraction retrieveInteractionForList(List<String> drugNames) {
//		//Get all rxcuis first
//		List<String> rxcuis = new ArrayList<>();
//		for(String dn : drugNames) {
//			if(StringUtils.isNotBlank(dn) && StringUtils.isAlpha(dn)) {
//				String rxcui = retrieveRxCui(dn);
//				if(StringUtils.isNotBlank(rxcui)) {
//					rxcuis.add(rxcui);
//				}
//			}
//		}
//
//		//Get interactions for the list
//		if(rxcuis != null && !rxcuis.isEmpty()) {
//			FullInteraction fullInteraction = retrieveInteractions(rxcuis);
//			return fullInteraction;
//		}
//
//		return null;
//	}
//
//	public String retrieveRxCui(String name) {
//
//		String rxCui = "";
//
//		HttpClient httpClient = new DefaultHttpClient();
//		try {
//
//			HttpGet httpGetRequest = new HttpGet("https://rxnav.nlm.nih.gov/REST/rxcui?name=" + URLEncoder.encode(name, "UTF-8"));
//
//			// Execute HTTP request
//			HttpResponse httpResponse = httpClient.execute(httpGetRequest);
//
//			// Get hold of the response entity
//			HttpEntity entity = httpResponse.getEntity();
//
//			// If the response does not enclose an entity, there is no need
//			// to bother about connection release
//			byte[] buffer = new byte[1024];
//			if (entity != null) {
//				InputStream inputStream = entity.getContent();
//				try {
//					int bytesRead = 0;
//					BufferedInputStream bis = new BufferedInputStream(inputStream);
//					while ((bytesRead = bis.read(buffer)) != -1) {
//						String xml = new String(buffer, 0, bytesRead);
//
//						if(xml !=null && xml.indexOf("<rxnormId>") > 0) {
//							rxCui = xml.split("<rxnormId>")[1].split("</rxnormId>")[0];
//						}
//
//					}
//				} catch (IOException ioException) {
//					// In case of an IOException the connection will be released
//					// back to the connection manager automatically
//					ioException.printStackTrace();
//				} catch (RuntimeException runtimeException) {
//					// In case of an unexpected exception you may want to abort
//					// the HTTP request in order to shut down the underlying
//					// connection immediately.
//					httpGetRequest.abort();
//					runtimeException.printStackTrace();
//				} finally {
//					// Closing the input stream will trigger connection release
//					try {
//						inputStream.close();
//					} catch (Exception ignore) {
//					}
//				}
//			}
//		} catch (ClientProtocolException e) {
//			// thrown by httpClient.execute(httpGetRequest)
//			e.printStackTrace();
//		} catch (IOException e) {
//			// thrown by entity.getContent();
//			e.printStackTrace();
//		} finally {
//			// When HttpClient instance is no longer needed,
//			// shut down the connection manager to ensure
//			// immediate deallocation of all system resources
//			httpClient.getConnectionManager().shutdown();
//		}
//
//		return rxCui;
//	}
//
//	public FullInteraction retrieveInteractions(List<String> rxcuisList) {
//		String jsonStr = "";
//
//		String rxcuis = StringUtils.join(rxcuisList, "+");
//
//		HttpClient httpClient = new DefaultHttpClient();
//		try {
//
//			HttpGet httpGetRequest = new HttpGet("https://rxnav.nlm.nih.gov/REST/interaction/list.json?rxcuis=" + rxcuis);
//
//			// Execute HTTP request
//			HttpResponse httpResponse = httpClient.execute(httpGetRequest);
//
//			// Get hold of the response entity
//			HttpEntity entity = httpResponse.getEntity();
//
//			// If the response does not enclose an entity, there is no need
//			// to bother about connection release
//			byte[] buffer = new byte[1024];
//			if (entity != null) {
//				InputStream inputStream = entity.getContent();
//				try {
//					int bytesRead = 0;
//					BufferedInputStream bis = new BufferedInputStream(inputStream);
//					while ((bytesRead = bis.read(buffer)) != -1) {
//						String chunk = new String(buffer, 0, bytesRead);
//						jsonStr += chunk;
//					}
//				} catch (IOException ioException) {
//					// In case of an IOException the connection will be released
//					// back to the connection manager automatically
//					ioException.printStackTrace();
//				} catch (RuntimeException runtimeException) {
//					// In case of an unexpected exception you may want to abort
//					// the HTTP request in order to shut down the underlying
//					// connection immediately.
//					httpGetRequest.abort();
//					runtimeException.printStackTrace();
//				} finally {
//					// Closing the input stream will trigger connection release
//					try {
//						inputStream.close();
//					} catch (Exception ignore) {
//					}
//				}
//			}
//		} catch (ClientProtocolException e) {
//			// thrown by httpClient.execute(httpGetRequest)
//			e.printStackTrace();
//		} catch (IOException e) {
//			// thrown by entity.getContent();
//			e.printStackTrace();
//		} finally {
//			// When HttpClient instance is no longer needed,
//			// shut down the connection manager to ensure
//			// immediate deallocation of all system resources
//			httpClient.getConnectionManager().shutdown();
//		}
//
//		ObjectMapper mapper = new ObjectMapper();
//		FullInteraction fullInteraction = null;
//		try {
//			fullInteraction = mapper.readValue(jsonStr, FullInteraction.class);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return fullInteraction;
//	}
//
//	public Interaction retrieveInteractions(String rxcui) {
//
//		String jsonStr = "";
//
//		HttpClient httpClient = new DefaultHttpClient();
//		try {
//
//			HttpGet httpGetRequest = new HttpGet("https://rxnav.nlm.nih.gov/REST/interaction/interaction.json?rxcui=" + URLEncoder.encode(rxcui, "UTF-8"));
//
//			// Execute HTTP request
//			HttpResponse httpResponse = httpClient.execute(httpGetRequest);
//
//			// Get hold of the response entity
//			HttpEntity entity = httpResponse.getEntity();
//
//			// If the response does not enclose an entity, there is no need
//			// to bother about connection release
//			byte[] buffer = new byte[1024];
//			if (entity != null) {
//				InputStream inputStream = entity.getContent();
//				try {
//					int bytesRead = 0;
//					BufferedInputStream bis = new BufferedInputStream(inputStream);
//					while ((bytesRead = bis.read(buffer)) != -1) {
//						String chunk = new String(buffer, 0, bytesRead);
//						jsonStr += chunk;
//					}
//				} catch (IOException ioException) {
//					// In case of an IOException the connection will be released
//					// back to the connection manager automatically
//					ioException.printStackTrace();
//				} catch (RuntimeException runtimeException) {
//					// In case of an unexpected exception you may want to abort
//					// the HTTP request in order to shut down the underlying
//					// connection immediately.
//					httpGetRequest.abort();
//					runtimeException.printStackTrace();
//				} finally {
//					// Closing the input stream will trigger connection release
//					try {
//						inputStream.close();
//					} catch (Exception ignore) {
//					}
//				}
//			}
//		} catch (ClientProtocolException e) {
//			// thrown by httpClient.execute(httpGetRequest)
//			e.printStackTrace();
//		} catch (IOException e) {
//			// thrown by entity.getContent();
//			e.printStackTrace();
//		} finally {
//			// When HttpClient instance is no longer needed,
//			// shut down the connection manager to ensure
//			// immediate deallocation of all system resources
//			httpClient.getConnectionManager().shutdown();
//		}
//
//		ObjectMapper mapper = new ObjectMapper();
//		Interaction interaction = null;
//		try {
//			interaction = mapper.readValue(jsonStr, Interaction.class);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return interaction;
//	}
//
//}
