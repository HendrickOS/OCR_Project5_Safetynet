package com.safety.safetynet.controller;

import java.util.ArrayList;
import java.util.List;

import com.safety.safetynet.model.MedicalRecord;

public class FloodStation {

	private String address;
	private List<MedicalRecord> medicalRecord = new ArrayList<MedicalRecord>();

	public FloodStation() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<MedicalRecord> getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(List<MedicalRecord> medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

}
