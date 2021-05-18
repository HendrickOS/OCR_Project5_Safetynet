package com.safety.safetynet.service;

import static org.junit.Assert.assertEquals;

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
import com.safety.safetynet.repository.FirestationRepository;

@SpringBootTest(classes = SafetynetApplication.class)
@ExtendWith(SpringExtension.class)
class FirestationServiceTest {

	@Autowired
	FirestationService firestationService;
	@MockBean
	FirestationRepository firestationRepository;

	@Test
	void getFirestationsAddressesTest() {
		int station = 1;
		List<String> result = new ArrayList<String>();
		List<String> addresses = new ArrayList<String>();
		String address1 = "644 Gershwin Cir";
		String address2 = "908 73rd St";
		String address3 = "947 E. Rose Dr";
		addresses.add(address1);
		addresses.add(address2);
		addresses.add(address3);

		Mockito.when(firestationRepository.getFirestationsAddresses(String.valueOf(station))).thenReturn(addresses);
		result = firestationService.getFirestationsAddresses(String.valueOf(station));

		assertEquals(addresses.size(), result.size());
		assertEquals(addresses.get(0).length(), result.get(0).length());
		addresses.get(1).equals(result.get(1));
	}

}
