package com.safety.safetynet.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safety.safetynet.database.DataBase;
import com.safety.safetynet.model.Firestation;
import com.safety.safetynet.model.MedicalRecord;
import com.safety.safetynet.model.Person;
import com.safety.safetynet.service.FirestationService;
import com.safety.safetynet.service.MedicalRecordService;
import com.safety.safetynet.service.PersonService;

@RestController
public class RequestController {

	@Autowired
	private PersonService personService;
	@Autowired
	private FirestationService firestationService;
	@Autowired
	private MedicalRecordService medicalRecordService;

	/*
	 * Ddoit retourner une liste d'enfants (tout individu âgé de 18 ans ou moins)
	 * habitant à cette adresse. La liste doit comprendre le prénom et le nom de
	 * famille de chaque enfant, son âge et une liste des autres membres du foyer.
	 * S'il n'y a pas d'enfant, cette url peut renvoyer une chaîne vide
	 */
	@GetMapping("/childAlert")
	public ChildAlert getFamilyFromAdress(@RequestParam String address) {
		ChildAlert childAlert = new ChildAlert();
		List<Person> persons = personService.getPersonsFromAddress(address);
		for (Person person : persons) {
			if (medicalRecordService.getPersonAge(person) < 18) {
				childAlert.getChilds().add(person);
			}
			person.setAge(medicalRecordService.getPersonAge(person));
		}
		persons.removeAll(childAlert.getChilds());
		childAlert.setHouseholdMembers(persons);
		if (childAlert.getChilds().isEmpty()) {
			childAlert.setChilds(null);
//			childAlert.setHouseholdMembers(null);
		}
		return childAlert;
	}

	/*
	 * Doit retourner une liste des numéros de téléphone des résidents desservis par
	 * la caserne de pompiers. Nous l'utiliserons pour envoyer des messages texte
	 * d'urgence à des foyers spécifiques
	 */
	@GetMapping("/phoneAlert")
	public Set<String> getPhoneFromPersonByFirestation(@RequestParam int firestation) {
		String station = String.valueOf(firestation);
		List<Person> persons = firestationService.getPersonsForFirestation(station);
		return persons.stream().map(p -> p.getPhone()).collect(Collectors.toSet());
	}

	/*
	 * Doit retourner la liste des habitants vivant à l’adresse donnée ainsi que le
	 * numéro de la caserne de pompiers la desservant. La liste doit inclure le nom,
	 * le numéro de téléphone, l'âge et les antécédents médicaux (médicaments,
	 * posologie et allergies) de chaque personne
	 */
	@GetMapping("/fire")
	public Fire getPersonsFromAddressAndStationNumber(@RequestParam String address) {
		Fire fire = new Fire();
		List<Firestation> firestations = DataBase.getInstance().getStore().getFirestations();
		String stationNumber = null;
		List<Person> persons = personService.getPersonsFromAddress(address);
		for (Firestation f : firestations) {
			if (f.getAddress().equalsIgnoreCase(address)) {
				stationNumber = f.getStation();
			}
		}
		for (Person p : persons) {
			p.setAge(medicalRecordService.getPersonAge(p));
			p.setMedicalRecord(medicalRecordService.getMedicationsAndAllergiesFromPerson(p));
		}
		fire.setPersons(persons);
		fire.setStationNumber(stationNumber);
		return fire;
	}

	/*
	 * Doit retourner une liste de tous les foyers desservis par la caserne. Cette
	 * liste doit regrouper les personnes par adresse. Elle doit aussi inclure le
	 * nom, le numéro de téléphone et l'âge des habitants, et faire figurer leurs
	 * antécédents médicaux (médicaments, posologie et allergies) à côté de chaque
	 * nom
	 */
	@GetMapping("/flood/stations")
	public List<FloodStation> getPersonsSortbyAddressFromStationNumbers(@RequestParam int stations) {
		List<FloodStation> floodStations = new ArrayList<FloodStation>();
		List<String> addresses = new ArrayList<String>();
		List<Person> persons = new ArrayList<Person>();
		List<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
		FloodStation floodStation = new FloodStation();
		String stationNb = String.valueOf(stations);
		addresses.addAll(firestationService.getFirestationsAddresses(stationNb));
		persons.addAll(personService.getPersonsFromAddresses(addresses));
		medicalRecords.addAll(medicalRecordService.getMedicationsAndAllergiesFromPersons(persons));
		for (String address : addresses) {
			for (Person person : persons) {
				if (person.getAddress().equalsIgnoreCase(address)) {
					for (MedicalRecord mr : medicalRecords) {
						if (mr.getFirstName().equalsIgnoreCase(person.getFirstName())
								&& mr.getLastName().equalsIgnoreCase(person.getLastName())) {
							floodStation.setPerson(person);
							floodStation.setMedicalRecord(mr);
							floodStations.add(floodStation);
						}
					}
				}
			}
		}
		return floodStations;
	}

	/*
	 * Doit retourner le nom, l'adresse, l'âge, l'adresse mail et les antécédents
	 * médicaux (médicaments, posologie, allergies) de chaque habitant. Si plusieurs
	 * personnes portent le même nom, elles doivent toutes apparaître
	 */
	@GetMapping("/personInfo")
	public PersonInfo getPersonAndMedicalRecordFromFirstNameAndLastName(@RequestParam String firstName,
			String lastName) {
		List<Person> persons = DataBase.getInstance().getStore().getPersons();
		List<MedicalRecord> medicalRecords = DataBase.getInstance().getStore().getMedicalrecords();
		PersonInfo personInfo = new PersonInfo();
		Person person = new Person();
		MedicalRecord medicalRecord = new MedicalRecord();
		for (Person p : persons) {
			if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) {
				person = Person.doInfoPerson(p);
				person.setAge(medicalRecordService.getPersonAge(p));
			}
		}
		for (MedicalRecord mr : medicalRecords) {
			if (mr.getFirstName().equalsIgnoreCase(firstName) && mr.getLastName().equalsIgnoreCase(lastName)) {
				medicalRecord = MedicalRecord.doPersonInfoMedicalRecord(mr);
			}
		}
		personInfo.setPerson(person);
		personInfo.setMedicalRecord(medicalRecord);
		return personInfo;
	}

	/* Doit retourner les adresses mail de tous les habitants de la ville */
	@GetMapping("/communityEmail")
	public Set<String> getEmailofAllPersonsFromCity(@RequestParam String city) {
		Set<String> emails = new HashSet<String>();
		List<Person> persons = DataBase.getInstance().getStore().getPersons();
		for (Person p : persons) {
			if (p.getCity().equalsIgnoreCase(city)) {
				emails.add(p.getEmail());
			}
		}
		return emails;
	}
}
