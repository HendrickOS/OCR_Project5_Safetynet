package com.safety.safetynet.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.safety.safetynet.SafetynetApplication;
import com.safety.safetynet.model.Firestation;
import com.safety.safetynet.repository.FirestationRepository;

@SpringBootTest(classes = SafetynetApplication.class)
@ExtendWith(SpringExtension.class)
class FirestationServiceTest {

	@Autowired
	FirestationService firestationService;
	@MockBean
	FirestationRepository firestationRepository;
	@MockBean
	PersonService personService;

	@Test
	void getFirestationsAddressesTest() {
		String station = "station";
		String address = "address";
		Firestation firestation = new Firestation("address", "station");

		firestationService.getFirestationsAddresses(station);

		Mockito.verify(firestationRepository).getFirestationsAddresses(station);
	}

	@Test
	void addFirestationTest() {
		Firestation firestationUpdate = new Firestation("address", "station");

		firestationService.saveFirestation(firestationUpdate);

		Mockito.verify(firestationRepository).addFirestation(firestationUpdate);
	}

	@Test
	void updateFirestationTest() {
		Firestation firestationUpdate = new Firestation("address", "station");

		firestationService.updateFirestation(firestationUpdate);

		Mockito.verify(firestationRepository).updateFirestation(firestationUpdate);
	}

	@Test
	void deleteFirestationTest() {
		Firestation firestationUpdate = new Firestation("address", "station");

		firestationService.deleteFirestation(firestationUpdate);

		Mockito.verify(firestationRepository).deleteFirestation(firestationUpdate);
	}

	@Test
	void listTest() {
		firestationService.list();

		Mockito.verify(firestationRepository).list();
	}
}
