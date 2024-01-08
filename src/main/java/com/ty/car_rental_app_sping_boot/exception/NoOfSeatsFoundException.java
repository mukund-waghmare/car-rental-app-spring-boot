package com.ty.car_rental_app_sping_boot.exception;

public class NoOfSeatsFoundException extends RuntimeException{
    public NoOfSeatsFoundException(String message) {
        super(message);
    }
}
