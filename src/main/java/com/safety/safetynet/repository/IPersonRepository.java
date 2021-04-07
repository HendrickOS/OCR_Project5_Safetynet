package com.safety.safetynet.repository;

import com.safety.safetynet.model.Person;

public interface IPersonRepository {

	public void addPerson(Person person);

	public void updatePerson(Person person);

	public void deletePerson(Person person);

}
