package org.ccwdata.web.bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.ccwdata.web.pojo.PatientPojo;
import org.ccwdata.web.service.FhirService2;

@ManagedBean(name = "patientInfoBean")
public class PatientInfoBean {
	private FhirService2 fhirService = new FhirService2();
	private String patientId = "147462";
	
	private PatientPojo patient;
	
	// Actions
	public void submit(ActionEvent event) {
		FacesMessage message = null;
		if (patientId == null) {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Invalid information");
			return;
		}
		
		patient = fhirService.getPatientByPatientId(patientId);
		System.out.println(patient);
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public PatientPojo getPatient() {
		return patient;
	}

	public void setPatient(PatientPojo patient) {
		this.patient = patient;
	}
}
