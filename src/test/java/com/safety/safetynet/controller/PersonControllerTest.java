package com.safety.safetynet.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safety.safetynet.model.Person;
import com.safety.safetynet.service.PersonService;

@WebMvcTest(controllers = PersonController.class)
//@SpringBootTest(classes = SafetynetApplication.class)
@ExtendWith(SpringExtension.class)
public class PersonControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private PersonService personService;

	@Test
	public void getPersonTest() throws Exception {
		List<Person> persons = new ArrayList<Person>();
		persons.add(
				new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com"));
		Mockito.when(personService.list()).thenReturn(persons);
		String responseContent = "[{ \"firstName\":\"John\", \"lastName\":\"Boyd\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-6512\", \"email\":\"jaboyd@email.com\" }]";

		try {
			mvc.perform(get("/person/list")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
					.andExpect(content().json(responseContent));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void addPersonTest() throws Exception {
//		List<Person> persons = new ArrayList<Person>();
//		Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
//				"jaboyd@email.com");
//		persons.add(person);
//		String responseContent = "[{ \"firstName\":\"John\", \"lastName\":\"Boyd\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-6512\", \"email\":\"jaboyd@email.com\" }]";
//		Mockito.when(personService.savePerson(person)).thenReturn(true);
//		String contenu = "{ \"firstName\":\"John\", \"lastName\":\"Boyd\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-6512\", \"email\":\"jaboyd@email.com\" }";
//		String json = "{\n" + "\"fistName\": \"John\", \n" + "\"lastName\": \"Boyd\", \n"
//				+ "\"address\": \"1509 Culver St\", \n" + "\"city\": \"Culver\", \n" + "\"zip\": \"97451\", \n"
//				+ "\"phone\": \"841-874-6512\", \n" + "\"email\": \"jaboyd@email.com\", \n" + "}";
//		try {
//			mvc.perform(post("/person/").contentType(MediaType.APPLICATION_JSON).content(responseContent)
//					.characterEncoding("utf-8")).andExpect(status().isOk()).andReturn().getResponse().getStatus();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static <T> Object convertJSONStringToObject(String json, Class<T> objectClass) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.readValue(json, objectClass);
	}

}