package com.safety.safetynet.controller;

import org.junit.jupiter.api.Test;

import com.safety.safetynet.model.Person;

class ChildAlertTest {

	@Test
	void testChildAlert() {
		ChildAlert childAlert = new ChildAlert();
		Person child = new Person("childFirstName", "childLastName", "childAddress", "childCity", "childZip",
				"childPhoneNumber", "childEmailAddress");
		Person householdMembers = new Person("householdMembersFirstName", "householdMembersLastName",
				"householdMembersAddress", "householdMembersCity", "householdMembersZip", "householdMembersPhoneNumber",
				"householdMembersEmailAddress");

//		childAlert.setChilds();

	}

}
