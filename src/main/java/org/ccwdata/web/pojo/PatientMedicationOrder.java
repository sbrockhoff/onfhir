//package org.ccwdata.web.pojo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hl7.fhir.dstu3.model.MedicationOrder;
//import org.hl7.fhir.dstu3.model.Patient;
//
//
//public class PatientMedicationOrder {
//
//	private Patient patient;
//
//	private List<MedicationOrder> medicationOrderList;
//
//	private List<DosageInstruction> dosageInstructionList;
//
//	public Patient getPatient() {
//		return patient;
//	}
//
//	public void setPatient(Patient patient) {
//		this.patient = patient;
//	}
//
//	public List<MedicationOrder> getMedicationOrderList() {
//		return medicationOrderList;
//	}
//
//	public void setMedicationOrderList(List<MedicationOrder> medicationOrderList) {
//		this.medicationOrderList = medicationOrderList;
//	}
//
//	public List<DosageInstruction> getDosageInstructionList() {
//
//		if(medicationOrderList != null && dosageInstructionList == null) {
//			dosageInstructionList = new ArrayList<MedicationOrder.DosageInstruction>();
//
//			for(MedicationOrder medicationOrder : medicationOrderList) {
//				if(medicationOrder != null) {
//					for(DosageInstruction dosageInstruction : medicationOrder.getDosageInstruction()) {
//						if(dosageInstruction != null) {
//							dosageInstructionList.add(dosageInstruction);
//						}
//					}
//				}
//			}
//
//		}
//
//		return dosageInstructionList;
//	}
//
//
//}
