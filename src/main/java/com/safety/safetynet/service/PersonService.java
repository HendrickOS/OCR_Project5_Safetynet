package com.safety.safetynet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.safetynet.model.Person;
import com.safety.safetynet.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public boolean savePerson(Person person) {
		if (person != null && person.getFirstName() != null && person.getLastName() != null) {
			personRepository.addPerson(person);
			return true;
		}
		return false;
	}

	public List<Person> list() {
		return personRepository.list();
	}

	public void updatePerson(Person person) {
		if (person != null && person.getFirstName() != null && person.getLastName() != null) {
			personRepository.updatePerson(person);
		}

	}

	public void deletePerson(Person person) {
		if (person != null && person.getFirstName() != null && person.getLastName() != null) {
			personRepository.deletePerson(person);
		}
	}

	public List<Person> getPersonsFromAddresses(List<String> adresses) {
		return personRepository.getPersonsFromAddresses(adresses);
	}

	public List<Person> getPersonsFromAddressFirePerson(String adress) {
		return personRepository.getPersonsFromAddressFirePerson(adress);
	}

	public List<Person> getPersonsFromAddressFirestationPerson(String adress) {
		return personRepository.getPersonsFromAddressFirestationPerson(adress);
	}

	public List<Person> getPersonsFromAddressChildAlert(String adress) {
		return personRepository.getPersonsFromAddressChildAlert(adress);
	}

	public Person getPersonFromFirstNameAndLastName(String firstName, String lastName) {
		return personRepository.getPersonFromFirstNameAndLastName(firstName, lastName);
	}

}
