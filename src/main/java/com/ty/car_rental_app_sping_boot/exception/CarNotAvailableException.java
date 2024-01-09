package com.ty.car_rental_app_sping_boot.exception;

public class CarNotAvailableException extends RuntimeException{

private String message;
	
	public CarNotAvailableException() {	
}

	public CarNotAvailableException(String message) {
	this.message=message;
}
	
	@Override
	public String getMessage() {
		
		return message;
	}
}
