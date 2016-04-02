package org.ccwdata.web.pojo;

import org.hl7.fhir.dstu3.exceptions.FHIRException;
import org.hl7.fhir.dstu3.model.MedicationOrder;

public class MedicationPojo {
	private String ndc;
	
	private String rxcuid;
	private String medName;
	
	public MedicationPojo() {}
	
	public MedicationPojo(MedicationOrder medOrder) throws FHIRException {
		ndc = medOrder.getMedicationCodeableConcept().getCoding().get(0).getCode();
	}

	public String getNdc() {
		return ndc;
	}
	
	public void setNdc(String ndc) {
		this.ndc = ndc;
	}
	
	public String getRxcuid() {
		return rxcuid;
	}
	
	public void setRxcuid(String rxcuid) {
		this.rxcuid = rxcuid;
	}
	
	public String getMedName() {
		return medName;
	}
	
	public void setMedName(String medName) {
		this.medName = medName;
	}
}
