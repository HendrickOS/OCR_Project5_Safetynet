package com.safety.safetynet.service;

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

		medicalRecordService.getMedicationsAndAllergiesFromPerson(person);

		Mockito.verify(medicalRecordRepository).getMedicationsAndAllergiesFromPerson(person);
	}

	@Test
	void getMedicationsAndAllergiesFromPersonsTest() {
		List<Person> persons = new ArrayList<>();
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		persons.add(john);

		medicalRecordService.getMedicationsAndAllergiesFromPersons(persons);

		Mockito.verify(medicalRecordRepository).getMedicationsAndAllergiesFromPersons(persons);
	}

	@Test
	void getOnlyMedicationsAndAllergiesFromPersonTest() {
		String firstName = "John";
		String lastName = "Boyd";

		medicalRecordService.getOnlyMedicationsAndAllergiesFromPerson(firstName, lastName);

		Mockito.verify(medicalRecordRepository).getOnlyMedicationsAndAllergiesFromPerson(firstName, lastName);
	}

	@Test
	void getPersonAgeTest() {
		Person person = new Person("fistNameUpdate", "lastNameUpdate", "addresseUpdate", "cityUpdate", "zipUpdate",
				"phoneUpdate", "jaboyd@emailUpdate");

		medicalRecordService.getPersonAge(person);

		Mockito.verify(medicalRecordRepository).getPersonAge(person);
	}

	@Test
	void listTest() {
		medicalRecordService.list();

		Mockito.verify(medicalRecordRepository).list();
	}

	@Test
	void updateMedicalRecordTest() {
		List<String> medications = new ArrayList<>();
		medications.add("aznol:350mg");
		medications.add("hydrapermazol:100mg");
		List<String> allergies = new ArrayList<>();
		allergies.add("nillacilan");
		MedicalRecord medicalRecordUpdate = new MedicalRecord("fistNameUpdate", "lastNameUpdate", "birthdate",
				medications, allergies);

		medicalRecordService.updateMedicalRecord(medicalRecordUpdate);

		Mockito.verify(medicalRecordRepository).updateMedicalRecord(medicalRecordUpdate);

	}

	@Test
	void addMedicalRecordTest() {
		List<String> medications = new ArrayList<>();
		medications.add("aznol:350mg");
		medications.add("hydrapermazol:100mg");
		List<String> allergies = new ArrayList<>();
		allergies.add("nillacilan");
		MedicalRecord medicalRecordUpdate = new MedicalRecord("fistNameUpdate", "lastNameUpdate", "birthdate",
				medications, allergies);

		medicalRecordService.saveMedicalRecord(medicalRecordUpdate);

		Mockito.verify(medicalRecordRepository).addMedicalRecord(medicalRecordUpdate);

	}

	@Test
	void deleteMedicalRecordTest() {
		List<String> medications = new ArrayList<>();
		medications.add("aznol:350mg");
		medications.add("hydrapermazol:100mg");
		List<String> allergies = new ArrayList<>();
		allergies.add("nillacilan");
		MedicalRecord medicalRecordUpdate = new MedicalRecord("fistNameUpdate", "lastNameUpdate", "birthdate",
				medications, allergies);

		medicalRecordService.deleteMedicalRecord(medicalRecordUpdate);

		Mockito.verify(medicalRecordRepository).deleteMedicalRecord(medicalRecordUpdate);

	}

}
