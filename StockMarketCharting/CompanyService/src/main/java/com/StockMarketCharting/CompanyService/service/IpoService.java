package com.StockMarketCharting.CompanyService.service;

import java.util.Optional;

import com.StockMarketCharting.CompanyService.model.IpoDetail;
import com.StockMarketCharting.CompanyService.shared.IpoRequest;

public interface IpoService {
	
	public Iterable<IpoDetail> findAllIpos();
	public Optional<IpoDetail> findIpoById(Integer ipoId);
	public Iterable<IpoDetail> findIpoByCompanyId(Integer companyId);
	public Iterable<IpoDetail> findIpoByExchange(String exchange);
	public IpoDetail addIpo(IpoRequest ipo);
}
