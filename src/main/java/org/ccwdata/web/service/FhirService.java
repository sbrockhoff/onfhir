package org.ccwdata.web.service;

import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.List;

import org.ccwdata.web.bean.PatientBean;
import org.ccwdata.web.pojo.PatientMedicationOrder;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.BundleEntry;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.MedicationDispense;
import ca.uhn.fhir.model.dstu2.resource.MedicationOrder;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.valueset.AddressUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.dstu2.valueset.IdentifierUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.NameUseEnum;
import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.rest.gclient.StringClientParam;

public class FhirService {
	// private final String serverBase = "http://fhirtest.uhn.ca/baseDstu2";
	// private final String serverBase = "http://wildfhir.aegis.net/fhir";
	private final String serverBase = "http://spark.furore.com/fhir";
	// private final String serverBase =
	// "http://fhir2.healthintersections.com.au/open";

	public IGenericClient connectionSetup(String serverBase) {
		// We're connecting to a DSTU1 compliant server in this example
		FhirContext ctx = FhirContext.forDstu2();
		// String serverBase = "http://fhirtest.uhn.ca/baseDstu2";
		// String serverBase = "http://wildfhir.aegis.net/fhir";

		IGenericClient client = ctx.newRestfulGenericClient(serverBase);
		return client;
	}

	public Patient searchByFamilyName(String familyName) {

		Patient patient = null;

		IGenericClient client = connectionSetup(this.serverBase);

		// Perform a search
		Bundle results = client.search().forResource(Patient.class).where(Patient.FAMILY.matches().value(familyName))
				.returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class).execute();

		for (Entry entry : results.getEntry()) {
			patient = (Patient) entry.getResource();
		}

