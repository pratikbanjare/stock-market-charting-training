package com.StockMarketCharting.StockExchangeService.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockExchangeErrorResponse {
	private String errorMessage;
	private int statusCode;
	private long exceptionTime;
}
