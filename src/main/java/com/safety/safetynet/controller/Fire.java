package com.safety.safetynet.controller;

import java.util.ArrayList;
import java.util.List;

import com.safety.safetynet.model.Person;

public class Fire {

	private List<Person> persons = new ArrayList<Person>();
	String stationNumber;

	public Fire() {
		super();
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public String getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}

}
