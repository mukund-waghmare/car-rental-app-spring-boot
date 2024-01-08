package com.ty.car_rental_app_sping_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.car_rental_app_sping_boot.dto.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
