package com.StockMarketCharting.StockExchangeService.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.StockMarketCharting.StockExchangeService.model.StockExchange;

@Repository
public interface StockExchangeDao extends JpaRepository<StockExchange, Integer>{

	@Query(value = "select * from stock_exchange s where s.stock_exchange_name = ?1", nativeQuery = true)
	Optional<StockExchange> findByStockName(String stockExchangeName);

}
