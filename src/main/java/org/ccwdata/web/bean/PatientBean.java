//package org.ccwdata.web.bean;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.context.FacesContext;
//import javax.faces.event.ActionEvent;
//
//import org.apache.commons.lang3.StringUtils;
//import org.ccwdata.pojo.json.FullInteraction;
//import org.ccwdata.pojo.json.Interaction;
//import org.ccwdata.web.pojo.PatientMedicationOrder;
//import org.ccwdata.web.service.FhirService;
//import org.ccwdata.web.service.NihService;
//
//import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
//import ca.uhn.fhir.model.dstu2.resource.MedicationDispense;
//import ca.uhn.fhir.model.dstu2.resource.MedicationOrder;
//import ca.uhn.fhir.model.dstu2.resource.MedicationOrder.DosageInstruction;
//import ca.uhn.fhir.model.dstu2.resource.Patient;
//
//@ManagedBean(name = "patientBean")
//public class PatientBean {
//
//	private String patientId;
//	private String identifierTypeName;
//	private String identifierTypeName2;
//	private String identifierPreferred;
//	private String humanNamePreferred;
//	private String personNamePrefix;
//	private String personNameFamilyNameSuffix;
//	private String personNameGivenName = "Roelof Olaf";
//	private String personNameFamilyName = "Bor";
//	private String addressCityVillage;
//	private String addressCountry;
//	private String addressStateProvince;
//	private String addressPostalCode;
//	private String addressAddress1;
//	private String addressAddress2;
//	private String addressAddress3;
//	private String addressAddress4;
//	private String addressAddress5;
//	private String addressPreferred;
//	private String gender;
//	private String birthdate;
//	private String dead;
//	private String personVoided;
//	private String personVoidReason;
//
//	private Patient patient;
//	private List<DosageInstruction> dosageInstructionList;
//	private List<MedicationOrder> medOrderList;
//	private List<MedicationDispense> medDispenseList;
//	private List<PatientMedicationOrder> patientList;
//	private List<Interaction> interactionList;
//	private List<FullInteraction> fullInteractionList;
//
//	// Actions
//	public void submit(ActionEvent event) {
//		FacesMessage message = null;
//		
//		// Clear Bean
//		clear();
//
//		if (personNameFamilyName != null && personNameGivenName != null) {
//			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hello", personNameGivenName);
//		} else {
//			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Invalid information");
//		}
//
//		FhirService fhirService = new FhirService();
//		this.patient = fhirService.searchByFamilyName(personNameFamilyName);
//
//		fhirService.loadPatientInfo(this, patient);
//
//		if (this.patient != null) {
//			this.medOrderList = fhirService.searchMedicationOrderByPatientId(patient.getId().getIdPart());
//
//			this.medDispenseList = fhirService.searchMedicationDispenseByPatientId(patient.getId().getIdPart());
//		}
//
//		// Get interactions
////		for (MedicationOrder medOrder : medOrderList) {
////			ResourceReferenceDt med = (ResourceReferenceDt) medOrder.getMedication();
////			NihService nihService = new NihService();
////			Interaction interaction = nihService.retrieveInteraction(med.getDisplay().getValueAsString());
////			
////			if (interaction != null) {
////
////				if (this.interactionList == null) {
////					this.interactionList = new ArrayList<Interaction>();
////				}
////
////				this.interactionList.add(interaction);
////			}
////		}
//		
//		//Get interactions
//		Set<String> medStringSet = new HashSet<>();
//		for (MedicationOrder medOrder : medOrderList) {
//			ResourceReferenceDt med = (ResourceReferenceDt) medOrder.getMedication();
//			String medString = med.getDisplay().getValueAsString();
//			String[] medStringArr = medString.split(" ");
//			
//			for(String m : medStringArr) {
//				if(StringUtils.isNotBlank(m)) {
//					medStringSet.add(m);
//					NihService nihService = new NihService();
//					Interaction interaction = nihService.retrieveInteraction(m);
//					
//					if (interaction != null) {
//
//						if (this.interactionList == null) {
//							this.interactionList = new ArrayList<Interaction>();
//						}
//
//						this.interactionList.add(interaction);
//					}
//				}
//			}
//		}
//		
//		//Get interactions for whole list
//		NihService nihService = new NihService();
//		FullInteraction specificInteraction = nihService.retrieveInteractionForList(new ArrayList<String>(medStringSet));
//		fullInteractionList = Arrays.asList(specificInteraction);
//
//		FacesContext.getCurrentInstance().addMessage(null, message);
//	}
//
//	public void submitPatientRequest(ActionEvent event) {
//		FhirService fhirService = new FhirService();
//		this.patientList = fhirService.getPatientMedicationOrderList();
//	}
//	
//	private void clear() {
//		  patientId = null;
//		  identifierTypeName = null;
//		  identifierTypeName2 = null;
//		  identifierPreferred = null;
//		  humanNamePreferred = null;
//		  personNamePrefix = null;
//		  personNameFamilyNameSuffix = null;
//		  addressCityVillage = null;
//		  addressCountry = null;
//		  addressStateProvince = null;
//		  addressPostalCode = null;
//		  addressAddress1 = null;
//		  addressAddress2 = null;
//		  addressAddress3 = null;
//		  addressAddress4 = null;
//		  addressAddress5 = null;
//		  addressPreferred = null;
//		  gender = null;
//		  birthdate = null;
//		  dead = null;
//		  personVoided = null;
//		  personVoidReason = null;
//
//		 patient = null;
//		 dosageInstructionList = null;
//		 medOrderList = null;
//		 medDispenseList = null;
//		 patientList = null;
//		 interactionList = null;
//	}
//
//	// Getters and Setters
//	public Patient getPatient() {
//		return patient;
//	}
//
//	public void setPatient(Patient patient) {
//		this.patient = patient;
//	}
//
//	public List<DosageInstruction> getDosageInstructionList() {
//		return dosageInstructionList;
//	}
//
//	public void setDosageInstructionList(List<DosageInstruction> dosageInstructionList) {
//		this.dosageInstructionList = dosageInstructionList;
//	}
//
//	public List<MedicationOrder> getMedOrderList() {
//		return medOrderList;
//	}
//
//	public void setMedOrderList(List<MedicationOrder> medOrderList) {
//		this.medOrderList = medOrderList;
//	}
//
//	public List<MedicationDispense> getMedDispenseList() {
//		return medDispenseList;
//	}
//
//	public void setMedDispenseList(List<MedicationDispense> medDispenseList) {
//		this.medDispenseList = medDispenseList;
//	}
//
//	public List<PatientMedicationOrder> getPatientList() {
//		return patientList;
//	}
//
//	public void setPatientList(List<PatientMedicationOrder> patientList) {
//		this.patientList = patientList;
//	}
//
//	public String getPatientId() {
//		return patientId;
//	}
//
//	public void setPatientId(String patientId) {
//		this.patientId = patientId;
//	}
//
//	public String getIdentifierTypeName() {
//		return identifierTypeName;
//	}
//
//	public void setIdentifierTypeName(String identifierTypeName) {
//		this.identifierTypeName = identifierTypeName;
//	}
//
//	public String getIdentifierTypeName2() {
//		return identifierTypeName2;
//	}
//
//	public void setIdentifierTypeName2(String identifierTypeName2) {
//		this.identifierTypeName2 = identifierTypeName2;
//	}
//
//	public String getIdentifierPreferred() {
//		return identifierPreferred;
//	}
//
//	public void setIdentifierPreferred(String identifierPreferred) {
//		this.identifierPreferred = identifierPreferred;
//	}
//
//	public String getHumanNamePreferred() {
//		return humanNamePreferred;
//	}
//
//	public void setHumanNamePreferred(String humanNamePreferred) {
//		this.humanNamePreferred = humanNamePreferred;
//	}
//
//	public String getPersonNamePrefix() {
//		return personNamePrefix;
//	}
//
//	public void setPersonNamePrefix(String personNamePrefix) {
//		this.personNamePrefix = personNamePrefix;
//	}
//
//	public String getPersonNameFamilyNameSuffix() {
//		return personNameFamilyNameSuffix;
//	}
//
//	public void setPersonNameFamilyNameSuffix(String personNameFamilyNameSuffix) {
//		this.personNameFamilyNameSuffix = personNameFamilyNameSuffix;
//	}
//
//	public String getPersonNameGivenName() {
//		return personNameGivenName;
//	}
//
//	public void setPersonNameGivenName(String personNameGivenName) {
//		this.personNameGivenName = personNameGivenName;
//	}
//
//	public String getPersonNameFamilyName() {
//		return personNameFamilyName;
//	}
//
//	public void setPersonNameFamilyName(String personNameFamilyName) {
//		this.personNameFamilyName = personNameFamilyName;
//	}
//
//	public String getAddressCityVillage() {
//		return addressCityVillage;
//	}
//
//	public void setAddressCityVillage(String addressCityVillage) {
//		this.addressCityVillage = addressCityVillage;
//	}
//
//	public String getAddressCountry() {
//		return addressCountry;
//	}
//
//	public void setAddressCountry(String addressCountry) {
//		this.addressCountry = addressCountry;
//	}
//
//	public String getAddressStateProvince() {
//		return addressStateProvince;
//	}
//
//	public void setAddressStateProvince(String addressStateProvince) {
//		this.addressStateProvince = addressStateProvince;
//	}
//
//	public String getAddressPostalCode() {
//		return addressPostalCode;
//	}
//
//	public void setAddressPostalCode(String addressPostalCode) {
//		this.addressPostalCode = addressPostalCode;
//	}
//
//	public String getAddressAddress1() {
//		return addressAddress1;
//	}
//
//	public void setAddressAddress1(String addressAddress1) {
//		this.addressAddress1 = addressAddress1;
//	}
//
//	public String getAddressAddress2() {
//		return addressAddress2;
//	}
//
//	public void setAddressAddress2(String addressAddress2) {
//		this.addressAddress2 = addressAddress2;
//	}
//
//	public String getAddressAddress3() {
//		return addressAddress3;
//	}
//
//	public void setAddressAddress3(String addressAddress3) {
//		this.addressAddress3 = addressAddress3;
//	}
//
//	public String getAddressAddress4() {
//		return addressAddress4;
//	}
//
//	public void setAddressAddress4(String addressAddress4) {
//		this.addressAddress4 = addressAddress4;
//	}
//
//	public String getAddressAddress5() {
//		return addressAddress5;
//	}
//
//	public void setAddressAddress5(String addressAddress5) {
//		this.addressAddress5 = addressAddress5;
//	}
//
//	public String getAddressPreferred() {
//		return addressPreferred;
//	}
//
//	public void setAddressPreferred(String addressPreferred) {
//		this.addressPreferred = addressPreferred;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public String getBirthdate() {
//		return birthdate;
//	}
//
//	public void setBirthdate(String birthdate) {
//		this.birthdate = birthdate;
//	}
//
//	public String getDead() {
//		return dead;
//	}
//
//	public void setDead(String dead) {
//		this.dead = dead;
//	}
//
//	public String getPersonVoided() {
//		return personVoided;
//	}
//
//	public void setPersonVoided(String personVoided) {
//		this.personVoided = personVoided;
//	}
//
//	public String getPersonVoidReason() {
//		return personVoidReason;
//	}
//
//	public void setPersonVoidReason(String personVoidReason) {
//		this.personVoidReason = personVoidReason;
//	}
//
//	public List<Interaction> getInteractionList() {
//		return interactionList;
//	}
//
//	public void setInteractionList(List<Interaction> interactionList) {
//		this.interactionList = interactionList;
//	}
//
//	public List<FullInteraction> getFullInteractionList() {
//		return fullInteractionList;
//	}
//
//	public void setFullInteractionList(List<FullInteraction> fullInteractionList) {
//		this.fullInteractionList = fullInteractionList;
//	}
//}
