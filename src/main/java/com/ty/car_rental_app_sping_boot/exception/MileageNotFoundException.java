package com.ty.car_rental_app_sping_boot.exception;

public class MileageNotFoundException extends RuntimeException{
    public MileageNotFoundException(String message) {
        super(message);
    }
}
