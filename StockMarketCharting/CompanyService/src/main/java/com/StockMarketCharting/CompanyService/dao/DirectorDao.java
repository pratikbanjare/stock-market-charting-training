package com.StockMarketCharting.CompanyService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StockMarketCharting.CompanyService.model.Director;

@Repository
public interface DirectorDao extends JpaRepository<Director, Integer>{

}
