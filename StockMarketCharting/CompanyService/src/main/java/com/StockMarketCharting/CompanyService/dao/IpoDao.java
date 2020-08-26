package com.StockMarketCharting.CompanyService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.StockMarketCharting.CompanyService.model.IpoDetail;

@Repository
public interface IpoDao extends JpaRepository<IpoDetail, Integer>{

	@Query(value = "select * from ipo_detail d where d.exchange = ?1", nativeQuery = true)
	Iterable<IpoDetail> findByExchange(String exchange);
	@Query(value = "select * from ipo_detail d where d.company_name = ?1", nativeQuery = true)
	Iterable<IpoDetail> findbyCompanyName(String companyName);

}
