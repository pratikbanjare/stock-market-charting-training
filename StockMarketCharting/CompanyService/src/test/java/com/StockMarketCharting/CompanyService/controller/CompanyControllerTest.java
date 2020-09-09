package com.StockMarketCharting.CompanyService.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;

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
import com.StockMarketCharting.CompanyService.model.Director;
import com.StockMarketCharting.CompanyService.service.CompanyServiceImpl;
import com.StockMarketCharting.CompanyService.shared.CompanyResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CompanyServiceApplication.class)
public class CompanyControllerTest {

	
	private MockMvc mockMvc;
	@Autowired
	private CompanyServiceImpl serviceImpl;
	
	@Autowired
	private WebApplicationContext wac;
	
	private CompanyResponse cr = new CompanyResponse ( 1, "Dianoia",100000L,"shw", "abrakadabra" , "IN001",Arrays.asList(new Director(2,"raghu")) );
	
	@Before
	public void setUp () {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void test_service_notNull () {
		assertNotNull(serviceImpl);
	}
	
	@Test
	public void shouldFetchAllCompany () throws Exception{		
		this.mockMvc.perform( MockMvcRequestBuilders.get("/api/company").accept(MediaType.APPLICATION_JSON) )
		.andDo(print())
		.andExpect( jsonPath("$", hasSize(1) ) )
		.andReturn();
	}
	
	@Test
	public void shouldFindByCompanyName() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get( "/api/company/name/Dianoia" )
		.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect( jsonPath( "$.companyName").value("Dianoia") ) 
		.andReturn();
	}
	
	@Test
	public void shouldAddCompany () throws Exception {
		this.mockMvc.perform( MockMvcRequestBuilders.post( "/api/company" ).contentType(MediaType.APPLICATION_JSON)
				.content( "{ \"companyName\":\"royal\" , \"turnover\":100000,\"writeup\":\"creed\" }" )
				.accept(MediaType.APPLICATION_JSON))
		.andDo( print() )
		.andExpect( jsonPath ("$.companyName").value( "royal" ) )
		.andReturn();		
	}
	
}
