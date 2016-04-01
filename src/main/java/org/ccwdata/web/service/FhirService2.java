package org.ccwdata.web.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.IGenericClient;

public class FhirService2 {
	private final String serverBase = "http://bluebuttonhapi-test.hhsdevcloud.us/baseDstu2";
	
	public IGenericClient connectionSetup(String serverBase) {
		// We're connecting to a DSTU1 compliant server in this example
		FhirContext ctx = FhirContext.forDstu2();
		// String serverBase = "http://fhirtest.uhn.ca/baseDstu2";
		// String serverBase = "http://wildfhir.aegis.net/fhir";

		IGenericClient client = ctx.newRestfulGenericClient(serverBase);
		return client;
	}
}
