package com.StockMarketCharting.StockPriceService.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.StockMarketCharting.StockPriceService.dao.StockPricingDao;
import com.StockMarketCharting.StockPriceService.model.StockPrice;

@Service
public class StockPriceServiceImpl implements StockPriceService{

	private StockPricingDao stockDao;
		
	public StockPriceServiceImpl(StockPricingDao stockDao) {
		super();
		this.stockDao = stockDao;
	}

	@Override
	public Iterable<StockPrice> findByCompanyCode(String companyCode) {
		return stockDao.findByCompanyCode(companyCode);
	}

	@Override
	public Iterable<StockPrice> findByExchange(String exchange) {
		return stockDao.findByExchange(exchange);
	}

	@Override
	public Iterable<StockPrice> findByDate(Date date) {
		return stockDao.findByDate(date);
	}

	@Override
	public Iterable<StockPrice> findAll() {
		return stockDao.findAll();
	}

	@Override
	public StockPrice addStockPrice(StockPrice priceEntity) {
		return stockDao.save(priceEntity);
	}

}
