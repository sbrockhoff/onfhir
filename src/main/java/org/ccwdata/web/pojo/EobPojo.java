package org.ccwdata.web.pojo;

import org.hl7.fhir.dstu3.model.ExplanationOfBenefit;
import org.hl7.fhir.dstu3.model.ExplanationOfBenefit.ItemAdjudicationComponent;
import org.hl7.fhir.dstu3.model.ExplanationOfBenefit.ItemsComponent;

public class EobPojo {

	private String id;
	private String medicationOrderId;
	private String patientPaymentAmount;
	private String totalPrescripitionCost;
	private boolean hasPrescription = false;

	/**
	 * Default Constructor
	 */
	public EobPojo() {}

	public EobPojo(ExplanationOfBenefit eob) {
		this.id = eob.getId().substring(eob.getId().lastIndexOf('/') + 1, eob.getId().length());
		if(eob.getPrescription() != null && eob.getPrescription().getReference() != null) {
			this.hasPrescription = true;
			this.medicationOrderId = eob.getPrescription().getReference().substring(eob.getPrescription().getReference().lastIndexOf('/') + 1, eob.getPrescription().getReference().length());
		}
		for(ItemsComponent item : eob.getItem()) {
			for(ItemAdjudicationComponent adjudication : item.getAdjudication()) {
				if(adjudication.getCategory().getCode().equals("Patient Pay Amount")) {
					this.patientPaymentAmount = adjudication.getAmount().getValue().toString();
				}else if(adjudication.getCategory().getCode().equals("Total Prescription Cost")) {
					this.totalPrescripitionCost = adjudication.getAmount().getValue().toString();
				}
			}

		}
		// this.patientPaymentAmount = eob.getItem().get(index)
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMedicationOrderId() {
		return medicationOrderId;
	}

	public void setMedicationOrderId(String medicationOrderId) {
		this.medicationOrderId = medicationOrderId;
	}

	public String getPatientPaymentAmount() {
		return patientPaymentAmount;
	}

	public void setPatientPaymentAmount(String patientPaymentAmount) {
		this.patientPaymentAmount = patientPaymentAmount;
	}

	public String getTotalPrescripition() {
		return totalPrescripitionCost;
	}

	public void setTotalPrescripition(String totalPrescripition) {
		this.totalPrescripitionCost = totalPrescripition;
	}

	public boolean isHasPrescription() {
		return hasPrescription;
	}

	public void setHasPrescription(boolean hasPrescription) {
		this.hasPrescription = hasPrescription;
	}

}
