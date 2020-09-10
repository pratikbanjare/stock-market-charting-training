package com.StockMarketCharting.StockPriceService.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StockMarketCharting.StockPriceService.model.StockPrice;
import com.StockMarketCharting.StockPriceService.service.StockPriceService;

@RestController
@RequestMapping("/api")
public class StockPriceController {
	
	private StockPriceService priceService;

	public StockPriceController(StockPriceService priceService) {
		super();
		this.priceService = priceService;
	}
	
	@GetMapping("/stock_price/company_code/{companyCode}")
	public ResponseEntity<Iterable<StockPrice>> findByCompanyCode(@PathVariable String companyCode){
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(priceService.findByCompanyCode(companyCode));
	}
	
	@GetMapping("/stock_price/exchange/{exchange}")
	public ResponseEntity<Iterable<StockPrice>> findByExchange(@PathVariable String exchange){
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(priceService.findByExchange(exchange));
	}
	
	@GetMapping("/stock_price/price_date/{priceDate}")
	public ResponseEntity<Iterable<StockPrice>> findByDate(@PathVariable Date priceDate){
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(priceService.findByDate(priceDate));
	}
	
	@GetMapping("/stock_price")
	public ResponseEntity<Iterable<StockPrice>> findAll(){
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(priceService.findAll());
	}
	
	@PostMapping("/stock_price")
	public ResponseEntity<StockPrice> addStockPrice(@RequestBody StockPrice priceEntity){
		return ResponseEntity.
				status(HttpStatus.CREATED).
				body(priceService.addStockPrice(priceEntity));
	}

}
