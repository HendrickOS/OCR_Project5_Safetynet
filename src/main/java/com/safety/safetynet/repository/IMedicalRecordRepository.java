package com.safety.safetynet.repository;

import com.safety.safetynet.model.MedicalRecord;

public interface IMedicalRecordRepository {

	public void addMedicalRecord(MedicalRecord medicalRecord);

	public void updateMedicalRecord(MedicalRecord medicalRecord);

	public void deleteMedicalRecord(MedicalRecord medicalRecord);

}
