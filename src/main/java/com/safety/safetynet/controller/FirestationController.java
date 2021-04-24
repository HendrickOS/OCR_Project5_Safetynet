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

	/*
	 * Doit retourner une liste des personnes couvertes par la caserne de pompiers
	 * correspondante. Donc, si le numéro de station = 1, elle doit renvoyer les
	 * habitants couverts par la station numéro 1. La liste doit inclure les
	 * informations spécifiques suivantes : prénom, nom, adresse, numéro de
	 * téléphone. De plus, elle doit fournir un décompte du nombre d'adultes et du
	 * nombre d'enfants (tout individu âgé de 18 ans ou moins) dans la zone
	 * desservie
	 */
	@GetMapping
	public FirestationPersons getPersonforFirestation(@RequestParam int stationNumber) {
		FirestationPersons firestationPersons = new FirestationPersons();
		String station = String.valueOf(stationNumber);
		List<Person> persons = firestationService.getPersonsForFirestation(station);
//		List<Person> p = new ArrayList<Person>();
		for (Person person : persons) {
			if (medicalRecordService.getPersonAge(person) > 18) {
				firestationPersons.setNbAdults(firestationPersons.getNbAdults() + 1);
			}
//			person = Person.doFirestationPerson(person);
//			p.add(Person.doFirestationPerson(person));
		}
		firestationPersons.setPersons(persons);
//		firestationPersons.setPersons(Person.doFirestationPerson(persons));
		firestationPersons.setNbChilds(persons.size() - firestationPersons.getNbAdults());
		return firestationPersons;
	}
}
