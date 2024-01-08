package com.ty.car_rental_app_sping_boot.exception;

public class BookingIdNotFoundException extends RuntimeException {

	private String message;
	
	public BookingIdNotFoundException() {
		
	}
	
	public BookingIdNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}
}
