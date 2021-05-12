package com.safety.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.safety.safetynet.model.Person;
import com.safety.safetynet.service.PersonService;

class PersonRepositoryTest {

	private PersonService personService;

	@Test
	void getPersonFromAddressesTest() {
		List<String> addresses = new ArrayList<String>();
		addresses.add("1509 Culver St");
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
		List<Person> result = new ArrayList<Person>();

		result = personService.getPersonsFromAddresses(addresses);

		assertEquals(personsExpected, result);

	}

	@Test
	void getPersonsFromAddressFirePersonTest() {
		List<Person> result = new ArrayList<Person>();
		String address = "1509 Culver St";
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

		result = personService.getPersonsFromAddressFirePerson(address);

		assertEquals(personsExpected, result);
	}

	@Test
	void getPersonsFromAddressFirestationPersonTest() {
		List<Person> result = new ArrayList<Person>();
		String address = "1509 Culver St";
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

		result = personService.getPersonsFromAddressFirestationPerson(address);

		assertEquals(personsExpected, result);
	}

	@Test
	void getPersonsFromAddressChildAlertTest() {
		List<Person> result = new ArrayList<Person>();
		String address = "1509 Culver St";
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

		result = personService.getPersonsFromAddressFirestationPerson(address);

		assertEquals(personsExpected, result);
	}

	@Test
	void getPersonFromFirstNameAndLastNameTest() {
		String firstName = "John";
		String lastName = "Boyd";
		Person result = new Person();
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		john = Person.doInfoPerson(john);

		result = personService.getPersonFromFirstNameAndLastName(firstName, lastName);

		assertEquals(john, result);
	}
}
