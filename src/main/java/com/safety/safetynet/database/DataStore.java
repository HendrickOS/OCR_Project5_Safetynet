package com.safety.safetynet.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.safety.safetynet.model.Firestation;
import com.safety.safetynet.model.MedicalRecord;
import com.safety.safetynet.model.Person;

@Component
public class DataStore {
	private List<Person> persons = new ArrayList<Person>();
	private List<Firestation> firestations = new ArrayList<Firestation>();
	private List<MedicalRecord> medicalrecords = new ArrayList<MedicalRecord>();

	public DataStore() {
		super();
	}

	public List<Person> getPersons() {
		return persons;
	}

	public List<Firestation> getFirestations() {
		return firestations;
	}

	public List<MedicalRecord> getMedicalrecords() {
		return medicalrecords;
	}

}
