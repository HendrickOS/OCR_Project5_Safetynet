package com.safety.safetynet.startup;

import java.io.InputStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safety.safetynet.database.DataBase;
import com.safety.safetynet.database.DataStore;

@Component
@Order(1)
public class DataLoader implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Démarrage de l'application");

		ObjectMapper mapper = new ObjectMapper();
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("data.json");
		DataStore database = mapper.readValue(input, DataStore.class);
		DataBase.getInstance().setStore(database);
		System.out.println("Database chargée " + database.getPersons().size() + " personnes dans la base de données");
		System.out
				.println("Database chargée " + database.getFirestations().size() + " casernes dans la base de données");
		System.out.println("Database chargée " + database.getMedicalrecords().size()
				+ " rapports médicaux dans la base de données");
	}

}
