package com.safety.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.safety.safetynet.SafetynetApplication;
import com.safety.safetynet.model.MedicalRecord;
import com.safety.safetynet.model.Person;
import com.safety.safetynet.repository.MedicalRecordRepository;

@SpringBootTest(classes = SafetynetApplication.class)
@ExtendWith(SpringExtension.class)
class MedicalRecordRepositoryTest {

	@Autowired
	MedicalRecordRepository medicalRecordRepository;

	@Test
	void getMedicationsAndAllergiesFromPersonTest() {
		List<String> medications = new ArrayList<String>();
		medications.add("aznol:350mg");
		medications.add("hydrapermazol:100mg");
		List<String> allergies = new ArrayList<String>();
		allergies.add("nillacilan");
		MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");

		medicalRecord = MedicalRecord.doPartialMedicalRecord(medicalRecord);
		MedicalRecord result = medicalRecordRepository.getMedicationsAndAllergiesFromPerson(john);

		assertEquals(medicalRecord.getAllergies(), result.getAllergies());
		assertEquals(medicalRecord.getMedications(), result.getMedications());
		assertEquals(medicalRecord.getFirstName(), result.getFirstName());
	}

	@Test
	void getOnlyMedicationsAndAllergiesFromPersonTest() {
		String firstName = "John";
		String lastName = "Boyd";
		List<String> medications = new ArrayList<String>();
		medications.add("aznol:350mg");
		medications.add("hydrapermazol:100mg");
		List<String> allergies = new ArrayList<String>();
		allergies.add("nillacilan");
		MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");

		medicalRecord = MedicalRecord.doPersonInfoMedicalRecord(medicalRecord);
		MedicalRecord result = medicalRecordRepository.getOnlyMedicationsAndAllergiesFromPerson(firstName, lastName);

		assertEquals(medicalRecord.getAllergies(), result.getAllergies());
		assertEquals(medicalRecord.getMedications(), result.getMedications());
	}

	@Test
	void getMedicationsAndAllergiesFromPersons() {
		List<MedicalRecord> result = new ArrayList<MedicalRecord>();
		List<String> medications = new ArrayList<String>();
		medications.add("aznol:350mg");
		medications.add("hydrapermazol:100mg");
		List<String> allergies = new ArrayList<String>();
		allergies.add("nillacilan");
		MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);
		List<Person> persons = new ArrayList<Person>();
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		persons.add(john);

		medicalRecord = MedicalRecord.doPartialMedicalRecord(medicalRecord);
		result = medicalRecordRepository.getMedicationsAndAllergiesFromPersons(persons);

		assertEquals(medicalRecord.getAllergies(), result.get(0).getAllergies());
		assertEquals(medicalRecord.getMedications(), result.get(0).getMedications());
	}
//
//	@Test
//	void updateMedicalRecordTest() {
//		MedicalRecord result = new MedicalRecord();
//		List<String> medications = new ArrayList<String>();
//		medications.add("aznol:350mg");
//		medications.add("hydrapermazol:100mg");
//		List<String> allergies = new ArrayList<String>();
//		allergies.add("nillacilan");
//		MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);
//
////		 result = medicalRecordService.updateMedicalRecord(medicalRecord);
//		result.update(medicalRecord);
//
//		assertEquals(medicalRecord, result);
//	}
//
////	@Test
////	void getPersonAgeTest() {
////		int age;
////		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
////				"jaboyd@email.com");
////		List<String> medications = new ArrayList<String>();
////		medications.add("aznol:350mg");
////		medications.add("hydrapermazol:100mg");
////		List<String> allergies = new ArrayList<String>();
////		allergies.add("nillacilan");
////		MedicalRecord mr = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);
////
////		Mockito.when(medicalRecordService.getPersonAge(john)).thenReturn(37);
//////		age = medicalRecordService.getPersonAge(john);
////
////		assertEquals(37, age);
////	}

}
