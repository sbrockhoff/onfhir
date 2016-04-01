package org.ccwdata.client;

import java.io.IOException;
import java.util.List;

import org.hl7.fhir.instance.model.Bundle;
import org.hl7.fhir.instance.model.Enumerations.AdministrativeGender;

import ca.uhn.fhir.context.FhirContext;

import ca.uhn.fhir.model.api.BundleEntry;
import ca.uhn.fhir.model.dstu.composite.QuantityDt;
import ca.uhn.fhir.model.dstu.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu.resource.Observation;
import ca.uhn.fhir.model.dstu.resource.Organization;
import ca.uhn.fhir.model.dstu.resource.Patient;
import ca.uhn.fhir.model.dstu.valueset.ObservationStatusEnum;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.model.dstu.valueset.AdministrativeGenderCodesEnum;
import ca.uhn.fhir.model.valueset.BundleTypeEnum;
import ca.uhn.fhir.rest.client.IGenericClient;

public class Client {
	
	public static void main(String[] args) {
		Client client = new Client();
		client.execute();
	}
	
	public void execute() {
		
		String clientUrl1 = "http://wildfhir.aegis.net/fhir";
		
		String clientUrl2 = "http://fhirtest.uhn.ca/base";
		String clientUrl3 = "https://fhir-api.smartplatforms.org/";
	
		 // Create a client (only needed once)
		 FhirContext ctx = new FhirContext();
		 
		// Set how long to try and establish the initial TCP connection (in ms)
		 ctx.getRestfulClientFactory().setConnectTimeout(20 * 1000);
		  
		 // Set how long to block for individual read/write operations (in ms)
		 ctx.getRestfulClientFactory().setSocketTimeout(20 * 1000);
		 
		// Set connections to access the network via the HTTP proxy at
		// example.com : 8888
//		ctx.getRestfulClientFactory().setProxy("example.com", 8888);
		 
		// If the proxy requires authentication, use the following as well
//		ctx.getRestfulClientFactory().setProxyCredentials("theUsername", "thePassword");
		 
		 IGenericClient client = ctx.newRestfulGenericClient(clientUrl1);
	
		 // Invoke the client
		 ca.uhn.fhir.model.api.Bundle bundle = client.search()
		         .forResource(Patient.class)
		         .execute();
	
		 System.out.println("patients count=" + bundle.size());
		 
		 List<Patient> list = bundle.getResources(Patient.class);
		 
		 for (Patient p : list) {
		     System.out.println("name=" + p.getName());
		 }
	 
	}
	
}
