package com.safety.safetynet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.safetynet.model.Person;
import com.safety.safetynet.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public void savePerson(Person person) {
		if (person != null && person.getFirstName() != null && person.getLastName() != null) {
			personRepository.addPerson(person);
		}
	}

}
