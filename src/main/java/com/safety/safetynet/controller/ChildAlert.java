package com.safety.safetynet.controller;

import java.util.ArrayList;
import java.util.List;

import com.safety.safetynet.model.Person;

public class ChildAlert {

	private List<Person> childs = new ArrayList<Person>();
	private List<Person> householdMembers = new ArrayList<Person>();
	// private Person child = new Person();
	// private HashMap<Person, List<Person>> family = new HashMap<Person,
	// List<Person>>();

	public ChildAlert() {
		super();
	}

	public ChildAlert(List<Person> childs) {
		super();
		this.childs = childs;
	}

	public List<Person> getChilds() {
		return childs;
	}

	public void setChilds(List<Person> childs) {
		this.childs = childs;
	}

	public List<Person> getHouseholdMembers() {
		return householdMembers;
	}

	public void setHouseholdMembers(List<Person> householdMembers) {
		this.householdMembers = householdMembers;
	}

	public void add(Person person) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(person);
	}

}
