package com.safety.safetynet.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testPerson() {
		Person person = new Person("myFirstName", "myLastName", "myAddress", "myCity", "myZip", "myPhoneNumber",
				"myEmailAddress");
		Person person2 = new Person();
		Person person3 = new Person("myFirstName3", "myLastName3", "myAddress3", "myCity3", "myZip3", "myPhoneNumber3",
				"myEmailAddress3");
		Person personUpdate = new Person("myFirstName", "myLastName", "myAddressUpdate", "myCityUpdate", "myZipUpdate",
				"myPhoneNumberUpdate", "myEmailAddressUpdate");

		person2.setFirstName("anotherFirstName");
		person2.setLastName("anotherLastName");
		person2.setAddress("anotherAddress");
		person2.setCity("anotherCity");
		person2.setZip("anotherZip");
		person2.setPhone("anotherPhoneNumber");
		person2.setEmail("anotherEmailAddress");
		person3.update(personUpdate);

		assertEquals("myFirstName", person.getFirstName());
		assertEquals("myLastName", person.getLastName());
		assertEquals("myAddress", person.getAddress());
		assertEquals("myCity", person.getCity());
		assertEquals("myZip", person.getZip());
		assertEquals("myPhoneNumber", person.getPhone());
		assertEquals("myEmailAddress", person.getEmail());
		assertEquals("anotherFirstName", person2.getFirstName());
		assertEquals("anotherLastName", person2.getLastName());
		assertEquals("anotherAddress", person2.getAddress());
		assertEquals("anotherCity", person2.getCity());
		assertEquals("anotherZip", person2.getZip());
		assertEquals("anotherPhoneNumber", person2.getPhone());
		assertEquals("anotherEmailAddress", person2.getEmail());
		assertEquals("myAddressUpdate", person3.getAddress());
		assertEquals("myCityUpdate", person3.getCity());
		assertEquals("myZipUpdate", person3.getZip());
		assertEquals("myPhoneNumberUpdate", person3.getPhone());
		assertEquals("myEmailAddressUpdate", person3.getEmail());

	}

}
