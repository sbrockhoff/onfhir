package org.ccwdata.web.service;

import java.util.List;

import org.ccwdata.web.pojo.PatientPojo;
import org.hl7.fhir.dstu3.model.ExplanationOfBenefit;




public class FhirService2Test {

	public static void main(String[] args) {
		FhirService2 fhirService = new FhirService2();
		
		PatientPojo patient = fhirService.getPatientByPatientId("147462");
//		147462
		List<ExplanationOfBenefit> eobList = fhirService.getEobByPatientId("147462");
		if(!eobList.isEmpty()) {
			System.out.println("size of List " + eobList.size());
			System.out.println("id " + eobList.get(0).getId());
		}else{
			System.out.println("list is empty");
		}
	}
}
