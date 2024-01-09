package com.ty.car_rental_app_sping_boot.exception;

public class BookingUnsuccessfullException extends RuntimeException{
	
private String message;
	
	public BookingUnsuccessfullException() {
		
	}
	
	public BookingUnsuccessfullException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}

}
