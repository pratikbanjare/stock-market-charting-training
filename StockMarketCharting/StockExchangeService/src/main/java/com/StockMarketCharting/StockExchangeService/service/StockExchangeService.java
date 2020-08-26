package com.StockMarketCharting.StockExchangeService.service;

import java.util.Optional;

import com.StockMarketCharting.StockExchangeService.model.StockExchange;

public interface StockExchangeService {
	
	public Iterable<StockExchange> findAllStockExchanges();
	public Optional<StockExchange> findStockExchangeById(Integer stockExchangeId);
	public Optional<StockExchange> findStockExchangeByName(String stockExchangeName);
	public StockExchange addStockExchange(StockExchange stockExchange);

}
