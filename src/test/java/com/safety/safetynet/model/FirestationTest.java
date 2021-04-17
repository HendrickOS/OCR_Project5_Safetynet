package com.safety.safetynet.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FirestationTest {

	@Test
	void testFirestation() {
		Firestation firestation = new Firestation("theAddress", "theStation");
		Firestation firestation2 = new Firestation();
		Firestation firestation3 = new Firestation("theAddress3", "theStation3");
		Firestation firestationUpdate = new Firestation("theAddressUpdate", "theStationUpdate");

		firestation2.setAddress("anotherAddress");
		firestation2.setStation("anotherStation");
		firestation3.update(firestationUpdate);

		assertEquals("theAddress", firestation.getAddress());
		assertEquals("theStation", firestation.getStation());
		assertEquals("anotherAddress", firestation2.getAddress());
		assertEquals("anotherStation", firestation2.getStation());
		assertEquals("theAddressUpdate", firestation3.getAddress());
		assertEquals("theStationUpdate", firestation3.getStation());
	}

}
