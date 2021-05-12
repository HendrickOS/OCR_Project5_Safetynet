package com.safety.safetynet.database;

import org.springframework.stereotype.Component;

@Component
public class DataBase {

	private static DataBase instance;
	private DataStore dataStore;

	private DataBase() {
	}

	public static DataBase getInstance() {
		if (instance == null) {
			instance = new DataBase();
		}
		return instance;
	}

	public DataStore getStore() {
		return dataStore;
	}

	public void setStore(DataStore dataStore) {
		this.dataStore = dataStore;
	}

}
