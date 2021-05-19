package com.safety.safetynet.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.safety.safetynet.model.Person;
import com.safety.safetynet.service.FirestationService;
import com.safety.safetynet.service.MedicalRecordService;

@WebMvcTest(controllers = FirestationController.class)
//@SpringBootTest(classes = SafetynetApplication.class)
@ExtendWith(SpringExtension.class)
class FirestationControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	FirestationService firestationService;
	@MockBean
	MedicalRecordService medicalRecordService;

	@Test
	void getPersonforFirestationTest() {
		int stationNumber = 1;
		List<Person> persons = new ArrayList<Person>();
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		persons.add(john);
		Mockito.when(firestationService.getPersonsForFirestation(String.valueOf(stationNumber))).thenReturn(persons);
		Mockito.when(medicalRecordService.getPersonAge(persons.get(0))).thenReturn(23);

		try {
			mvc.perform(get("/firestation?stationNumber=1").contentType(MediaType.APPLICATION_JSON)
					.characterEncoding("utf-8")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
					.andReturn().getResponse().getStatus();
//					.andExpect(content().json(new Gson().toJson(responseContent)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
