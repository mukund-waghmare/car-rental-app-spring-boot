package com.ty.car_rental_app_sping_boot.exception;

import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CarException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BrandNotFound.class)
    public ResponseEntity<ResponseStructure<String>> brandNotFoundHandler(BrandNotFound exception)
    {
        ResponseStructure<String > responseStructure= new ResponseStructure<String>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(exception.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseStructure<String>> carTypeNotFoundException(CarTypeNotFoundException exception)
    {
        ResponseStructure<String > responseStructure= new ResponseStructure<String>();

        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(exception.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FuelTypeNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> fuelTypeNotFoundExceptionHandler(FuelTypeNotFoundException exception)
    {
        ResponseStructure<String > responseStructure= new ResponseStructure<String>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(exception.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MileageNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> mileageNotFoundExceptionHandler(MileageNotFoundException exception)
    {
        ResponseStructure<String > responseStructure= new ResponseStructure<String>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(exception.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoOfSeatsNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> noOfSeatsFoundException(NoOfSeatsNotFoundException exception)
    {
        ResponseStructure<String > responseStructure= new ResponseStructure<String>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(exception.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ModelNotException.class)
    public ResponseEntity<ResponseStructure<String>> modelNotFoundExceptionHandler(ModelNotException exception)
    {
        ResponseStructure<String > responseStructure= new ResponseStructure<String>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(exception.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
    }
}
