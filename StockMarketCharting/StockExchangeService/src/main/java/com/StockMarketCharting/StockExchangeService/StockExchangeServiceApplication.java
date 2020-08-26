package com.StockMarketCharting.StockExchangeService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.StockMarketCharting.StockExchangeService.dao.StockExchangeDao;
import com.StockMarketCharting.StockExchangeService.model.StockExchange;

@SpringBootApplication
public class StockExchangeServiceApplication implements CommandLineRunner{

	private StockExchangeDao dao;
	
	public StockExchangeServiceApplication(StockExchangeDao dao) {
		super();
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(StockExchangeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dao.save(new StockExchange( 1,"BSE", "Welcome to british stock exchange" ,"Londom", "helpful"  ));
		dao.save(new StockExchange( 2,"NSE", "Welcome to newyork stock exchange" ,"NewYork", "helpful"  ));
	}

}
