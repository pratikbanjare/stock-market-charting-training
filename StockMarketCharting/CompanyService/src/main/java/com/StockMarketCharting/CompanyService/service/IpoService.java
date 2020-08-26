package com.StockMarketCharting.CompanyService.service;

import java.util.Optional;

import com.StockMarketCharting.CompanyService.model.IpoDetail;

public interface IpoService {
	
	public Iterable<IpoDetail> findAllIpos();
	public Optional<IpoDetail> findIpoById(Integer ipoId);
	public Iterable<IpoDetail> findIpoByCompanyName(String companyName);
	public Iterable<IpoDetail> findIpoByExchange(String exchange);
	public IpoDetail addIpo(IpoDetail ipo);

}
