package com.safety.safetynet.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MedicalRecordTest {

	@Test
	void testMedicalRecord() {
		List<String> myMedications = new ArrayList<>();
		List<String> myAllergies = new ArrayList<>();
		myMedications.add("Medication1:Measure1");
		myMedications.add("Medication2:Measure2");
		myAllergies.add("Allergie1");
		myAllergies.add("Allergie2");
		List<String> anotherMedications = new ArrayList<>();
		List<String> anotherAllergies = new ArrayList<>();
		anotherMedications.add("Medication3:Measure3");
		anotherMedications.add("Medication4:Measure4");
		anotherAllergies.add("Allergie3");
		anotherAllergies.add("Allergie4");
		List<String> myMedications3 = new ArrayList<>();
		List<String> myAllergies3 = new ArrayList<>();
		myMedications3.add("Medication5:Measure5");
		myMedications3.add("Medication6:Measure6");
		myAllergies3.add("Allergie5");
		myAllergies3.add("Allergie6");
		List<String> myMedicationsUpdate = new ArrayList<>();
		List<String> myAllergiesUpdate = new ArrayList<>();
		myMedicationsUpdate.add("MedicationUpdate1:MeasureUpdate1");
		myMedicationsUpdate.add("MedicationUpdate2:MeasureUpdate2");
		myAllergiesUpdate.add("AllergieUpdate1");
		myAllergiesUpdate.add("AllergieUpdate2");
		MedicalRecord medicalRecord = new MedicalRecord("myFirstName", "myLastName", "myBirthdate", myMedications,
				myAllergies);
		MedicalRecord medicalRecord2 = new MedicalRecord();
		MedicalRecord medicalRecord3 = new MedicalRecord("myFirstName3", "myLastName3", "myBirthdate3", myMedications3,
				myAllergies3);
		MedicalRecord medicalRecordUpdate = new MedicalRecord("myFirstName", "myLastName", "myBirthdateUpdate",
				myMedicationsUpdate, myAllergiesUpdate);
		MedicalRecord medicalRecordPartialMedicalRecord = new MedicalRecord("myFirstName", "myLastName", "myBirthdate",
				myMedications, myAllergies);
		MedicalRecord medicalRecordInfoMedicalRecord = new MedicalRecord("myFirstName", "myLastName", "myBirthdate",
				myMedications, myAllergies);

		medicalRecord2.setFirstName("anotherFirstName");
		medicalRecord2.setLastName("anotherLastName");
		medicalRecord2.setBirthdate("anotherBirthdate");
		medicalRecord2.setMedications(anotherMedications);
		medicalRecord2.setAllergies(anotherAllergies);
		medicalRecord3.update(medicalRecordUpdate);
		MedicalRecord.doPartialMedicalRecord(medicalRecordPartialMedicalRecord);
		MedicalRecord.doPersonInfoMedicalRecord(medicalRecordInfoMedicalRecord);

		assertEquals("myFirstName", medicalRecord.getFirstName());
		assertEquals("myLastName", medicalRecord.getLastName());
		assertEquals("myBirthdate", medicalRecord.getBirthdate());
		assertEquals(("Medication1:Measure1"), medicalRecord.getMedications().get(0));
		assertEquals(("Medication2:Measure2"), medicalRecord.getMedications().get(1));
		assertEquals(("Allergie1"), medicalRecord.getAllergies().get(0));
		assertEquals(("Allergie2"), medicalRecord.getAllergies().get(1));

		assertEquals("anotherFirstName", medicalRecord2.getFirstName());
		assertEquals("anotherLastName", medicalRecord2.getLastName());
		assertEquals("anotherBirthdate", medicalRecord2.getBirthdate());
		assertEquals(("Medication3:Measure3"), medicalRecord2.getMedications().get(0));
		assertEquals(("Medication4:Measure4"), medicalRecord2.getMedications().get(1));
		assertEquals(("Allergie3"), medicalRecord2.getAllergies().get(0));
		assertEquals(("Allergie4"), medicalRecord2.getAllergies().get(1));

		assertEquals("myBirthdateUpdate", medicalRecord3.getBirthdate());
		assertEquals(("MedicationUpdate1:MeasureUpdate1"), medicalRecord3.getMedications().get(0));
		assertEquals(("MedicationUpdate2:MeasureUpdate2"), medicalRecord3.getMedications().get(1));
		assertEquals(("AllergieUpdate1"), medicalRecord3.getAllergies().get(0));
		assertEquals(("AllergieUpdate2"), medicalRecord3.getAllergies().get(1));

	}

}
