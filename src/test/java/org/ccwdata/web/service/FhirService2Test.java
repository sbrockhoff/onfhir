package org.ccwdata.web.service;

import java.util.List;

import ca.uhn.fhir.model.dstu2.resource.ExplanationOfBenefit;

public class FhirService2Test {

	public static void main(String[] args) {
		FhirService2 fhirService = new FhirService2();
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
