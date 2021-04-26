package com.safety.safetynet.controller;

import com.safety.safetynet.model.MedicalRecord;
import com.safety.safetynet.model.Person;

public class FloodStation {

	private Person person = new Person();
	private MedicalRecord medicalRecord = new MedicalRecord();

	public FloodStation() {
		super();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public void update(Person person, MedicalRecord medicalRecord) {
		this.person = person;
		this.medicalRecord = medicalRecord;
	}

}
