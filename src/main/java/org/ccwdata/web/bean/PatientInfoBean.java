package org.ccwdata.web.bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.ccwdata.web.service.FhirService2;

@ManagedBean(name = "patientInfoBean")
public class PatientInfoBean {
	private FhirService2 fhirService = new FhirService2();
	private String patientId;
	
	// Actions
	public void submit(ActionEvent event) {
		FacesMessage message = null;
		if (patientId == null) {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Invalid information");
		}

		
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
}
