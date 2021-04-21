package com.safety.safetynet.controller;

import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safety.safetynet.model.Person;
import com.safety.safetynet.service.PersonService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration("servlet-context.xml")

@WebMvcTest(controllers = PersonController.class)
//@SpringBootTest(classes = BookapiApplication.class)
@ExtendWith(SpringExtension.class)
class PersonControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private PersonService personService;
	private PersonController personController;

	@Test
	public void addPersonTest() {
		// String responseContent='';
		Person person = new Person("myFirstName", "myLastName", "myAddress", "myCity", "myZip", "myPhoneNumber",
				"myEmailAddress");
		
		personController.addNewPerson(person);
		
		try {
			mvc.perform(get("/person").contentType("application/json")).andExpect(ResponseEntity.ok()).andExpect(content().json({"firstName":"myFirstName","lastName":"myLastName","city":"myCity"}));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		assertTrue(ResponseEntity.ok() == Boolean.TRUE);

	}

	public static <T> Object convertJSONStringToObject(String json, Class<T> objectClass) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.readValue(json, objectClass);
	}

}
