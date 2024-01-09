package com.ty.car_rental_app_sping_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.car_rental_app_sping_boot.dao.BookingDao;
import com.ty.car_rental_app_sping_boot.dao.PaymentDao;
import com.ty.car_rental_app_sping_boot.dto.Booking;
import com.ty.car_rental_app_sping_boot.dto.BookingStatus;
import com.ty.car_rental_app_sping_boot.dto.Payment;
import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import com.ty.car_rental_app_sping_boot.exception.BookingIdNotFoundException;
import com.ty.car_rental_app_sping_boot.exception.FirstPayAdvanceException;
import com.ty.car_rental_app_sping_boot.exception.PaymentIdNotFoundException;

@Service
public class PaymentService {

	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	BookingDao bookingDao;
	

	public ResponseEntity<ResponseStructure<Payment>> bookingConfirmation(Payment payment, int bookingid){
		
		Booking booking=bookingDao.findBookingById(bookingid);
		if(booking!=null) {
			Payment payment2=paymentDao.savePayment(payment);
			booking.setPayment(payment2);
			booking.setBookingStatus(BookingStatus.Confirmed);
			
		ResponseStructure<Payment> structure=new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("payment created successfully");
		structure.setData(payment2);
		
		return new ResponseEntity<ResponseStructure<Payment>>(structure,HttpStatus.CREATED);
			
		}
		else {
			throw new BookingIdNotFoundException("booking id is invalid: " + bookingid);
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Payment>> payTotalAmount(int bookingid, double endingMeter,double costPerDay){
		
		Payment payment=paymentDao.getPayment(bookingid);
		double totalCost=0;
		if(payment!=null) {
			Booking booking=bookingDao.findBookingById(bookingid);
			if(booking!=null) {
				booking.setEndingMeterReading(endingMeter);
				double startMeter=booking.getStartingMeterReading();
				double exceedTime=endingMeter-startMeter;
				double duration =booking.getDuration();
				double exceedCharge=booking.getExtraChargesPerKilometer();
				totalCost=totalCost+duration*costPerDay+exceedTime*exceedCharge-payment.getTotalCost();
				payment.setTotalCost(totalCost);
				
				Payment updatedPayment=paymentDao.updatePayment(payment);
				booking.setPayment(updatedPayment);
				
				
			}
			else {
				throw new BookingIdNotFoundException();
			}
		}
		else {
			throw new FirstPayAdvanceException("first pay advance for the booking");
		}
	}
	
	public ResponseEntity<ResponseStructure<Payment>> findById(int pid){
		
		Payment payment=paymentDao.findById(pid);
		if(payment!=null) {
			ResponseStructure<Payment> structure=new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("payment found successfully");
			structure.setData(payment);
			
			return new ResponseEntity<ResponseStructure<Payment>>(structure,HttpStatus.OK);
		}
		else {
			throw new PaymentIdNotFoundException("invalid payment Id: " + pid);
		}
	}
	
}
