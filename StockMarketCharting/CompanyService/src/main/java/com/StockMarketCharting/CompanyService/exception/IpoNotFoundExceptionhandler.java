package com.StockMarketCharting.CompanyService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IpoNotFoundExceptionhandler {
	
	public ResponseEntity<IpoErrorResponse> handleException (IpoNotFoundException infe){
		IpoErrorResponse errorResponse = new IpoErrorResponse(infe.getMessage(), 
											HttpStatus.NOT_FOUND.value(), 
											System.currentTimeMillis());
		
		return new ResponseEntity <>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
