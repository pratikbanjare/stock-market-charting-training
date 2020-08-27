package com.StockMarketCharting.StockExchangeService.exception;

public class StockExchangeNotFoundException extends Throwable{
	private String message;

	public StockExchangeNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
