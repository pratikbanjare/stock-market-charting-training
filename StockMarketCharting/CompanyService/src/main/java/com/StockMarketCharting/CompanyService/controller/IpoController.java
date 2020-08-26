package com.StockMarketCharting.CompanyService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StockMarketCharting.CompanyService.model.IpoDetail;
import com.StockMarketCharting.CompanyService.service.IpoService;

@RestController
@RequestMapping("/api")
public class IpoController {

	private IpoService ipoService;

	public IpoController(IpoService ipoService) {
		super();
		this.ipoService = ipoService;
	}
	
	@GetMapping("/ipos")
	public ResponseEntity<Iterable<IpoDetail>> findAllIpos(){
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(ipoService.findAllIpos());
	}
	
	@GetMapping("/ipos/company_name/{companyName}")
	public ResponseEntity<Iterable<IpoDetail>> findByCompanyName(@PathVariable String companyName){
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(ipoService.findIpoByCompanyName(companyName));
	}
	
	@GetMapping("/ipos/exchange/{exchange}")
	public ResponseEntity<Iterable<IpoDetail>> findByExchange(@PathVariable String exchange){
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(ipoService.findIpoByExchange(exchange));
	}
	
	@PostMapping("/ipos")
	public ResponseEntity<IpoDetail> addNewIpo(@RequestBody IpoDetail ipoDetail){
		return ResponseEntity.
				status(HttpStatus.CREATED).
				body(ipoService.addIpo(ipoDetail));
	}
}
