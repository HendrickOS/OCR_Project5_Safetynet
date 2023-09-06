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
import com.safety.safetynet.model.Person;
import com.safety.safetynet.repository.PersonRepository;

@SpringBootTest(classes = SafetynetApplication.class)
@ExtendWith(SpringExtension.class)
class PersonServiceTest {

	@Autowired
	PersonService personService;
	@MockBean
	PersonRepository personRepository;

	@Test
	void getPersonsFromAddressesTest() {
		List<String> addresses = new ArrayList<>();
		String address1 = "1509 Culver St";
		addresses.add(address1);

		personService.getPersonsFromAddresses(addresses);

		Mockito.verify(personRepository).getPersonsFromAddresses(addresses);
	}

	@Test
	void getPersonsFromAddressFirePersonTest() {
		String address = "1509 Culver St";

		personService.getPersonsFromAddressFirePerson(address);

		Mockito.verify(personRepository).getPersonsFromAddressFirePerson(address);
	}

	@Test
	void getPersonsFromAddressFirestationPersonTest() {
		String address = "1509 Culver St";

		personService.getPersonsFromAddressFirestationPerson(address);

		Mockito.verify(personRepository).getPersonsFromAddressFirestationPerson(address);
	}

	@Test
	void getPersonsFromAddressChildAlert() {
		String address = "1509 Culver St";

		personService.getPersonsFromAddressChildAlert(address);

		Mockito.verify(personRepository).getPersonsFromAddressChildAlert(address);
	}

	@Test
	void getPersonFromFirstNameAndLastNameTest() {
		String firstName = "John";
		String lastName = "Boyd";

		personService.getPersonFromFirstNameAndLastName(firstName, lastName);

		Mockito.verify(personRepository).getPersonFromFirstNameAndLastName(firstName, lastName);
	}

	@Test
	void updatePersonTest() {
		Person personUpdate = new Person("fistNameUpdate", "lastNameUpdate", "addresseUpdate", "cityUpdate",
				"zipUpdate", "phoneUpdate", "jaboyd@emailUpdate");

		personService.updatePerson(personUpdate);

		Mockito.verify(personRepository).updatePerson(personUpdate);
	}

	@Test
	void savePersonTest() {
		Person personToSave = new Person("fistNameUpdate", "lastNameUpdate", "addresseUpdate", "cityUpdate",
				"zipUpdate", "phoneUpdate", "jaboyd@emailUpdate");

		personService.savePerson(personToSave);

		Mockito.verify(personRepository).addPerson(personToSave);
	}

	@Test
	void deletePersonTest() {
		Person personToDelete = new Person("fistNameUpdate", "lastNameUpdate", "addresseUpdate", "cityUpdate",
				"zipUpdate", "phoneUpdate", "jaboyd@emailUpdate");

		personService.deletePerson(personToDelete);

		Mockito.verify(personRepository).deletePerson(personToDelete);
	}

	@Test
	void listTest() {
		personService.list();

		Mockito.verify(personRepository).list();
	}
}
