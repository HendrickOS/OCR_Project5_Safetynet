package com.safety.safetynet.controller;

import com.safety.safetynet.model.MedicalRecord;
import com.safety.safetynet.model.Person;

public class PersonInfo {

	Person person = new Person();
	MedicalRecord medicalRecord = new MedicalRecord();

	public PersonInfo() {
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

}
