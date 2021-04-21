package com.safety.safetynet.controller;

import java.util.ArrayList;
import java.util.List;

import com.safety.safetynet.model.Person;

public class FirestationPersons {

	private List<Person> persons = new ArrayList<Person>();
	int nbAdults;
	int nbChilds;

	public FirestationPersons() {
		super();
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public int getNbAdults() {
		return nbAdults;
	}

	public void setNbAdults(int nbAdults) {
		this.nbAdults = nbAdults;
	}

	public int getNbChilds() {
		return nbChilds;
	}

	public void setNbChilds(int nbChilds) {
		this.nbChilds = nbChilds;
	}

}
