package com.safety.safetynet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.safetynet.model.MedicalRecord;
import com.safety.safetynet.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;

	public void saveMedicalRecord(MedicalRecord medicalRecord) {
		if (medicalRecord != null && medicalRecord.getFirstName() != null && medicalRecord.getLastName() != null) {
			medicalRecordRepository.addMedicalRecord(medicalRecord);
		}
	}

}
