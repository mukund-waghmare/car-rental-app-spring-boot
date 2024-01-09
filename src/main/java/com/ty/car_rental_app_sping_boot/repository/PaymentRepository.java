package com.ty.car_rental_app_sping_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.car_rental_app_sping_boot.dto.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	@Query("select b.payment from Booking b where b.bookingId=?1")
	public Payment getPayment(int bid);
}
