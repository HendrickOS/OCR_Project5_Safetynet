package com.safety.safetynet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.safety.safetynet.model.Person;
import com.safety.safetynet.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/list")
	public Iterable<Person> list() {
		return personService.list();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity addNewPerson(@RequestBody Person person) {
		boolean result = personService.savePerson(person);
		if (result) {
			return ResponseEntity.ok(HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void updatePerson(@RequestBody Person person) {
		personService.updatePerson(person);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deletePerson(@RequestBody Person person) {
		personService.deletePerson(person);
	}
}
