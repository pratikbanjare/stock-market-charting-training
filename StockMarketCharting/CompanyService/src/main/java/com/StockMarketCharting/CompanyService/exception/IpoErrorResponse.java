package com.StockMarketCharting.CompanyService.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IpoErrorResponse {
	
	private String errorMessage;
	private int statusCode;
	private long exceptionTime;

}
