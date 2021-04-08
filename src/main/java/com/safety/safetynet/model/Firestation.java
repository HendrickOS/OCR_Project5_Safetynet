package com.safety.safetynet.model;

public class Firestation {

	private String address;
	private String station;

	public Firestation(String address, String station) {
		super();
		this.address = address;
		this.station = station;
	}

	public Firestation() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

}
