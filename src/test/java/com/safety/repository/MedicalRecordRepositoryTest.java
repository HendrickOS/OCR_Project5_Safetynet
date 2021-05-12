//package com.safety.repository;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//
//import com.safety.safetynet.model.MedicalRecord;
//import com.safety.safetynet.model.Person;
//import com.safety.safetynet.service.MedicalRecordService;
//
//class MedicalRecordRepositoryTest {
//
//	MedicalRecordService medicalRecordService = new MedicalRecordService();
//
//	@Test
//	void getMedicationsAndAllergiesFromPersonTest() {
//		List<String> medications = new ArrayList<String>();
//		medications.add("aznol:350mg");
//		medications.add("hydrapermazol:100mg");
//		List<String> allergies = new ArrayList<String>();
//		allergies.add("nillacilan");
//		MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);
//		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
//				"jaboyd@email.com");
//
//		medicalRecord = MedicalRecord.doPartialMedicalRecord(medicalRecord);
//		MedicalRecord result = medicalRecordService.getMedicationsAndAllergiesFromPerson(john);
//
//		assertEquals(medicalRecord, result);
//
////		assertEquals(("John\", \"Boyd\", \"03/06/1984\", [\"aznol:350mg\", \"hydrapermazol:100mg\"], [\"nillacilan\"]"),
////				result);
//
//	}
//
//	@Test
//	void getOnlyMedicationsAndAllergiesFromPersonTest() {
//		String firstName = "John";
//		String lastName = "Boyd";
//		List<String> medications = new ArrayList<String>();
//		medications.add("aznol:350mg");
//		medications.add("hydrapermazol:100mg");
//		List<String> allergies = new ArrayList<String>();
//		allergies.add("nillacilan");
//		MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);
//		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
//				"jaboyd@email.com");
//
//		medicalRecord = MedicalRecord.doPersonInfoMedicalRecord(medicalRecord);
//		MedicalRecord result = medicalRecordService.getOnlyMedicationsAndAllergiesFromPerson(firstName, lastName);
//
//		assertEquals(medicalRecord, result);
//	}
//
//	@Test
//	void getMedicationsAndAllergiesFromPersons() {
//		List<MedicalRecord> result = new ArrayList<MedicalRecord>();
//		List<String> medications = new ArrayList<String>();
//		medications.add("aznol:350mg");
//		medications.add("hydrapermazol:100mg");
//		List<String> allergies = new ArrayList<String>();
//		allergies.add("nillacilan");
//		MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);
//		List<Person> persons = new ArrayList<Person>();
//		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
//				"jaboyd@email.com");
//		persons.add(john);
//
//		medicalRecord = MedicalRecord.doPartialMedicalRecord(medicalRecord);
//		result = medicalRecordService.getMedicationsAndAllergiesFromPersons(persons);
//
//		assertEquals(medicalRecord, result);
//	}
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
//
//}
