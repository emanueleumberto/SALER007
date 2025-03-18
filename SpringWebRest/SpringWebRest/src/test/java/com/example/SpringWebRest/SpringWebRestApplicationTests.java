package com.example.SpringWebRest;

import com.example.SpringWebRest.controllers.UserController;
import com.example.SpringWebRest.models.User;
import com.example.SpringWebRest.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class SpringWebRestApplicationTests {

	@Autowired SpringWebRestApplication app;
	//@Autowired UserService userService;

	// MockMvc simula chiamate HTTP ai metodi del controller
	@Autowired private MockMvc mockMvc;

	@MockitoBean UserService userService;

	// Permette di convertire Oggetti Java in JSON
	@Autowired private ObjectMapper objectMapper;


	User userCreated;

	// assertEquals(exp, val);
	// assertNotEquals(ex, val);
	// assertTrue(condition);
	// assertFalse(condition);
	// assertNull(object);
	// assertNotNull(object);
	// assertSame(exp, obj);
	// assertNotSame(exp, obj);
	// assertArrayEquals(expArr, arr);
	// assertThrows(exceptionType, element);


	// Test sui controller
	@Test
	void testCreateUser() throws Exception {
		User user = new User();
		user.setFirstname("Francesca");
		user.setLastname("Neri");
		user.setCity("Palermo");
		user.setEmail("f.neri@example.com");
		user.setPassword("Pa$$w0rd!");

		User userSave = new User(15L, "Francesca", "Neri", "Palermo", "f.neri@example.com", "Pa$$w0rd!");

		when(userService.create(Mockito.any(User.class))).thenReturn(userSave);

		mockMvc.perform(post("/api/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(15))
				.andExpect(jsonPath("$.email").value("f.neri@example.com"));


		verify(userService, times(1)).create(Mockito.any(User.class));
	}

	@Test
	void testGetUserById() throws Exception {
		User user = new User(15L, "Francesca", "Neri", "Palermo", "f.neri@example.com", "Pa$$w0rd!");

		when(userService.findById(15L)).thenReturn(user);

		mockMvc.perform(get("/api/users/15"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstname").value("Francesca"))
				.andExpect(jsonPath("$.email").value("f.neri@example.com"));

		verify(userService, times(1)).findById(15L);
	}

	@Test
	void testDeleteUser() throws Exception {
		doNothing().when(userService).delete(15L);

		mockMvc.perform(delete("/api/users/15/delete"))
				.andExpect(status().isNoContent());

		verify(userService, times(1)).delete(15L);
	}

	@Test
	void testPutUpdateUser() throws Exception {
		User user = new User(15L, "Francesca", "Neri", "Palermo", "f.neri@example.com", "Pa$$w0rd!");
		User userSave = new User(15L, "Francesca", "Neri", "Milano", "f.neri@example.com", "Pa$$w0rd!");

		when(userService.findById(15L)).thenReturn(user);
		when(userService.update(Mockito.any(User.class))).thenReturn(userSave);

		mockMvc.perform(put("/api/users/15/update")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(userSave)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(15L))
				.andExpect(jsonPath("$.city").value("Milano"));

		verify(userService, times(1)).findById(15L);
		verify(userService, times(1)).update(Mockito.any(User.class));
	}

	@Test
	void testPatchUpdateUser() throws Exception {
		User user = new User(15L, "Francesca", "Neri", "Palermo", "f.neri@example.com", "Pa$$w0rd!");
		User userSave = new User(15L, "Francesca", "Neri", "Palermo", "test@example.com", "qwerty!");

		Map<String, Object> updates = new HashMap<String, Object>();
		updates.put("email", "test@example.com");
		updates.put("password", "qwerty!");

		when(userService.findById(15L)).thenReturn(user);
		when(userService.update(Mockito.any(User.class))).thenReturn(userSave);

		mockMvc.perform(patch("/api/users/15/update")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(updates)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.email").value("test@example.com"))
				.andExpect(jsonPath("$.password").value("qwerty!"));

		verify(userService, times(1)).findById(15L);
		verify(userService, times(1)).update(Mockito.any(User.class));
	}

	/*@BeforeAll
	public static void beforeAllTest() {
		// Inizializzazioni globali
		System.out.println("beforeAllTest");
	}

	@BeforeEach
	void beforeEachTest() {
		// Inizializzazioni prima di ogni test
		System.out.println("beforeEachTest");
	}*/

	@Test
	 void contextLoads() {
		assertThat(app).isNotNull();
		//assertThat(app).isNull();
		System.out.println("contextLoads");
	}

	// Test su Service

	/*@BeforeEach
	void createUser() {
		User user = new User();
		user.setFirstname("Francesca");
		user.setLastname("Neri");
		user.setCity("Palermo");
		user.setEmail("f.neri@example.com");
		user.setPassword("Pa$$w0rd!");
		userCreated = userService.create(user);
	}

	@Test
	void getUser() {
		User userRead = userService.findById(userCreated.getId());
		assertNotNull(userRead);
	}

	@Test
	void updateUser() {
		userCreated.setPassword("qwerty");
		userService.update(userCreated);
		User userRead = userService.findById(userCreated.getId());
		assertEquals("qwerty", userRead.getPassword());
	}

	@AfterEach
	void removeUser() {
		userService.delete(userCreated.getId());
	}*/

	/*@Test
	void testSum() {
		int result = 5 + 7;
		assertEquals(12, result);
		System.out.println("testSum");
	}*/

	/*@AfterEach
	void afterEachTest() {
		// chiusura dopo ogni test
		System.out.println("afterEachTest");
	}

	@AfterAll
	public static void afterAllTest() {
		// Chiusure globali
		System.out.println("afterAllTest");
	}*/

}
