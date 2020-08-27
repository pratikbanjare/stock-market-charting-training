package com.StockMarketCharting.CompanyService.shared;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IpoRequest {
	private Integer ipoId;
	
	private String exchange;
	
	private double sharePrice;

	private double numberOfShares;
	
	private Timestamp openTime;
	
	private Integer companyId;
}
