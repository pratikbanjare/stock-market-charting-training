package com.StockMarketCharting.CompanyService.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.StockMarketCharting.CompanyService.dao.IpoDao;
import com.StockMarketCharting.CompanyService.model.IpoDetail;

@Service
public class IpoServiceImpl implements IpoService{
	
	private IpoDao ipoDao;

	public IpoServiceImpl(IpoDao ipoDao) {
		super();
		this.ipoDao = ipoDao;
	}

	@Override
	@Transactional
	public Iterable<IpoDetail> findAllIpos() {
		return ipoDao.findAll();
	}

	@Override
	@Transactional
	public Optional<IpoDetail> findIpoById(Integer ipoId) {
		return ipoDao.findById(ipoId);
	}

	@Override
	@Transactional
	public Iterable<IpoDetail> findIpoByCompanyName(String companyName) {
		return ipoDao.findbyCompanyName(companyName);
	}

	@Override
	@Transactional
	public Iterable<IpoDetail> findIpoByExchange(String exchange) {
		return ipoDao.findByExchange(exchange);
	}

	@Override
	@Transactional
	public IpoDetail addIpo(IpoDetail ipo) {
		return ipoDao.save(ipo);
	}	
}
