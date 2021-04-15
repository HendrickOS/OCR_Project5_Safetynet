package com.safety.safetynet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.safety.safetynet.model.Firestation;
import com.safety.safetynet.service.FirestationService;

@RestController
@RequestMapping("/firestation")
public class FirestationController {

	@Autowired
	private FirestationService firestationService;

	@GetMapping("/list")
	public Iterable<Firestation> list() {
		return firestationService.list();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void addNewFirestation(@RequestBody Firestation firestation) {
		firestationService.saveFirestation(firestation);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateFiresation(@RequestBody Firestation firestation) {
		firestationService.updateFirestation(firestation);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteFirestation(@RequestBody Firestation firestation) {
		firestationService.deleteFirestation(firestation);
	}
}
