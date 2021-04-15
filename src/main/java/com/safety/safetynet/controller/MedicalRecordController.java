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

import com.safety.safetynet.model.MedicalRecord;
import com.safety.safetynet.service.MedicalRecordService;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

	@Autowired
	private MedicalRecordService medicalRecordService;

	@GetMapping("/list")
	public Iterable<MedicalRecord> list() {
		return medicalRecordService.list();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void addNewMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		medicalRecordService.saveMedicalRecord(medicalRecord);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		medicalRecordService.updateMedicalRecord(medicalRecord);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		medicalRecordService.deleteMedicalRecord(medicalRecord);
	}
}
