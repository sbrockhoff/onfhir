package org.ccwdata.web.service;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.BundleEntry;
import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.model.api.Bundle;
import ca.uhn.fhir.model.dstu2.resource.ExplanationOfBenefit;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.rest.gclient.StringClientParam;

public class FhirService2 {

	private final String serverBase = "http://bluebuttonhapi-test.hhsdevcloud.us/baseDstu2";

	public IGenericClient connectionSetup(String serverBase) {
		// We're connecting to a DSTU1 compliant server in this example
		FhirContext ctx = FhirContext.forDstu2();

		IGenericClient client = ctx.newRestfulGenericClient(serverBase);
		return client;
	}

	public Patient getPatientByPatientId(String patientId) {
		IGenericClient client = connectionSetup(this.serverBase);
		Patient patient = null;
		Bundle bundle = client.search().forResource(Patient.class).where(new StringClientParam("_id").matches().value(patientId)).execute();
		for(BundleEntry entry : bundle.getEntries()) {
			if(entry != null && !entry.getResource().isEmpty()) {
				patient = (Patient) entry.getResource();
			}
		}
		return patient;
	}

	public List<ExplanationOfBenefit> getEobByPatientId(String patientId) {
		IGenericClient client = connectionSetup(this.serverBase);
		List<ExplanationOfBenefit> eob = new ArrayList<ExplanationOfBenefit>();
		Bundle bundle = client.search().forResource(ExplanationOfBenefit.class).where(new StringClientParam("patient").matches().value(patientId)).execute();
		for(BundleEntry entry : bundle.getEntries()) {
			if(entry != null && !entry.getResource().isEmpty()) {
				eob.add((ExplanationOfBenefit) entry.getResource());
			}
		}

		return eob;
	}

}
