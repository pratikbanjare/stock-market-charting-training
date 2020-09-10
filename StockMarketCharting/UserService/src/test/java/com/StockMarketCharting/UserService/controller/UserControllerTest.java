package com.StockMarketCharting.UserService.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.StockMarketCharting.UserService.UserServiceApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UserServiceApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); 
	}
	
	@Test
	public void shouldFethAllMember() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.get("/api/users")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(jsonPath("$",hasSize(1))).andReturn();			
	}
	
	@Test
	public void shouldFindUserById() throws Exception{
		this.mockMvc.perform(
				MockMvcRequestBuilders.get("/api/users/id/1")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(jsonPath("$.userId").exists()).andExpect(jsonPath("$.userId").value(1))
		.andExpect(jsonPath("$.username").exists()).andExpect(jsonPath("$.username").value("pratik"))
		.andReturn();
			
	}
	
	@Test
	public void shouldFindUserByName() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users/name/pratik")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(jsonPath("$.userId").exists()).andExpect(jsonPath("$.userId").value(1))
		.andExpect(jsonPath("$.username").exists()).andExpect(jsonPath("$.username").value("pratik"))
		.andReturn();
		
	}
	
	
	public void shouldUpdateUser() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.put("/api/users/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"userId\":1 \"username\":\"pratik\", \"userPassword\":\"rogue\", \"emailId\":\"pb@gm.co\", "
						+ "\"userType\":\"ADMIN\", \"mobileNumber\":\"1234567890\", \"confirmed\":true}")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(jsonPath("$.userPassword").exists())
		.andReturn();
		
	}
	
	
	public void shouldAddUser () throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"userId\":4, \"username\":\"vicky\", \"userPassword\":\"rambo\", \"emailId\":\"vc@gm.co\", "
						+ " \"userType:\"REGULAR\", \"mobileNumber\":\"1478523690\", \"confirmed\":true}")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(jsonPath("$.username").exists()).andExpect(jsonPath("$.username").value("vicky"))
		.andReturn();
				
	}
	
	
}

