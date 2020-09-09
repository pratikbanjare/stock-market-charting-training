package com.StockMarketCharting.CompanyService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.StockMarketCharting.CompanyService.dao.CompanyDao;
import com.StockMarketCharting.CompanyService.dao.IpoDao;
import com.StockMarketCharting.CompanyService.model.Company;
import com.StockMarketCharting.CompanyService.model.IpoDetail;

@SpringBootApplication
@EnableEurekaClient
public class CompanyServiceApplication implements CommandLineRunner{

	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private IpoDao ipoDao;
	
	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		
		companyDao.save( new Company(1, "Dianoia",10000L, "shwet","innovation","IM30018" ) );
		ipoDao.save( new IpoDetail(1, "BSE", 100.0,300.0, new java.sql.Timestamp(System.currentTimeMillis()) ) );
		
	}

}
