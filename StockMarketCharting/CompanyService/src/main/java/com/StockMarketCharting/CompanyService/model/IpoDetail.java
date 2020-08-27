package com.StockMarketCharting.CompanyService.model;

import java.sql.Timestamp;

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
@AllArgsConstructor
@Table(name = "ipo_detail")
public class IpoDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ipo_id")
	private Integer ipoId;
	
	@Column(name = "exchange")
	private String exchange;
	
	@Column(name = "share_price")
	private double sharePrice;
	
	@Column(name = "number_of_shares")
	private double numberOfShares;
	
	@Column(name = "open_time")
	private Timestamp openTime;
}
