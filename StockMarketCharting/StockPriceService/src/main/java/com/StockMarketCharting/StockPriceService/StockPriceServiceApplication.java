package com.StockMarketCharting.StockPriceService;



import java.sql.Time;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.StockMarketCharting.StockPriceService.dao.StockPricingDao;
import com.StockMarketCharting.StockPriceService.model.StockPrice;

@SpringBootApplication
@EnableEurekaClient
public class StockPriceServiceApplication implements CommandLineRunner{

	@Autowired
	private StockPricingDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(StockPriceServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dao.save( new StockPrice( 1,"15IM30015", "ISE", 100.0, 
				new Date(), new Time( System.currentTimeMillis() )  ) );
		
	}

}
