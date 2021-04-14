package com.safety.safetynet.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MedicalRecordTest {

	@Test
	void testMedicalRecord() {
		List<String> myMedications = new ArrayList<String>();
		List<String> myAllergies = new ArrayList<String>();
		myMedications.add("Medication1:Measure1");
		myMedications.add("Medication2:Measure2");
		myAllergies.add("Allergie1");
		myAllergies.add("Allergie2");
		List<String> anotherMedications = new ArrayList<String>();
		List<String> anotherAllergies = new ArrayList<String>();
		anotherMedications.add("Medication3:Measure3");
		anotherMedications.add("Medication4:Measure4");
		anotherAllergies.add("Allergie3");
		anotherAllergies.add("Allergie4");
		MedicalRecord medicalRecord = new MedicalRecord("myFirstName", "myLastName", "myBirthdate", myMedications,
				myAllergies);
		MedicalRecord medicalRecord2 = new MedicalRecord();

		medicalRecord2.setFirstName("anotherFirstName");
		medicalRecord2.setLastName("anotherLastName");
		medicalRecord2.setBirthdate("anotherBirthdate");
		medicalRecord2.setMedications(anotherMedications);
		medicalRecord2.setAllergies(anotherAllergies);

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

	}

}
