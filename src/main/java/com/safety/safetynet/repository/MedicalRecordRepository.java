package com.safety.safetynet.repository;

import java.time.LocalDate;
import java.time.Period;
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

	private int computAge(String birthdate) {
		String[] values = birthdate.split("/");
		LocalDate date = LocalDate.parse(values[2] + "-" + values[0] + "-" + values[1]);
		Period diff = Period.between(date, LocalDate.now());
		return diff.getYears();
	}
}
