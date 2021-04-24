package com.safety.safetynet.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Person {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;
	private int age;
	private MedicalRecord medicalRecord = null;

	public Person(String firstName, String lastName, String address, String city, String zip, String phone,
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}

	public Person() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void update(Person person) {
		this.address = person.address;
		this.city = person.city;
		this.zip = person.zip;
		this.phone = person.phone;
		this.email = person.email;
	}

	public static Person doFirestationPerson(Person person) {
		Person p = new Person();
		p.setFirstName(person.getFirstName());
		p.setLastName(person.getLastName());
		p.setAddress(person.getAddress());
		p.setPhone(person.getPhone());
		return p;
	}

	public static Person doChildPerson(Person person) {
		Person p = new Person();
		p.setFirstName(person.getFirstName());
		p.setLastName(person.getLastName());
		return p;
	}

	public static Person doFirePerson(Person person) {
		Person p = new Person();
		p.setFirstName(person.getFirstName());
		p.setLastName(person.getLastName());
		p.setPhone(person.getPhone());
		return p;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMedicalRecord(MedicalRecord medicationsAndAllergiesFromPerson) {
		this.medicalRecord = medicationsAndAllergiesFromPerson;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

}
