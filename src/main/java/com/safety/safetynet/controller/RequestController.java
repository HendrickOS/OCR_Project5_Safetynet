package com.safety.safetynet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/childAlert")
	public List<Person> childsFromAdress(@RequestParam String address) {
		return null;
	}

	@GetMapping("/phoneAlert")
	public List<String> getPhonefromPerson(@RequestParam int firestation) {
		String station = String.valueOf(firestation);
		List<Person> persons = firestationService.getPersonsForFirestation(station);
		return persons.stream().map(p -> p.getPhone()).collect(Collectors.toList());
	}

	@GetMapping("/fire")
	public List<Person> getPersonsFromAddressAndStationNumber(@RequestParam String address) {
		return null;
	}

	@GetMapping("/stations")
	public List<String> getPersonsSortbyAddressFromStationNumbers(@RequestParam List<Integer> stationNumbers) {
		return null;
	}

	@GetMapping("/personInfo")
	public List<String> getPersonAndMedicalRecordFromFirstNameAndLastName(@RequestParam String firstName,
			String lastName) {
		return null;
	}

	@GetMapping("/communityEmail")
	public List<String> getEmailofAllPersonsFromCity(@RequestParam String city) {
		return null;
	}
}
