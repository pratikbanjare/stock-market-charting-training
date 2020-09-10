package com.StockMarketCharting.StockPriceService.model;


import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="stock_price")
public class StockPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "company_code")
	private String companyCode;
	
	@Column(name = "exchange")
	private String exchange;
	
	@Column(name = "current_price")
	private double currentPrice;
	
	@Column(name = "pricing_date")
	private Date priceDate;
	
	@Column(name = "pricing_time")
	private Time priceTime;

	public StockPrice(int id, String companyCode, String exchange, double currentPrice, Date priceDate,
			Time priceTime) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.exchange = exchange;
		this.currentPrice = currentPrice;
		this.priceDate = priceDate;
		this.priceTime = priceTime;
	}

	
	
}
