package com.StockMarketCharting.CompanyService.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.StockMarketCharting.CompanyService.dao.CompanyDao;
import com.StockMarketCharting.CompanyService.model.Company;
import com.StockMarketCharting.CompanyService.shared.CompanyResponse;

@Service
public class CompanyServiceImpl implements CompanyService{

	private CompanyDao companyDao;
	private ModelMapper modelMapper;
	public CompanyServiceImpl(CompanyDao companyDao, ModelMapper modelMapper) {
		super();
		this.companyDao = companyDao;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public Company addNewCompany(Company company) {
		return companyDao.save(company);
	}

	@Override
	@Transactional
	public Iterable<CompanyResponse> findAllCompany() {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type listType = new TypeToken<List<CompanyResponse>> () {}.getType();
		List<CompanyResponse> companyResponse = modelMapper.map(companyDao.findAll(), listType);
		return companyResponse;
	}
	@Override
	public CompanyResponse findByCompanyId(Integer companyId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type obj = new TypeToken<CompanyResponse> () {} .getType();
		CompanyResponse companyResponse;
		try {
			companyResponse = modelMapper.map(companyDao.findById(companyId).get(), obj);
		} catch (NoSuchElementException e) {
			companyResponse = null;
		}
		return companyResponse;
	}

	@Override
	public CompanyResponse findByCompanyName(String companyName) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Type obj = new TypeToken<CompanyResponse> () {} .getType();
		CompanyResponse companyResponse;
		try {
			companyResponse = modelMapper.map(companyDao.findByName(companyName).get(), obj);
		} catch (NoSuchElementException e) {
			companyResponse = null;
		}
		return companyResponse;
	}
	
		
	
}
