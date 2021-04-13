package com.safety.safetynet.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FirestationTest {

	@Test
	void testFirestation() {
		Firestation firestation = new Firestation("theAddress", "theStation");
		Firestation firestation2 = new Firestation();

		firestation2.setAddress("anotherAddress");
		firestation2.setStation("anotherStation");

		assertEquals("theAddress", firestation.getAddress());
		assertEquals("theStation", firestation.getStation());
		assertEquals("anotherAddress", firestation2.getAddress());
		assertEquals("anotherStation", firestation2.getStation());
	}

}
