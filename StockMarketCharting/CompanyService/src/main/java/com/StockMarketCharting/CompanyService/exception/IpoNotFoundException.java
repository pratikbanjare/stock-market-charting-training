package com.StockMarketCharting.CompanyService.exception;

public class IpoNotFoundException extends Throwable{
	
	private String message;

	public IpoNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	

}
