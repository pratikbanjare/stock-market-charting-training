package com.StockMarketCharting.CompanyService.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.StockMarketCharting.CompanyService.dao.CompanyDao;
import com.StockMarketCharting.CompanyService.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService{

	private CompanyDao companyDao;

	public CompanyServiceImpl(CompanyDao companyDao) {
		super();
		this.companyDao = companyDao;
	}
	
	@Override
	@Transactional
	public Iterable<Company> findAllCompany(){
		return companyDao.findAll();
	}

	@Override
	@Transactional
	public Company addNewCompany(Company company) {
		return companyDao.save(company);
	}

	@Override
	public Optional<Company> findCompanyById(Integer companyId) {
		return companyDao.findById(companyId);
	}
}
