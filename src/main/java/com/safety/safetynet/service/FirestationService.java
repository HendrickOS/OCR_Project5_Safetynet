package com.safety.safetynet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.safetynet.model.Firestation;
import com.safety.safetynet.repository.FirestationRepository;

@Service
public class FirestationService {

	@Autowired
	private FirestationRepository firestationRepository;

	public void saveRepository(Firestation firestation) {
		if (firestation != null && firestation.getAddress() != null && firestation.getStation() != null) {
			firestationRepository.addFirestation(firestation);
		}
	}

}
