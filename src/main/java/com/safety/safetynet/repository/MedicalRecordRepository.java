package com.safety.safetynet.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.safety.safetynet.database.DataBase;
import com.safety.safetynet.model.MedicalRecord;

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

}
