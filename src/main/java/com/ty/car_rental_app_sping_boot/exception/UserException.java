package com.ty.car_rental_app_sping_boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;

@ControllerAdvice
public class UserException {
	
	
	
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(UserIdNotFoundException exception)
	{
		ResponseStructure<String > responseStructure= new ResponseStructure<String>();
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("User DoesNot Exist For Given Id");
		
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(InvalidUserCredentials.class)
	public ResponseEntity<ResponseStructure<String>> loginFailedException(InvalidUserCredentials exception)
	{
	ResponseStructure<String > responseStructure= new ResponseStructure<String>();
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Invalid User Credentials");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	
		
	}
	
	@ExceptionHandler(UserRoleNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> loginFailedException(UserRoleNotFoundException exception)
	{
	ResponseStructure<String > responseStructure= new ResponseStructure<String>();
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("User DoesNot Exist For Given Role");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	
		
	}

}
