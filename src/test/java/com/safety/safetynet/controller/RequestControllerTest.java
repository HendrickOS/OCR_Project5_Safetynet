package com.safety.safetynet.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safety.safetynet.model.Person;
import com.safety.safetynet.service.FirestationService;
import com.safety.safetynet.service.MedicalRecordService;
import com.safety.safetynet.service.PersonService;

@WebMvcTest(controllers = RequestController.class)
//@SpringBootTest(classes = SafetynetApplication.class)
@ExtendWith(SpringExtension.class)

class RequestControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private PersonService personService;
	@MockBean
	private FirestationService firestationService;
	@MockBean
	private MedicalRecordService medicalRecordService;

	@Test
	void childAlertRequestTest() {
		ChildAlert childAlert = new ChildAlert();
		String address = "1509 Culver St";
		Person john = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		Person jacob = new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513",
				"drk@email.com");
		Person tenley = new Person("Tenley", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"tenz@email.com");
		Person roger = new Person("Roger", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		Person felicia = new Person("Felicia", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6544",
				"jaboyd@email.com");
		List<Person> persons = new ArrayList<Person>();
		persons.add(john);
		persons.add(jacob);
		persons.add(tenley);
		persons.add(roger);
		persons.add(felicia);
		List<Person> childs = new ArrayList<Person>();
		childs.add(tenley);
		childs.add(roger);
		List<Person> householdMembers = new ArrayList<Person>();
		householdMembers.add(john);
		householdMembers.add(jacob);
		householdMembers.add(felicia);

		childAlert.setChilds(childs);
		childAlert.setHouseholdMembers(householdMembers);
		Mockito.when(personService.getPersonsFromAddressChildAlert(address)).thenReturn(persons);

		try {
			mvc.perform(get("/childAlert?address=1509 Culver St").contentType(MediaType.APPLICATION_JSON)
					.characterEncoding("utf-8")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
					.andReturn().getResponse().getStatus();
//					.andExpect(content().json(new Gson().toJson(responseContent)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
//	void phoneAlertRequestTest() {
//		String firestation = "1";
//		Person peter = new Person("Peter", "Duncan", "644 Gershwin Cir", "Culver", "97451", "841-874-6512",
//				"jaboyd@email.com");
//		Person reginold = new Person("Reginold", "Walker", "908 73rd St", "Culver", "97451", "841-874-8547",
//				"reg@email.com");
//		Person jamie = new Person("Jamie", "Peters", "908 73rd St", "Culver", "97451", "841-874-7462",
//				"jpeter@email.com");
//		Person brian = new Person("Brian", "Stelzer", "947 E. Rose Dr", "Culver", "97451", "841-874-7784",
//				"bstel@email.com");
//		Person kendrik = new Person("Kendrik", "Stelzer", "947 E. Rose Dr", "Culver", "97451", "841-874-7784",
//				"bstel@email.com");
//		List<Person> persons = new ArrayList<Person>();
//		persons.add(peter);
//		persons.add(reginold);
//		persons.add(jamie);
//		persons.add(brian);
//		persons.add(kendrik);
//		Set<String> responseContent = new HashSet<String>();
//		responseContent.add("841-874-7784");
//		responseContent.add("841-874-7462");
//		responseContent.add("841-874-6512");
//		responseContent.add("841-874-8547");
//		String phoneResult = "[{\"841-874-7784\",\"841-874-7462\",\"841-874-6512\",\"841-874-8547\"}]";
//
//		Mockito.when(firestationService.getPersonsForFirestation(firestation)).thenReturn(persons);
//
//		try {
//			mvc.perform(get("/phoneAlert?firestation=1")).andDo(MockMvcResultHandlers.print())
//					.andExpect(status().isOk()).andReturn().getResponse().getStatus();
////					.andExpect(content().json(phoneResult));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	@Test
//	void fireRequestTest() {
//		String address = "834 Binoc Ave";
//		Person tessa = new Person("Tessa", "Carman", "834 Binoc Ave", "Culver", "97451", "841-874-6512",
//				"tenz@email.com");
//		List<Person> persons = new ArrayList<Person>();
//		persons.add(tessa);
//
//		Mockito.when(personService.getPersonsFromAddressFirePerson(address)).thenReturn(persons);
//
//		try {
//			mvc.perform(get("/fire").param("address", address)).andDo(MockMvcResultHandlers.print())
//					.andExpect(status().isOk()).andReturn().getResponse().getStatus();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

//	@Test
//	void floodStationsRequestTest() {
//		String station = "4";
//		List<Integer> stations = new ArrayList<Integer>();
//		stations.add(Integer.valueOf(station));
//		Person tony = new Person("Tony", "Cooper", "112 Steppes Pl", "Culver", "97451", "841-874-6874",
//				"tcoop@ymail.com");
//		Person ron = new Person("Ron", "Peters", "112 Steppes Pl", "Culver", "97451", "841-874-8888",
//				"jpeter@email.com");
//		Person allison = new Person("Allison", "Boyd", "112 Steppes Pl", "Culver", "97451", "841-874-9888",
//				"aly@imail.com");
//		Person lily = new Person("Lily", "Cooper", "489 Manchester St", "Culver", "97451", "841-874-9845",
//				"lily@email.com");
//		List<Person> persons = new ArrayList<Person>();
//		persons.add(tony);
//		persons.add(ron);
//		persons.add(allison);
//		persons.add(lily);
//		List<String> addresses = new ArrayList<String>();
//		addresses.add("112 Steppes Pl");
//		addresses.add("489 Manchester St");
//
//		Mockito.when(firestationService.getFirestationsAddresses(station)).thenReturn(addresses);
//		Mockito.when(personService.getPersonsFromAddresses(new ArrayList<String>(addresses))).thenReturn(persons);
//
//		try {
//			mvc.perform(get("/flood/stations?stations=4")).andDo(MockMvcResultHandlers.print())
//					.andExpect(status().isOk()).andReturn().getResponse().getStatus();
////					.andExpect(content().json(phoneResult));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

//	@Test
//	void personInfoRequestController() {
//		PersonInfo personInfo = new PersonInfo();
//		Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
//				"jaboyd@email.com");
//		List<String> medications = new ArrayList<String>();
//		medications.add("aznol:350mg");
//		medications.add("hydrapermazol:100mg");
//		List<String> allergies = new ArrayList<String>();
//		allergies.add("nillacilan");
//		MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);
//
//		String result = "{\"person\":{\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"email\":\"jaboyd@email.com\",\"age\":37},\"medicalRecord\":{\"medications\":[\"aznol:350mg\",\"hydrapermazol:100mg\"],\"allergies\":[\"nillacilan\"]}}";
//
//		person = Person.doInfoPerson(person);
//		medicalRecord = MedicalRecord.doPersonInfoMedicalRecord(medicalRecord);
//		personInfo.setPerson(person);
//		personInfo.setMedicalRecord(medicalRecord);
////		Mockito.when(personService.getPersonsFromAddressChildAlert(address)).thenReturn(persons);
//
//		try {
//			mvc.perform(get("/personInfo?firstName=John&lastName=Boyd").contentType(MediaType.APPLICATION_JSON)
//					.characterEncoding("utf-8")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
//					.andReturn().getResponse().getStatus();
////					.andExpect(content().json(result));
////			Mockito.verify(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//	}

//	@Test
//	void communityEmailRequestTest() {
//		RequestController requestController = new RequestController();
//		String city = "Culver";
//		Person peter = new Person("Peter", "Duncan", "644 Gershwin Cir", "Culver", "97451", "841-874-6512",
//				"jaboyd@email.com");
//		Person reginold = new Person("Reginold", "Walker", "908 73rd St", "Culver", "97451", "841-874-8547",
//				"reg@email.com");
//		Person jamie = new Person("Jamie", "Peters", "908 73rd St", "Culver", "97451", "841-874-7462",
//				"jpeter@email.com");
//		Person brian = new Person("Brian", "Stelzer", "947 E. Rose Dr", "Culver", "97451", "841-874-7784",
//				"bstel@email.com");
//		Person kendrik = new Person("Kendrik", "Stelzer", "947 E. Rose Dr", "Culver", "97451", "841-874-7784",
//				"bstel@email.com");
//		List<Person> persons = new ArrayList<Person>();
//		persons.add(peter);
//		persons.add(reginold);
//		persons.add(jamie);
//		persons.add(brian);
//		persons.add(kendrik);
//		Set<String> emails = new HashSet<String>();
//
//		Mockito.when(requestController.getEmailofAllPersonsFromCity(city)).thenReturn(emails);
//
//		try {
//			mvc.perform(get("/communityEmail?city=Culver")).andDo(MockMvcResultHandlers.print())
//					.andExpect(status().isOk()).andReturn().getResponse().getStatus();
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
