package com.safety.safetynet.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testPerson() {
		Person person = new Person("myFirstName", "myLastName", "myAddress", "myCity", "myZip", "myPhoneNumber",
				"myEmailAddress");
		Person person2 = new Person();

		person2.setFirstName("anotherFirstName");
		person2.setLastName("anotherLastName");
		person2.setAddress("anotherAddress");
		person2.setCity("anotherCity");
		person2.setZip("anotherZip");
		person2.setPhone("anotherPhoneNumber");
		person2.setEmail("anotherEmailAddress");

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

	}

}
