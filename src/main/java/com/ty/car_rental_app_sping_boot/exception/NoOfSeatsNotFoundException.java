package com.ty.car_rental_app_sping_boot.exception;

public class NoOfSeatsNotFoundException extends RuntimeException{
    public NoOfSeatsNotFoundException(String message) {
        super(message);
    }
}
