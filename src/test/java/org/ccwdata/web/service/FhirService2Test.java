package org.ccwdata.web.service;

import java.util.List;

import org.ccwdata.web.pojo.EobPojo;
import org.ccwdata.web.pojo.MedicationPojo;
import org.ccwdata.web.pojo.PatientPojo;
import org.hl7.fhir.dstu3.exceptions.FHIRException;
import org.hl7.fhir.dstu3.model.ExplanationOfBenefit;




public class FhirService2Test {

	public static void main(String[] args) throws FHIRException {
		FhirService2 fhirService = new FhirService2();
		NihService nihService = new NihService();
		
		PatientPojo patient = fhirService.getPatientByPatientId("147462");
//		147462
		List<EobPojo> eobList = fhirService.getEobByPatientId("147462");
		if(!eobList.isEmpty()) {
			System.out.println("size of List " + eobList.size());
			System.out.println("id " + eobList.get(0).getId());
		}else{
			System.out.println("list is empty");
		}
		
		MedicationPojo med = fhirService.getMedicationOrderById("7078255");
		System.out.println("ndc: " + med.getNdc());
		
		String rxcuid = nihService.getRxcuidByNdc(med.getNdc());
		System.out.println("rxcuid: " + rxcuid);
		
		String name = nihService.getRxNameByRxcuid(rxcuid);
		System.out.println("name: " + name);
	}
}
