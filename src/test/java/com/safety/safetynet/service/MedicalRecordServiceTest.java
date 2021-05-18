package com.safety.safetynet.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.safety.safetynet.SafetynetApplication;
import com.safety.safetynet.model.MedicalRecord;
import com.safety.safetynet.model.Person;
import com.safety.safetynet.repository.MedicalRecordRepository;

@SpringBootTest(classes = SafetynetApplication.class)
@ExtendWith(SpringExtension.class)
class MedicalRecordServiceTest {

	@Autowired
	MedicalRecordService medicalRecordService;
	@MockBean
	MedicalRecordRepository medicalRecordRepository;

	@Test
	void getMedicationsAndAllergiesFromPersonTest() {
		Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		List<String> medications = new ArrayList<String>();
		medications.add("aznol:350mg");
		medications.add("hydrapermazol:100mg");
		List<String> allergies = new ArrayList<String>();
		allergies.add("nillacilan");
		MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);
		MedicalRecord result = new MedicalRecord();

		Mockito.when(medicalRecordRepository.getMedicationsAndAllergiesFromPerson(person)).thenReturn(medicalRecord);
		result = medicalRecordService.getMedicationsAndAllergiesFromPerson(person);

		assertEquals(medicalRecord.getAllergies(), result.getAllergies());
		assertEquals(medicalRecord.getMedications(), result.getMedications());
		assertEquals(medicalRecord.getFirstName(), result.getFirstName());
	}

	@Test
	void getMedicationsAndAllergiesFromPersonsTest() {
		List<Person> persons = new ArrayList<Person>();
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		persons.add(john);
		List<String> medications = new ArrayList<String>();
		medications.add("aznol:350mg");
		medications.add("hydrapermazol:100mg");
		List<String> allergies = new ArrayList<String>();
		allergies.add("nillacilan");
		MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);
		List<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
		medicalRecords.add(medicalRecord);
		List<MedicalRecord> result = new ArrayList<MedicalRecord>();

		Mockito.when(medicalRecordRepository.getMedicationsAndAllergiesFromPersons(persons)).thenReturn(medicalRecords);
		result = medicalRecordService.getMedicationsAndAllergiesFromPersons(persons);

		assertEquals(medicalRecords.size(), result.size());
		assertEquals(medicalRecords.get(0).getAllergies(), result.get(0).getAllergies());
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
		MedicalRecord result = new MedicalRecord();

		Mockito.when(medicalRecordRepository.getOnlyMedicationsAndAllergiesFromPerson(firstName, lastName))
				.thenReturn(medicalRecord);
		result = medicalRecordService.getOnlyMedicationsAndAllergiesFromPerson(firstName, lastName);

		assertEquals(medicalRecord.getAllergies(), result.getAllergies());
		assertEquals(medicalRecord.getMedications(), result.getMedications());
	}

}
