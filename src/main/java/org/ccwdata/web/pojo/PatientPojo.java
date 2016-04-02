package org.ccwdata.web.pojo;

import java.util.Date;

import org.hl7.fhir.dstu21.model.Patient;


public class PatientPojo {

	private String userId;

	private String fullName;

	private String firstName;

	private String lastName;

	private Date birthDate;

	private String patientContact;

	/**
	 * Default Constructor
	 */
	public PatientPojo() {

	}

	/**
	 * Alternate constructor which makes a PatientPojo from a Patient object.
	 * 
	 * @param patient
	 */
	public PatientPojo(Patient patient) {
		this.userId = patient.getId();
		this.fullName = patient.getName().get(0).getNameAsSingleString();
		this.firstName = patient.getName().get(0).getGivenAsSingleString();
		this.lastName = patient.getName().get(0).getFamilyAsSingleString();
		this.birthDate = patient.getBirthDate();
		this.patientContact = patient.getContact().get(0).getName().getNameAsSingleString();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPatientContact() {
		return patientContact;
	}

	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}

}
