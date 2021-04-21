package com.safety.safetynet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.safetynet.model.Firestation;
import com.safety.safetynet.model.Person;
import com.safety.safetynet.repository.FirestationRepository;

@Service
public class FirestationService {

	@Autowired
	private FirestationRepository firestationRepository;

	@Autowired
	private PersonService personService;

	public void saveFirestation(Firestation firestation) {
		if (firestation != null && firestation.getAddress() != null && firestation.getStation() != null) {
			firestationRepository.addFirestation(firestation);
		}
	}

	public List<Firestation> list() {
		return firestationRepository.list();
	}

	public void updateFirestation(Firestation firestation) {
		if (firestation != null && firestation.getAddress() != null && firestation.getStation() != null) {
			firestationRepository.updateFirestation(firestation);
		}

	}

	public void deleteFirestation(Firestation firestation) {
		if (firestation != null && firestation.getAddress() != null && firestation.getStation() != null) {
			firestationRepository.deleteFirestation(firestation);
		}
	}

	public List<Person> getPersonsForFirestation(String station) {
		return personService.getPersonsFromAddresses(firestationRepository.getFirestationAddress(station));
	}

}
