package com.ty.car_rental_app_sping_boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;

@RestControllerAdvice
public class BookingException   {

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> bookingIdNotFoundException(BookingIdNotFoundException  exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());
		structure.setData("not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
