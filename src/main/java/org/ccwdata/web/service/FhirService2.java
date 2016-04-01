package org.ccwdata.web.service;

import org.ccwdata.web.pojo.PatientPojo;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.BundleEntry;
import ca.uhn.fhir.model.api.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.rest.gclient.StringClientParam;

public class FhirService2 {
	private final String serverBase = "http://bluebuttonhapi-test.hhsdevcloud.us/baseDstu2";
	private IGenericClient client;
	
	public FhirService2() {
		FhirContext ctx = FhirContext.forDstu2();

		client = ctx.newRestfulGenericClient(serverBase);
	}
	

	public PatientPojo getPatientByPatientId(String patientId) {
		Patient patient = null;
		Bundle bundle = client.search().forResource(Patient.class)
				.where(new StringClientParam("_id").matches().value(patientId)).execute();
		for (BundleEntry entry : bundle.getEntries()) {
			if (entry != null && !entry.getResource().isEmpty()) {
				patient = (Patient) entry.getResource();
			}
		}
		PatientPojo ppojo = new PatientPojo(patient);
		return ppojo;
	}
}
