package com.ty.car_rental_app_sping_boot.exception;

public class FirstPayAdvanceException extends RuntimeException {

	
	private String message;
	
	public FirstPayAdvanceException() {
		
	}
	
	public FirstPayAdvanceException(String message) {
		this.message=message;
	}
	
	
	public String getMessage() {
		return message;
	}
}
