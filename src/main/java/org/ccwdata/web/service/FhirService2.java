package org.ccwdata.web.service;

import java.util.ArrayList;
import java.util.List;

import org.ccwdata.web.pojo.MedicationPojo;
import org.ccwdata.web.pojo.PatientPojo;
import org.hl7.fhir.dstu3.model.ExplanationOfBenefit;
import org.hl7.fhir.dstu3.model.MedicationOrder;
import org.hl7.fhir.dstu3.model.Patient;

import ca.uhn.fhir.context.FhirContext;

import org.hl7.fhir.dstu3.exceptions.FHIRException;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;

import ca.uhn.fhir.model.api.BundleEntry;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.rest.gclient.StringClientParam;

public class FhirService2 {

	private final String serverBase = "http://bluebuttonhapi-test.hhsdevcloud.us/baseDstu2";
	private IGenericClient client;

	public FhirService2() {
		FhirContext ctx = FhirContext.forDstu3();

		client = ctx.newRestfulGenericClient(serverBase);
	}

	public PatientPojo getPatientByPatientId(String patientId) {
		Patient patient = null;
		Bundle bundle = client.search().forResource(Patient.class)
				.where(new StringClientParam("_id").matches().value(patientId))
				.returnBundle(Bundle.class)
				.execute();
		for(BundleEntryComponent entry : bundle.getEntry()) {
			if(entry != null && !entry.getResource().isEmpty()) {
				patient = (Patient) entry.getResource();
			}
		}
		PatientPojo ppojo = new PatientPojo(patient);
		return ppojo;
	}

	public List<ExplanationOfBenefit> getEobByPatientId(String patientId) {
		List<ExplanationOfBenefit> eob = new ArrayList<ExplanationOfBenefit>();
		Bundle bundle = client.search().forResource(ExplanationOfBenefit.class)
				.where(new StringClientParam("patient").matches().value(patientId))
				.returnBundle(Bundle.class)
				.execute();
		for(BundleEntryComponent entry : bundle.getEntry()) {
			if(entry != null && !entry.getResource().isEmpty()) {
				eob.add((ExplanationOfBenefit) entry.getResource());
			}
		}

		return eob;
	}
	
	public MedicationPojo getMedicationOrderById(String medicationOrderId) throws FHIRException {
		MedicationOrder medOrder = null;
		Bundle bundle = client.search().forResource(MedicationOrder.class)
				.where(new StringClientParam("_id").matches().value(medicationOrderId))
				.returnBundle(Bundle.class)
				.execute();
		for(BundleEntryComponent entry : bundle.getEntry()) {
			if(entry != null && !entry.getResource().isEmpty()) {
				medOrder = (MedicationOrder) entry.getResource();
			}
		}
		
		MedicationPojo medPojo = new MedicationPojo(medOrder);
		return medPojo;
	}
	

}
