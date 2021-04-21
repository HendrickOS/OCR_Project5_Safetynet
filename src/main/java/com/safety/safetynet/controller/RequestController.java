package com.safety.safetynet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safety.safetynet.service.FirestationService;
import com.safety.safetynet.service.MedicalRecordService;
import com.safety.safetynet.service.PersonService;

@RestController
@RequestMapping
public class RequestController {

	@Autowired
	private PersonService personService;
	@Autowired
	private FirestationService firestationService;
	@Autowired
	private MedicalRecordService medicalRecordService;

}
