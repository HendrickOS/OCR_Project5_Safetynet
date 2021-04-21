package com.safety.safetynet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safety.safetynet.model.Firestation;
import com.safety.safetynet.model.Person;
import com.safety.safetynet.service.FirestationService;
import com.safety.safetynet.service.MedicalRecordService;

@RestController
@RequestMapping("/firestation")
public class FirestationController {

	@Autowired
	private FirestationService firestationService;
	@Autowired
	private MedicalRecordService medicalRecordService;

	@GetMapping("/list")
	public Iterable<Firestation> list() {
		return firestationService.list();
	}

	@PostMapping
	public void addNewFirestation(@RequestBody Firestation firestation) {
		firestationService.saveFirestation(firestation);
	}

	@PutMapping
	public void updateFiresation(@RequestBody Firestation firestation) {
		firestationService.updateFirestation(firestation);
	}

	@DeleteMapping
	public void deleteFirestation(@RequestBody Firestation firestation) {
		firestationService.deleteFirestation(firestation);
	}

	@GetMapping
	public FirestationPersons getPersonforFirestation(@RequestParam int stationNumber) {
		FirestationPersons firestationPersons = new FirestationPersons();
		String station = String.valueOf(stationNumber);
		List<Person> persons = firestationService.getPersonsForFirestation(station);
		for (Person person : persons) {
			if (medicalRecordService.getPersonAge(person) > 18) {
				firestationPersons.setNbAdults(firestationPersons.getNbAdults() + 1);
			}
		}
		firestationPersons.setPersons(persons);
		firestationPersons.setNbChilds(persons.size() - firestationPersons.getNbAdults());
		return firestationPersons;
	}
}
