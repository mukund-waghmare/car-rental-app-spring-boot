package com.ty.car_rental_app_sping_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.car_rental_app_sping_boot.dto.Payment;
import com.ty.car_rental_app_sping_boot.repository.PaymentRepository;

@Repository
public class PaymentDao {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	
	public Payment savePayment(Payment payment) {
	    
		return paymentRepository.save(payment);
		
	}
	
	public Payment updatePayment(Payment payment) {
		
		return paymentRepository.save(payment);
	}
	
	public Payment getPayment(int bookingId) {
		
		return paymentRepository.getPayment(bookingId);
	}
	
	public Payment findById(int id) {
		Optional<Payment> optional=paymentRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
}
