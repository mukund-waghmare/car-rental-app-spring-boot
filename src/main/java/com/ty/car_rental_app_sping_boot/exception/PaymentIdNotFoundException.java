package com.ty.car_rental_app_sping_boot.exception;

public class PaymentIdNotFoundException extends RuntimeException {

	private String message;
	
	public PaymentIdNotFoundException() {
		
	}
	
	public PaymentIdNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}
}
