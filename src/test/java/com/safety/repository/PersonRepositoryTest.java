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
import com.safety.safetynet.model.Person;
import com.safety.safetynet.repository.PersonRepository;

@SpringBootTest(classes = SafetynetApplication.class)
@ExtendWith(SpringExtension.class)
class PersonRepositoryTest {

	@Autowired
	PersonRepository personRepository;

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

		result = personRepository.getPersonsFromAddresses(addresses);

		assertEquals(personsExpected.size(), result.size());
		assertEquals(personsExpected.get(0).getFirstName(), result.get(0).getFirstName());
		assertEquals(personsExpected.get(2).getAddress(), result.get(2).getAddress());

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

		result = personRepository.getPersonsFromAddressFirePerson(address);

		assertEquals(personsExpected.size(), result.size());
		assertEquals(personsExpected.get(0).getFirstName(), result.get(0).getFirstName());
		assertEquals(personsExpected.get(2).getPhone(), result.get(2).getPhone());
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

		result = personRepository.getPersonsFromAddressFirestationPerson(address);

		assertEquals(personsExpected.size(), result.size());
		assertEquals(personsExpected.get(0).getFirstName(), result.get(0).getFirstName());
		assertEquals(personsExpected.get(2).getPhone(), result.get(2).getPhone());
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

		result = personRepository.getPersonsFromAddressChildAlert(address);

		assertEquals(personsExpected.size(), result.size());
		assertEquals(personsExpected.get(0).getFirstName(), result.get(0).getFirstName());
		assertEquals(personsExpected.get(2).getLastName(), result.get(2).getLastName());
	}

	@Test
	void getPersonFromFirstNameAndLastNameTest() {
		String firstName = "John";
		String lastName = "Boyd";
		Person result = new Person();
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		john = Person.doInfoPerson(john);

		result = personRepository.getPersonFromFirstNameAndLastName(firstName, lastName);

		assertEquals(john.getLastName(), result.getLastName());
		assertEquals(john.getAddress(), result.getAddress());

	}
}
