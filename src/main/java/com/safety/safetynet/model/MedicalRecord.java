package com.safety.safetynet.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MedicalRecord {

	private String firstName;
	private String lastName;
	private String birthdate;
	private List<String> medications;
	private List<String> allergies;

	public MedicalRecord(String firstName, String lastName, String birthdate, List<String> medications,
			List<String> allergies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}

	public MedicalRecord() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public List<String> getMedications() {
		return medications;
	}

	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	public void update(MedicalRecord medicalRecord) {
		this.birthdate = medicalRecord.birthdate;
		this.medications = medicalRecord.medications;
		this.allergies = medicalRecord.allergies;
	}

	public static MedicalRecord doPartialMedicalRecord(MedicalRecord medicalRecord) {
		MedicalRecord mRecord = new MedicalRecord();
		mRecord.setFirstName(medicalRecord.getFirstName());
		mRecord.setLastName(medicalRecord.getLastName());
		mRecord.setMedications(medicalRecord.getMedications());
		mRecord.setAllergies(medicalRecord.getAllergies());
		return mRecord;
	}

	public static MedicalRecord doPersonInfoMedicalRecord(MedicalRecord medicalRecord) {
		MedicalRecord mRecord = new MedicalRecord();
		mRecord.setMedications(medicalRecord.getMedications());
		mRecord.setAllergies(medicalRecord.getAllergies());
		return mRecord;
	}

}
