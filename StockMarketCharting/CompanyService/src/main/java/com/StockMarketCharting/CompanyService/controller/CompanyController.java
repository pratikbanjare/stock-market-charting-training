package com.StockMarketCharting.CompanyService.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StockMarketCharting.CompanyService.model.Company;
import com.StockMarketCharting.CompanyService.service.CompanyService;

@RestController
@RequestMapping("/api")
public class CompanyController {
	
	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@GetMapping("/company")
	public ResponseEntity<Iterable<Company>> findAllCompany()
	{
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(companyService.findAllCompany());
				
	}
	
	@PostMapping("/company/save")
	public ResponseEntity<Company> addNewCompany(@RequestBody Company company)
	{
		return ResponseEntity.
				status(HttpStatus.CREATED).
				body(companyService.addNewCompany(company));
	}
	
	@GetMapping("/company/{companyId")
	public ResponseEntity<Optional<Company>> findCompanyById(@PathParam("companyId") Integer companyId)
	{
		return ResponseEntity.
				status(HttpStatus.FOUND).
				body(companyService.findCompanyById(companyId));
	}

}
