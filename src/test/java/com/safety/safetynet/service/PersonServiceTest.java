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
		List<String> addresses = new ArrayList<String>();
		String address1 = "1509 Culver St";
		addresses.add(address1);
		List<Person> result = new ArrayList<Person>();
		List<Person> persons = new ArrayList<Person>();
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		Person jacob = new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513",
				"drk@email.com");
		Person tenley = new Person("Tenley", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"tenz@email.com");
		Person roger = new Person("Roger", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		Person felicia = new Person("Felicia", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6544",
				"jaboyd@email.com");
		persons.add(john);
		persons.add(jacob);
		persons.add(tenley);
		persons.add(roger);
		persons.add(felicia);
		List<Person> personsExpected = new ArrayList<Person>();
		for (Person p : persons) {
			personsExpected.add(Person.doFirestationPerson(p));
		}

		Mockito.when(personRepository.getPersonsFromAddresses(addresses)).thenReturn(persons);
		result = personService.getPersonsFromAddresses(addresses);

		assertEquals(persons.size(), result.size());
		assertEquals(persons.get(0).getFirstName(), result.get(0).getFirstName());
		assertEquals(persons.get(2).getAddress(), result.get(2).getAddress());
	}

	@Test
	void getPersonsFromAddressFirePersonTest() {
		String address = "1509 Culver St";
		List<Person> result = new ArrayList<Person>();
		List<Person> persons = new ArrayList<Person>();
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		Person jacob = new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513",
				"drk@email.com");
		Person tenley = new Person("Tenley", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"tenz@email.com");
		Person roger = new Person("Roger", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		Person felicia = new Person("Felicia", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6544",
				"jaboyd@email.com");
		persons.add(john);
		persons.add(jacob);
		persons.add(tenley);
		persons.add(roger);
		persons.add(felicia);
		List<Person> personsExpected = new ArrayList<Person>();
		for (Person p : persons) {
			personsExpected.add(Person.doFirePerson(p));
		}

		Mockito.when(personRepository.getPersonsFromAddressFirePerson(address)).thenReturn(persons);
		result = personService.getPersonsFromAddressFirePerson(address);

		assertEquals(personsExpected.size(), result.size());
		assertEquals(personsExpected.get(0).getFirstName(), result.get(0).getFirstName());
//		assertEquals(personsExpected.get(2).getAddress(), result.get(2).getAddress());
	}

	@Test
	void getPersonsFromAddressFirestationPersonTest() {
		String address = "1509 Culver St";
		List<Person> result = new ArrayList<Person>();
		List<Person> persons = new ArrayList<Person>();
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		Person jacob = new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513",
				"drk@email.com");
		Person tenley = new Person("Tenley", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"tenz@email.com");
		Person roger = new Person("Roger", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		Person felicia = new Person("Felicia", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6544",
				"jaboyd@email.com");
		persons.add(john);
		persons.add(jacob);
		persons.add(tenley);
		persons.add(roger);
		persons.add(felicia);
		List<Person> personsExpected = new ArrayList<Person>();
		for (Person p : persons) {
			personsExpected.add(Person.doFirestationPerson(p));
		}

		Mockito.when(personRepository.getPersonsFromAddressFirestationPerson(address)).thenReturn(persons);
		result = personService.getPersonsFromAddressFirestationPerson(address);

		assertEquals(personsExpected.size(), result.size());
		assertEquals(personsExpected.get(0).getFirstName(), result.get(0).getFirstName());
		assertEquals(personsExpected.get(2).getAddress(), result.get(2).getAddress());
	}

	@Test
	void getPersonsFromAddressChildAlert() {
		String address = "1509 Culver St";
		List<Person> result = new ArrayList<Person>();
		List<Person> persons = new ArrayList<Person>();
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		Person jacob = new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513",
				"drk@email.com");
		Person tenley = new Person("Tenley", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"tenz@email.com");
		Person roger = new Person("Roger", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		Person felicia = new Person("Felicia", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6544",
				"jaboyd@email.com");
		persons.add(john);
		persons.add(jacob);
		persons.add(tenley);
		persons.add(roger);
		persons.add(felicia);
		List<Person> personsExpected = new ArrayList<Person>();
		for (Person p : persons) {
			personsExpected.add(Person.doChildPerson(p));
		}

		Mockito.when(personRepository.getPersonsFromAddressChildAlert(address)).thenReturn(persons);
		result = personService.getPersonsFromAddressChildAlert(address);

		assertEquals(personsExpected.size(), result.size());
		assertEquals(personsExpected.get(0).getFirstName(), result.get(0).getFirstName());
//		assertEquals(personsExpected.get(2).getAddress(), result.get(2).getAddress());
	}

	@Test
	void getPersonFromFirstNameAndLastNameTest() {
		String firstName = "John";
		String lastName = "Boyd";
		Person result = new Person();
		Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		Person john = Person.doInfoPerson(person);

		Mockito.when(personRepository.getPersonFromFirstNameAndLastName(firstName, lastName)).thenReturn(person);
		result = personRepository.getPersonFromFirstNameAndLastName(firstName, lastName);

		assertEquals(john.getLastName(), result.getLastName());
		assertEquals(john.getAddress(), result.getAddress());
	}

}
