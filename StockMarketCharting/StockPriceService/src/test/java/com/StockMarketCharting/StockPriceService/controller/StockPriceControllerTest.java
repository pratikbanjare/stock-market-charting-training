package com.StockMarketCharting.StockPriceService.controller;

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

import com.StockMarketCharting.StockPriceService.StockPriceServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration( classes = StockPriceServiceApplication.class )
public class StockPriceControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp () {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void shouldFindAll() throws Exception {
		this.mockMvc.perform( MockMvcRequestBuilders.get( "/api/stock_price" )
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect( jsonPath ("$", hasSize(1)) )
		.andReturn();
	}
	
	@Test
	public void shouldFindByExchange () throws Exception {
		this.mockMvc.perform( MockMvcRequestBuilders.get( "/api/stock_price/exchange/ISE" )
				.accept( MediaType.APPLICATION_JSON ))
		.andDo( print() )
		.andExpect( jsonPath ("$", hasSize(1)) )
		.andReturn();
	}
	
	@Test
	public void shouldFindByCompanyCode () throws Exception {
		this.mockMvc.perform( MockMvcRequestBuilders.get( "/api/stock_price/company_code/15IM30015" )
				.accept( MediaType.APPLICATION_JSON ))
		.andDo( print() )
		.andExpect( jsonPath ("$", hasSize(1)) )
		.andReturn();
	}

	
	
}
