package com.StockMarketCharting.CompanyService.service;

import com.StockMarketCharting.CompanyService.model.Company;
import com.StockMarketCharting.CompanyService.shared.CompanyResponse;

public interface CompanyService {
	public Company addNewCompany(Company company);
	public Iterable<CompanyResponse> findAllCompany();
	public CompanyResponse findByCompanyId(Integer companyId);
	public CompanyResponse findByCompanyName(String companyName);
}
