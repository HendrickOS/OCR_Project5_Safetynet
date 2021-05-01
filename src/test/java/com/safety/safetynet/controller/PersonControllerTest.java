//package com.safety.safetynet.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.io.IOException;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.safety.safetynet.SafetynetApplication;
//import com.safety.safetynet.service.PersonService;
//
//@WebMvcTest(controllers = PersonController.class)
//@SpringBootTest(classes = SafetynetApplication.class)
//@ExtendWith(SpringExtension.class)
//public class PersonControllerTest {
//
//	@Autowired
//	private MockMvc mvc;
//	@MockBean
//	private PersonService personService;
//
//	@Test
//	public void getPersonTest() {
//		// String responseContent='';
//		try {
//			mvc.perform(get("/person").contentType("application/json")).andExpect(status().isOk());
//			// .andExpect(content().json({"firstName":"Thomas
//			// Gasmyr","lastName":"Mougang","city":"Yaounde"}));
//
////			 .andExpect(content().json({"firstName":"John","lastName":"Boyd","address":"1509 Culver St","city":"Culver",
////			 "zip":"97451","phone":"841-874-6512","email":"jaboyd@email.com"}));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public static <T> Object convertJSONStringToObject(String json, Class<T> objectClass) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//		return mapper.readValue(json, objectClass);
//	}
//
//}