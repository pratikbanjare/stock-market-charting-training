package com.StockMarketCharting.StockPriceService.service;

import java.sql.Date;

import com.StockMarketCharting.StockPriceService.model.StockPrice;

public interface StockPriceService {
	public Iterable<StockPrice> findByCompanyCode(String companyCode);
	public Iterable<StockPrice> findByExchange(String exchange);
	public Iterable<StockPrice> findByDate(Date date);
	public Iterable<StockPrice> findAll();
	public StockPrice addStockPrice(StockPrice priceEntity);

}
