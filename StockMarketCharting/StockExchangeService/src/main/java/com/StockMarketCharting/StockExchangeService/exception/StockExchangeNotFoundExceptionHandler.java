package com.StockMarketCharting.StockExchangeService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StockExchangeNotFoundExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StockExchangeErrorResponse> handleException(StockExchangeNotFoundException exception)
	{
		StockExchangeErrorResponse errorResponse = new StockExchangeErrorResponse(
												exception.getMessage(),
												HttpStatus.NOT_FOUND.value(),
												System.currentTimeMillis()
												);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
