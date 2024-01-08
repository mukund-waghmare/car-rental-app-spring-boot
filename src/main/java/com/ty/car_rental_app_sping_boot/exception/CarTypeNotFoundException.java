package com.ty.car_rental_app_sping_boot.exception;

public class CarTypeNotFoundException extends RuntimeException{
    public CarTypeNotFoundException(String message) {
        super(message);
    }
}

