package com.StockMarketCharting.StockExchangeService.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.StockMarketCharting.StockExchangeService.dao.StockExchangeDao;
import com.StockMarketCharting.StockExchangeService.model.StockExchange;

@Service
public class StockExchangeServiceImpl implements StockExchangeService{

	private StockExchangeDao stockExchangeDao;
	
	public StockExchangeServiceImpl(StockExchangeDao stockExchangeDao) {
		super();
		this.stockExchangeDao = stockExchangeDao;
	}

	@Override
	public Iterable<StockExchange> findAllStockExchanges() {
		return stockExchangeDao.findAll();
	}

	@Override
	public Optional<StockExchange> findStockExchangeById(Integer stockExchangeId) {
		return stockExchangeDao.findById(stockExchangeId);
	}

	@Override
	public Optional<StockExchange> findStockExchangeByName(String stockExchangeName) {
		return stockExchangeDao.findByStockName(stockExchangeName);
	}

	@Override
	public StockExchange addStockExchange(StockExchange stockExchange) {
		return stockExchangeDao.save(stockExchange);
	}

	@Override
	public String deleteStockExchangeById(Integer exchangeId) {
		if (!stockExchangeDao.findById(exchangeId).isPresent())
			return "No stock Sechange exist with id "+ exchangeId;
		stockExchangeDao.deleteById(exchangeId);
		return "Deleted Stock Exchange with id "+exchangeId;
		
	}
	

}
