package com.safety.safetynet.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testPerson() {
		Person person = new Person("myFirstName", "myLastName", "myAddress", "myCity", "myZip", "myPhoneNumber",
				"myEmailAddress");
		Person personEmpty = new Person();
		Person personNeedAnUpdate = new Person("myFirstName3", "myLastName3", "myAddress3", "myCity3", "myZip3",
				"myPhoneNumber3", "myEmailAddress3");
		Person personUpdate = new Person("myFirstName", "myLastName", "myAddressUpdate", "myCityUpdate", "myZipUpdate",
				"myPhoneNumberUpdate", "myEmailAddressUpdate");
		Person personFirestationPerson = new Person("myFirstName", "myLastName", "myAddress", "myCity", "myZip",
				"myPhoneNumber", "myEmailAddress");
		Person personFirePerson = new Person("myFirstName", "myLastName", "myAddress", "myCity", "myZip",
				"myPhoneNumber", "myEmailAddress");
		Person personChildPerson = new Person("myFirstName", "myLastName", "myAddress", "myCity", "myZip",
				"myPhoneNumber", "myEmailAddress");
		Person personInfoPerson = new Person("myFirstName", "myLastName", "myAddress", "myCity", "myZip",
				"myPhoneNumber", "myEmailAddress");

		personEmpty.setFirstName("anotherFirstName");
		personEmpty.setLastName("anotherLastName");
		personEmpty.setAddress("anotherAddress");
		personEmpty.setCity("anotherCity");
		personEmpty.setZip("anotherZip");
		personEmpty.setPhone("anotherPhoneNumber");
		personEmpty.setEmail("anotherEmailAddress");
		personNeedAnUpdate.update(personUpdate);
		Person.doFirestationPerson(personFirestationPerson);
		Person.doFirePerson(personFirePerson);
		Person.doChildPerson(personChildPerson);
		Person.doInfoPerson(personInfoPerson);

		assertEquals("myFirstName", person.getFirstName());
		assertEquals("myLastName", person.getLastName());
		assertEquals("myAddress", person.getAddress());
		assertEquals("myCity", person.getCity());
		assertEquals("myZip", person.getZip());
		assertEquals("myPhoneNumber", person.getPhone());
		assertEquals("myEmailAddress", person.getEmail());
		assertEquals("anotherFirstName", personEmpty.getFirstName());
		assertEquals("anotherLastName", personEmpty.getLastName());
		assertEquals("anotherAddress", personEmpty.getAddress());
		assertEquals("anotherCity", personEmpty.getCity());
		assertEquals("anotherZip", personEmpty.getZip());
		assertEquals("anotherPhoneNumber", personEmpty.getPhone());
		assertEquals("anotherEmailAddress", personEmpty.getEmail());
		assertEquals("myAddressUpdate", personNeedAnUpdate.getAddress());
		assertEquals("myCityUpdate", personNeedAnUpdate.getCity());
		assertEquals("myZipUpdate", personNeedAnUpdate.getZip());
		assertEquals("myPhoneNumberUpdate", personNeedAnUpdate.getPhone());
		assertEquals("myEmailAddressUpdate", personNeedAnUpdate.getEmail());

	}

}
