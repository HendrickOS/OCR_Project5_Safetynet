package com.safety.safetynet.repository;

import java.util.ArrayList;
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

	/* Récupère la liste des personnes vivant aux adresses d'une liste d'adresse */
	public List<Person> getPersonsFromAddresses(List<String> addresses) {
		List<Person> persons = DataBase.getInstance().getStore().getPersons();
		List<Person> result = new ArrayList<Person>();
		for (Person p : persons) {
			if (addresses.contains(p.getAddress())) {
				result.add(Person.doFirestationPerson(p));
			}
		}
		return result;
	}

	/* Récupère la liste des personnes vivant à une adresse */
	public List<Person> getPersonsFromAddress(String address) {
		List<Person> persons = DataBase.getInstance().getStore().getPersons();
		List<Person> result = new ArrayList<Person>();
		for (Person p : persons) {
			if (address.contains(p.getAddress())) {
				result.add(Person.doFirePerson(p));
			}
		}
		return result;
	}

	/* Récupère les informations d'une personne selon son nom et son prénom */
	public Person getPersonFromFirstNameAndLastName(String firstName, String lastName) {
		List<Person> persons = DataBase.getInstance().getStore().getPersons();
		Person person = new Person();
		for (Person p : persons) {
			if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) {
				person = Person.doInfoPerson(p);
			}
		}
		return person;
	}

}
