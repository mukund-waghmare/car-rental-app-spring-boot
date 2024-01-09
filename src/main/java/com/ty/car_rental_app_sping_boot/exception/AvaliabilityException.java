package com.ty.car_rental_app_sping_boot.exception;

public class AvaliabilityException extends RuntimeException{

private String message;
	
	
	
	public AvaliabilityException() {
	
}


	public AvaliabilityException(String message) {
	this.message=message;
}
	
	@Override
	public String getMessage() {
		
		return message;
	}
}
