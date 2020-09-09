package com.StockMarketCharting.StockPriceService.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.StockMarketCharting.StockPriceService.model.StockPrice;

@Repository
public interface StockPricingDao extends JpaRepository<StockPrice, Integer>{
	
	@Query(value="select * from stock_price p where p.company_code = ?1",nativeQuery = true)
	public Iterable<StockPrice> findByCompanyCode(String companyCode);
	
	@Query(value="select * from stock_price p where p.exchange = ?1",nativeQuery = true)
	public Iterable<StockPrice> findByExchange(String exchange);
	
	@Query(value="select * from stock_price p where p.date = ?1",nativeQuery = true)
	public Iterable<StockPrice> findByDate(Date date);

}