		return patient;
	}

	

	public List<MedicationOrder> searchMedicationOrderByPatientId(String patientId) {
		IGenericClient client = connectionSetup(this.serverBase);

		// Perform a search
		Bundle results = client.search().forResource(MedicationOrder.class)
				.where(MedicationOrder.PATIENT.hasId(patientId))
				.returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class).execute();

		List<MedicationOrder> medOrderList = new ArrayList<MedicationOrder>();
		for (Entry entry : results.getEntry()) {
			MedicationOrder medOrder = (MedicationOrder) entry.getResource();
			medOrderList.add(medOrder);
		}

		return medOrderList;
	}

	public List<PatientMedicationOrder> getPatientMedicationOrderList() {
		IGenericClient client = connectionSetup(this.serverBase);

		Bundle results = client.search().forResource(Patient.class)
				.returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class).execute();
		List<PatientMedicationOrder> patientMedOrderList = new ArrayList<PatientMedicationOrder>();
		for (Entry entry : results.getEntry()) {
			Patient patient = (Patient) entry.getResource();
			if (patient != null) {

				PatientMedicationOrder patMedOrder = new PatientMedicationOrder();
				patMedOrder.setPatient(patient);
				patMedOrder.setMedicationOrderList(searchMedicationOrderByPatientId(patient.getId().getIdPart()));
				patientMedOrderList.add(patMedOrder);
			}
		}

		return patientMedOrderList;
	}

	public List<MedicationDispense> searchMedicationDispenseByPatientId(String patientId) {
		IGenericClient client = connectionSetup(this.serverBase);

		// Perform a search
		Bundle results = client.search().forResource(MedicationDispense.class)
				.where(MedicationOrder.PATIENT.hasId(patientId))
				.returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class).execute();

		List<MedicationDispense> medDispenseList = new ArrayList<MedicationDispense>();
		for (Entry entry : results.getEntry()) {
			MedicationDispense medDispense = (MedicationDispense) entry.getResource();
			medDispenseList.add(medDispense);
		}

		return medDispenseList;
	}

	public void loadPatientInfo(PatientBean bean, Patient patient) {

		boolean preferedPresent = false, givennamePresent = false, familynamePresent = false, doCheckName = true;

		if (patient.getId() != null) {
			bean.setPatientId(patient.getId().getIdPart());
		}

		List<IdentifierDt> fhirIdList = patient.getIdentifier();

		for (IdentifierDt fhirIentifier : fhirIdList) {

			bean.setIdentifierTypeName(fhirIentifier.getValue());
			bean.setIdentifierTypeName2(fhirIentifier.getSystem());
			if (String.valueOf(IdentifierUseEnum.USUAL).equalsIgnoreCase(fhirIentifier.getUse())) {
				bean.setIdentifierPreferred("TRUE");
			} else {
				bean.setIdentifierPreferred("FALSE");
			}

			for (HumanNameDt humanNameDt : patient.getName()) {

				if (humanNameDt.getUse() != null) {
					String getUse = humanNameDt.getUse();
					if (String.valueOf(NameUseEnum.OFFICIAL).equalsIgnoreCase(getUse)
							|| String.valueOf(NameUseEnum.USUAL).equalsIgnoreCase(getUse)) {
						bean.setHumanNamePreferred("TRUE");
					}
					if (String.valueOf(NameUseEnum.OLD).equalsIgnoreCase(getUse)) {
						bean.setHumanNamePreferred("FALSE");
					}
				}
				if (humanNameDt.getSuffix() != null) {
					List<StringDt> prefixes = humanNameDt.getSuffix();
					if (prefixes.size() > 0) {
						StringDt prefix = prefixes.get(0);
						bean.setPersonNamePrefix(valueOf(prefix));
					}
				}
				if (humanNameDt.getSuffix() != null) {
					List<StringDt> suffixes = humanNameDt.getSuffix();
					if (suffixes.size() > 0) {
						StringDt suffix = suffixes.get(0);
						bean.setPersonNameFamilyNameSuffix(valueOf(suffix));
					}
				}

				List<StringDt> givenNames = humanNameDt.getGiven();
				if (givenNames != null) {
					givennamePresent = true;
					StringDt givenName = givenNames.get(0);
					bean.setPersonNameGivenName(valueOf(givenName));
				}
				List<StringDt> familyNames = humanNameDt.getFamily();
				if (familyNames != null) {
					familynamePresent = true;
					StringDt familyName = familyNames.get(0);
					bean.setPersonNameFamilyName(valueOf(familyName));
				}

				if (preferedPresent && givennamePresent && familynamePresent) { // if
																				// all
																				// are
																				// present
																				// in
																				// one
																				// name,
																				// further
																				// checkings
																				// are
																				// not
																				// needed
					doCheckName = false; // cancel future checkings
				}
				if (doCheckName) { // if no suitable names found, these
									// variables should be reset
					preferedPresent = false;
					givennamePresent = false;
					familynamePresent = false;
				}
			}

			for (AddressDt fhirAddress : patient.getAddress()) {

				bean.setAddressCityVillage(fhirAddress.getCity());
				bean.setAddressCountry(fhirAddress.getCountry());
				bean.setAddressStateProvince(fhirAddress.getState());
				bean.setAddressPostalCode(fhirAddress.getPostalCode());
				List<StringDt> addressStrings = fhirAddress.getLine();

				if (addressStrings != null) {
					for (int i = 0; i < addressStrings.size(); i++) {
						if (i == 0) {
							bean.setAddressAddress1(valueOf(addressStrings.get(0)));
						} else if (i == 1) {
							bean.setAddressAddress2(valueOf(addressStrings.get(1)));
						} else if (i == 2) {
							bean.setAddressAddress3(valueOf(addressStrings.get(2)));
						} else if (i == 3) {
							bean.setAddressAddress4(valueOf(addressStrings.get(3)));
						} else if (i == 4) {
							bean.setAddressAddress5(valueOf(addressStrings.get(4)));
						}
					}
				}

				if (String.valueOf(AddressUseEnum.HOME).equalsIgnoreCase(fhirAddress.getUse())) {
					bean.setAddressPreferred("TRUE");
				}
				if (String.valueOf(AddressUseEnum.OLD___INCORRECT).equalsIgnoreCase(fhirAddress.getUse())) {
					bean.setAddressPreferred("FALSE");
				}

			}

			if (patient.getGender() != null && !patient.getGender().isEmpty()) {
				if (patient.getGender().equalsIgnoreCase(String.valueOf(AdministrativeGenderEnum.MALE))) {
					bean.setGender("MALE");
				} else if (patient.getGender().equalsIgnoreCase(String.valueOf(AdministrativeGenderEnum.FEMALE))) {
					bean.setGender("FEMALE");
				}
			} else {
				System.out.println("Gender cannot be empty");
			}
			bean.setBirthdate(patient.getBirthDate().toString());

			BooleanDt Isdeceased = (BooleanDt) patient.getDeceased();
			if (Isdeceased.getValue()) {
				bean.setDead("TRUE");
			} else {
				bean.setDead("FALSE");
			}

			if (patient.getActive()) {
				bean.setPersonVoided("FALSE");
			} else {
				bean.setPersonVoided("TRUE");
				bean.setPersonVoidReason("Deleted from FHIR module"); // deleted
																		// reason
																		// is
																		// compulsory
			}

		}
	}

	// System.out.printlns out all patient data.
	public void outputPatientInfo(Patient patient) {

		boolean preferedPresent = false, givennamePresent = false, familynamePresent = false, doCheckName = true;

		System.out.println("---------------------------------------------------------------");

		if (patient.getId() != null) {
			System.out.println("Patient Id: " + patient.getId().getIdPart());
		}

		List<IdentifierDt> fhirIdList = patient.getIdentifier();

		for (IdentifierDt fhirIentifier : fhirIdList) {

			System.out.println("Identifer: " + fhirIentifier.getValue());
			System.out.println("IdentifierTypeName: " + fhirIentifier.getSystem());
			if (String.valueOf(IdentifierUseEnum.USUAL).equalsIgnoreCase(fhirIentifier.getUse())) {
				System.out.println("Identifier Preferred: TRUE");
			} else {
				System.out.println("Identifier Preferred: FALSE");
			}

			for (HumanNameDt humanNameDt : patient.getName()) {

				if (humanNameDt.getUse() != null) {
					String getUse = humanNameDt.getUse();
					if (String.valueOf(NameUseEnum.OFFICIAL).equalsIgnoreCase(getUse)
							|| String.valueOf(NameUseEnum.USUAL).equalsIgnoreCase(getUse)) {
						System.out.println("Human Name Preferred: TRUE");
					}
					if (String.valueOf(NameUseEnum.OLD).equalsIgnoreCase(getUse)) {
						System.out.println("Human Name Preferred: FALSE");
					}
				}
				if (humanNameDt.getSuffix() != null) {
					List<StringDt> prefixes = humanNameDt.getSuffix();
					if (prefixes.size() > 0) {
						StringDt prefix = prefixes.get(0);
						System.out.println("PersonName Prefix: " + valueOf(prefix));
					}
				}
				if (humanNameDt.getSuffix() != null) {
					List<StringDt> suffixes = humanNameDt.getSuffix();
					if (suffixes.size() > 0) {
						StringDt suffix = suffixes.get(0);
						System.out.println("PersonName FamilyNameSuffix: " + valueOf(suffix));
					}
				}

				List<StringDt> givenNames = humanNameDt.getGiven();
				if (givenNames != null) {
					givennamePresent = true;
					StringDt givenName = givenNames.get(0);
					System.out.println("PersonName GivenName: " + valueOf(givenName));
				}
				List<StringDt> familyNames = humanNameDt.getFamily();
				if (familyNames != null) {
					familynamePresent = true;
					StringDt familyName = familyNames.get(0);
					System.out.println("PersonName FamilyName: " + valueOf(familyName));
				}

				if (preferedPresent && givennamePresent && familynamePresent) { // if
																				// all
																				// are
																				// present
																				// in
																				// one
																				// name,
																				// further
																				// checkings
																				// are
																				// not
																				// needed
					doCheckName = false; // cancel future checkings
				}
				if (doCheckName) { // if no suitable names found, these
									// variables should be reset
					preferedPresent = false;
					givennamePresent = false;
					familynamePresent = false;
				}
			}

			for (AddressDt fhirAddress : patient.getAddress()) {

				System.out.println("Address CityVillage: " + fhirAddress.getCity());
				System.out.println("Address Country: " + fhirAddress.getCountry());
				System.out.println("Address StateProvince: " + fhirAddress.getState());
				System.out.println("Address PostalCode: " + fhirAddress.getPostalCode());
				List<StringDt> addressStrings = fhirAddress.getLine();

				if (addressStrings != null) {
					for (int i = 0; i < addressStrings.size(); i++) {
						if (i == 0) {
							System.out.println("Address Address1: " + valueOf(addressStrings.get(0)));
						} else if (i == 1) {
							System.out.println("Address Address2: " + valueOf(addressStrings.get(1)));
						} else if (i == 2) {
							System.out.println("Address Address3: " + valueOf(addressStrings.get(2)));
						} else if (i == 3) {
							System.out.println("Address Address4: " + valueOf(addressStrings.get(3)));
						} else if (i == 4) {
							System.out.println("Address Address5: " + valueOf(addressStrings.get(4)));
						}
					}
				}

				if (String.valueOf(AddressUseEnum.HOME).equalsIgnoreCase(fhirAddress.getUse())) {
					System.out.println("Address Preferred: TRUE");
				}
				if (String.valueOf(AddressUseEnum.OLD___INCORRECT).equalsIgnoreCase(fhirAddress.getUse())) {
					System.out.println("Address Preferred: FALSE");
				}

			}

			if (patient.getGender() != null && !patient.getGender().isEmpty()) {
				if (patient.getGender().equalsIgnoreCase(String.valueOf(AdministrativeGenderEnum.MALE))) {
					System.out.println("Gender: MALE");
				} else if (patient.getGender().equalsIgnoreCase(String.valueOf(AdministrativeGenderEnum.FEMALE))) {
					System.out.println("Gender: FEMALE");
				}
			} else {
				System.out.println("Gender cannot be empty");
			}
			System.out.println("Birthdate: " + patient.getBirthDate());

			BooleanDt Isdeceased = (BooleanDt) patient.getDeceased();
			System.out.println("Dead: " + Isdeceased.getValue());

			if (patient.getActive()) {
				System.out.println("PersonVoided: FALSE");
			} else {
				System.out.println("PersonVoided: TRUE");
				System.out.println("PersonVoidReason: Deleted from FHIR module"); // deleted
																					// reason
																					// is
																					// compulsory
			}

		}
	}

}
