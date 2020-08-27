package com.StockMarketCharting.StockExchangeService.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StockMarketCharting.StockExchangeService.exception.StockExchangeNotFoundException;
import com.StockMarketCharting.StockExchangeService.model.StockExchange;
import com.StockMarketCharting.StockExchangeService.service.StockExchangeService;

@RestController
@RequestMapping("/api")
public class StockExchangeController {

	private StockExchangeService exchangeService;

	public StockExchangeController(StockExchangeService exchangeService) {
		super();
		this.exchangeService = exchangeService;
	}  
	
	@GetMapping("/exchange")
	public ResponseEntity<Iterable<StockExchange>> findAllStockExchange() throws StockExchangeNotFoundException{
		Iterable<StockExchange> exchanges = exchangeService.findAllStockExchanges();
		if (exchanges == null)
			throw new StockExchangeNotFoundException("No Stock Exchange in database");
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(exchanges);
	}
	
	@GetMapping("/exchange/id/{exchangeId}")
	public ResponseEntity<Optional<StockExchange>> findByExchangeId(@PathVariable Integer exchangeId) throws StockExchangeNotFoundException
	{
		Optional<StockExchange> exchange = exchangeService.findStockExchangeById(exchangeId);
		if (!exchange.isPresent())
		{
			throw new StockExchangeNotFoundException("Stock Exchange not fount with id " + exchangeId ); 
		}
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(exchange);
	}
	
	@GetMapping("/exchange/name/{exchangeName}")
	public ResponseEntity<Optional<StockExchange>> findByExchangeName(@PathVariable String exchangeName) throws StockExchangeNotFoundException
	{
		Optional<StockExchange> exchange = exchangeService.findStockExchangeByName(exchangeName);
		if (!exchange.isPresent())
		{
			throw new StockExchangeNotFoundException("Stock Exchange not found with name "+exchangeName);
		}
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(exchange);
	}
	
	@PostMapping("/exchange")
	public ResponseEntity<StockExchange> addExchange(@RequestBody StockExchange exchange)
	{
		return ResponseEntity.
				status(HttpStatus.CREATED).
				body(exchangeService.addStockExchange(exchange));
	}
	
	@DeleteMapping("/exchange/id/{exchangeId}")
	public ResponseEntity<String> deleteExchnageById(@PathVariable Integer exchangeId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(exchangeService.deleteStockExchangeById(exchangeId));
	}
	
}
