package com.ty.car_rental_app_sping_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.car_rental_app_sping_boot.dto.Payment;
import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import com.ty.car_rental_app_sping_boot.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/save-payment/{bookingId}")
	public ResponseEntity<ResponseStructure<Payment>> SavePayment(@RequestBody Payment payment, @PathVariable int bookingId){
		
		return paymentService.bookingConfirmation(payment, bookingId);
	}
	
	@GetMapping("/total-payment/bookingid/{bookingId}/endingmeter/{endingMeter}/costPerDay/{costPerDay}")
	public ResponseEntity<ResponseStructure<Payment>> TotalPayment( @PathVariable int bookingId, @PathVariable double endingMeter,@PathVariable double costPerDay){
		
		return paymentService.payTotalAmount(bookingId, endingMeter, costPerDay);
	}
	
	@GetMapping("/total-payment/bookingid/{paymentId}")
	public ResponseEntity<ResponseStructure<Payment>> TotalPayment( @PathVariable int paymentId){
		
		return paymentService.findById(paymentId);
	}
}
