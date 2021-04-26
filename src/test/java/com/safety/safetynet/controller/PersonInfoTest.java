package com.safety.safetynet.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.safety.safetynet.model.MedicalRecord;
import com.safety.safetynet.model.Person;

class PersonInfoTest {

	@Test
	void testPersonInfo() {
		PersonInfo personInfo = new PersonInfo();
		Person person = new Person("myFirstName", "myLastName", "myAddress", "myCity", "myZip", "myPhoneNumber",
				"myEmailAddress");
		List<String> myMedications = new ArrayList<String>();
		List<String> myAllergies = new ArrayList<String>();
		myMedications.add("Medication1:Measure1");
		myMedications.add("Medication2:Measure2");
		myAllergies.add("Allergie1");
		myAllergies.add("Allergie2");
		MedicalRecord medicalRecord = new MedicalRecord("myFirstName", "myLastName", "myBirthdate", myMedications,
				myAllergies);

		personInfo.setPerson(person);
		personInfo.setMedicalRecord(medicalRecord);

		assertEquals(person, personInfo.getPerson());
		assertEquals(medicalRecord, personInfo.getMedicalRecord());
	}

}
