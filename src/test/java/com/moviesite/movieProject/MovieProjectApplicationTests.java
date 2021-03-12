package com.moviesite.movieProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviesite.movieProject.dto.UserCreatedDto;
import com.moviesite.movieProject.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class MovieProjectApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAllUsers() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.get("/api/users")
	.accept(MediaType.APPLICATION_JSON))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testUserById() throws Exception{
		Long userId=2L;
		mockMvc.perform(MockMvcRequestBuilders.get("/api/user/{id}",userId)
		.accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());
		//.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}
	@Test
	public void testCreateUser() throws Exception{
		User user=new User();
		user.setId(85L);
		user.setUserName("ali4141");
		user.setFirstName("Ali");
		user.setLastName("bingöl");
		user.setPassword("157865");
		user.setMail("aliasfasfg@gmail.com");
		user.setUserRole(null);
		user.setRegistrationDate("aa");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(user)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
				//.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}


	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}



}
