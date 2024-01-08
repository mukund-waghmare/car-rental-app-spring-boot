package com.ty.car_rental_app_sping_boot.exception;

public class InvalidUserCredentials extends RuntimeException {
	
	String message;
	
	public InvalidUserCredentials() {
		// TODO Auto-generated constructor stub

	}
	
	public InvalidUserCredentials(String message) {
		
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
