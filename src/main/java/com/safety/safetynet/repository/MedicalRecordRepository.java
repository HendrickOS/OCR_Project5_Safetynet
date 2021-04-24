package com.safety.safetynet.repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.safety.safetynet.database.DataBase;
import com.safety.safetynet.model.MedicalRecord;
import com.safety.safetynet.model.Person;

@Component
public class MedicalRecordRepository extends BaseRepository implements IMedicalRecordRepository {

	@Override
	public void addMedicalRecord(MedicalRecord medicalRecord) {
		DataBase.getInstance().getStore().getMedicalrecords().add(medicalRecord);
	}

	@Override
	public void updateMedicalRecord(MedicalRecord medicalRecord) {
		List<MedicalRecord> listMedicalRecords = DataBase.getInstance().getStore().getMedicalrecords();
		for (MedicalRecord mr : listMedicalRecords) {
			if (mr.getFirstName().equalsIgnoreCase(medicalRecord.getFirstName())
					&& mr.getLastName().equalsIgnoreCase(medicalRecord.getLastName())) {
				mr.update(medicalRecord);
				break;
			}
		}
	}

	@Override
	public void deleteMedicalRecord(MedicalRecord medicalRecord) {
		List<MedicalRecord> listMedicalRecords = DataBase.getInstance().getStore().getMedicalrecords();
		for (MedicalRecord mr : listMedicalRecords) {
			if (mr.getFirstName().equalsIgnoreCase(medicalRecord.getFirstName())
					&& mr.getLastName().equalsIgnoreCase(medicalRecord.getLastName())) {
				listMedicalRecords.remove(mr);
				break;
			}
		}
	}

	public List<MedicalRecord> list() {
		return DataBase.getInstance().getStore().getMedicalrecords();
	}

	/* Calcul d'âge */
	private int computAge(String birthdate) {
		String[] values = birthdate.split("/");
		LocalDate date = LocalDate.parse(values[2] + "-" + values[0] + "-" + values[1]);
		Period diff = Period.between(date, LocalDate.now());
		return diff.getYears();
	}

	/* Recupère l'âge d'une personne */
	public int getPersonAge(Person person) {
		int age = -1;
		List<MedicalRecord> medicalRecords = DataBase.getInstance().getStore().getMedicalrecords();
		for (MedicalRecord mr : medicalRecords) {
			if (person.getFirstName().equalsIgnoreCase(mr.getFirstName())
					&& person.getLastName().equalsIgnoreCase(mr.getLastName())) {
				age = computAge(mr.getBirthdate());
				break;
			}
		}
		return age;
	}

	/* Récuperer le rapport médical d'une personne selon son nom et son prénom */
	public MedicalRecord getMedicationsAndAllergiesFromPerson(Person person) {
		List<MedicalRecord> medicalRecords = DataBase.getInstance().getStore().getMedicalrecords();
		MedicalRecord medicalRecord = new MedicalRecord();
		for (MedicalRecord mr : medicalRecords) {
			if (person.getFirstName().equalsIgnoreCase(mr.getFirstName())
					&& person.getLastName().equalsIgnoreCase(mr.getLastName())) {
				medicalRecord = mr;
				break;
			}
		}
		MedicalRecord.doPartialMedicalRecord(medicalRecord);
		return medicalRecord;
	}

	/*
	 * Récupère une liste des rapport médicaux d'une liste personne selon leur nom
	 * et prénom
	 */
	public List<MedicalRecord> getMedicationsAndAllergiesFromPersons(List<Person> persons) {
		List<MedicalRecord> medicalRecords = DataBase.getInstance().getStore().getMedicalrecords();
		List<MedicalRecord> medicalRecord = new ArrayList<MedicalRecord>();
		for (Person p : persons) {
			for (MedicalRecord mr : medicalRecords) {
				if (p.getFirstName().equalsIgnoreCase(mr.getFirstName())
						&& p.getLastName().equalsIgnoreCase(mr.getLastName())) {
					medicalRecord.add(MedicalRecord.doPartialMedicalRecord(mr));
					break;
				}
			}
		}
		return medicalRecord;
	}

}
