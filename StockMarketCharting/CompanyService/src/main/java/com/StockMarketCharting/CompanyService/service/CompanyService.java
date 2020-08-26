package com.StockMarketCharting.CompanyService.service;

import java.util.Optional;

import com.StockMarketCharting.CompanyService.model.Company;

public interface CompanyService {
	public Iterable<Company> findAllCompany();
	public Optional<Company> findCompanyById(Integer companyId);
	public Company addNewCompany(Company company);
}
