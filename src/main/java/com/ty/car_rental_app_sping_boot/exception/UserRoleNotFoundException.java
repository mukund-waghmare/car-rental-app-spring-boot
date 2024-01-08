package com.ty.car_rental_app_sping_boot.exception;

public class UserRoleNotFoundException extends RuntimeException {
	
	
	String message;
	
	public UserRoleNotFoundException() {
		// TODO Auto-generated constructor stub

	}
	
	public UserRoleNotFoundException(String message) {
		
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
