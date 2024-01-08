package com.ty.car_rental_app_sping_boot.exception;

public class UserIdNotFoundException extends RuntimeException {

	String message;
	
	public UserIdNotFoundException() {
		// TODO Auto-generated constructor stub

	}
	
	public UserIdNotFoundException(String message) {
		
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
		
}

