package com.safety.safetynet.repository;

import com.safety.safetynet.database.DataBase;
import com.safety.safetynet.database.DataStore;

public class BaseRepository {

	DataStore store = DataBase.getInstance().getStore();

	public BaseRepository() {
		store = DataBase.getInstance().getStore();
	}

}
