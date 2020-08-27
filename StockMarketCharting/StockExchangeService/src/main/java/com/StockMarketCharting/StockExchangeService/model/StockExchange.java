package com.StockMarketCharting.StockExchangeService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockExchange {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stock_exchange_id")
	private Integer stockExchangeId;
	
	@Column(name="stock_exchange_name")
	private String stockExchangeName;
	
	@Column(name = "brief")
	private String brief;
	
	@Column(name="address")
	private String address;
	
	@Column(name="remarks")
	private String remarks;

}
