package com.safety.safetynet.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.safety.safetynet.database.DataBase;
import com.safety.safetynet.model.Person;

@Component
public class PersonRepository extends BaseRepository implements IPersonRepository {

	@Override
	public void addPerson(Person person) {
		DataBase.getInstance().getStore().getPersons().add(person);
	}

	@Override
	public void updatePerson(Person person) {
		List<Person> listPersons = DataBase.getInstance().getStore().getPersons();
		for (Person p : listPersons) {
			if (p.getFirstName().equalsIgnoreCase(person.getFirstName())
					&& p.getLastName().equalsIgnoreCase(person.getLastName())) {
				p.update(person);
				break;
			}
		}
	}

	@Override
	public void deletePerson(Person person) {
		List<Person> listPersons = DataBase.getInstance().getStore().getPersons();
		for (Person p : listPersons) {
			if (p.getFirstName().equalsIgnoreCase(person.getFirstName())
					&& p.getLastName().equalsIgnoreCase(person.getLastName())) {
				listPersons.remove(p);
				break;
			}
		}

	}

	public List<Person> list() {
		return DataBase.getInstance().getStore().getPersons();
	}

}
