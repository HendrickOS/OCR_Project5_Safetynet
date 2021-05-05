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
//	MedicalRecordService medicalRecordService;
//
//	@Test
//	void getPersonAgeTest() {
//		Person person = new Person("myFirstName", "myLastName", "myAddress", "myCity", "myZip", "myPhoneNumber",
//				"myEmailAddress");
//		Person p = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
//		List<String> myMedications = new ArrayList<String>();
//		List<String> myAllergies = new ArrayList<String>();
//		myMedications.add("Medication1:Measure1");
//		myMedications.add("Medication2:Measure2");
//		myAllergies.add("Allergie1");
//		myAllergies.add("Allergie2");
//		MedicalRecord medicalRecord = new MedicalRecord("myFirstName", "myLastName", "03/06/1984", myMedications,
//				myAllergies);
//		int age;
//
//		age = medicalRecordService.getPersonAge(p);
//
//		assertEquals(37, age);
//	}
//}
