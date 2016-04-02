package org.ccwdata.web.bean;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.ccwdata.web.pojo.EobPojo;
import org.ccwdata.web.pojo.MedicationPojo;
import org.ccwdata.web.pojo.PatientPojo;
import org.ccwdata.web.service.FhirService2;
import org.ccwdata.web.service.NihService;
import org.hl7.fhir.dstu3.exceptions.FHIRException;

@ManagedBean(name = "patientInfoBean")
public class PatientInfoBean {
	private FhirService2 fhirService = new FhirService2();
	private NihService nihService = new NihService();
	private String patientId = "147462";
	
	private PatientPojo patient;
	List<MedicationPojo> medicationList;
	
	// Actions
	public void submit(ActionEvent event) throws FHIRException {
		FacesMessage message = null;
		if (patientId == null) {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Invalid information");
			return;
		}
		
		patient = fhirService.getPatientByPatientId(patientId);
		List<EobPojo> eobList = fhirService.getEobByPatientId(patientId);
		
		medicationList = new ArrayList<>();
		for(EobPojo eob : eobList) {
			MedicationPojo mp = fhirService.getMedicationOrderById(eob.getMedicationOrderId());
			
			String rxcuid = nihService.getRxcuidByNdc(mp.getNdc());
			String name = nihService.getRxNameByRxcuid(rxcuid);
			mp.setRxcuid(rxcuid);
			mp.setMedName(name);
			mp.setTotalCost(eob.getTotalPrescripition());
			
			medicationList.add(mp);
		}
		
		
		System.out.println("end");
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

	
	public List<MedicationPojo> getMedicationList() {
		return medicationList;
	}

	
	public void setMedicationList(List<MedicationPojo> medicationList) {
		this.medicationList = medicationList;
	}
}
