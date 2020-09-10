package com.StockMarketCharting.StockExchangeService.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.StockMarketCharting.StockExchangeService.StockExchangeServiceApplication;
import com.StockMarketCharting.StockExchangeService.dao.StockExchangeDao;
import com.StockMarketCharting.StockExchangeService.model.StockExchange;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = StockExchangeServiceApplication.class)
@SpringBootTest
public class ExchangeControllerTerst {
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	

	@Before
	public void setUp () {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void shouldFetchAllStocks () throws Exception{
		
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/exchange")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect( jsonPath("$",hasSize(3) ))
		.andReturn();
	}
	
	@Test
	public void ShouldFindById() throws Exception {
		
		
		this.mockMvc.perform( MockMvcRequestBuilders.get( "/api/exchange/id/1" ) 
				.accept(MediaType.APPLICATION_JSON))
		.andDo( print() )
		.andExpect( jsonPath("$.stockExchangeId").value(1) )
		
		.andReturn();
	}
	
	@Test 
	public void shouldFindByName () throws Exception {
		this.mockMvc.perform( MockMvcRequestBuilders.get( "/api/exchange/name/NSE" ) 
				.accept( MediaType.APPLICATION_JSON ))
		.andDo(print())
		.andExpect (jsonPath("$.stockExchangeName").value("NSE"))
		.andReturn();
	}
	
	@Test
	public void shouldAddExchange () throws Exception {
		this.mockMvc.perform( MockMvcRequestBuilders.post( "/api/exchange" ) 
				.contentType( MediaType.APPLICATION_JSON )
				.content( "{ \"stockExchangeName\":\"ISE\", \"brief\": \"indian system\","
						+ "\"address\": \"Mumbai\", \"remarks\": \"good\"  }" )
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect( jsonPath( "$.stockExchangeName" ).value("ISE"))
		.andReturn();
	}
}

