package com.StockMarketCharting.CompanyService.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.StockMarketCharting.CompanyService.CompanyServiceApplication;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = CompanyServiceApplication.class )
//@WebMvcTest(IpoController.class)
public class IpoControllerTest {
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void shoudlFindAllIpos () throws Exception {		
		this.mockMvc.perform(MockMvcRequestBuilders.get( "/api/ipos" ).accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect( jsonPath("$",hasSize(1)) )
		.andReturn();
	}
	
	@Test
	public void shouldFindByExchangeName () throws Exception {
		this.mockMvc.perform( MockMvcRequestBuilders.get( "/api/ipos/exchange/BSE" )
				.accept(MediaType.APPLICATION_JSON))
		.andDo( print() )
		.andExpect( jsonPath("$",hasSize(1)) )
		.andReturn();
	}
	//@Test
	public void shouldAddNewIpo () throws Exception {
		this.mockMvc.perform( MockMvcRequestBuilders.post( "/api/ipos" )
				.contentType(MediaType.APPLICATION_JSON)
				.content( "{ \"ipoId\":3, \"exchange\":\"NSE\", \"sharePrice\": 90.0,"
						+ "\"numberOfShares\":1000.0, \"openTime\": $now(), \"companyId\":1 }" )
				.accept( MediaType.APPLICATION_JSON ))
		.andDo(print())
		.andExpect( jsonPath( "$.exchange" ).exists() )
		.andReturn();
	}
}
