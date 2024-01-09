
 package com.ty.car_rental_app_sping_boot.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	private BookingStatus bookingStatus;
	
	private String pickUpLocation;
	
	private String dropLocation;
	
	private double duration;
	
	private double startingMeterReading;
	
	private double endingMeterReading;
	
	@CreationTimestamp
	private LocalDateTime startDate;
	
	@UpdateTimestamp
	private LocalDateTime endDate;
	
	private double extraChargesPerKilometer;
	
	@JsonIgnore
	@OneToOne
	private Car car;
	
	@JsonIgnore
	@OneToOne
	Payment payment;



//----getters And Setters----------------------------------------------------------------------------------------

	
	
	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


	public String getPickUpLocation() {
		return pickUpLocation;
	}


	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}


	public String getDropLocation() {
		return dropLocation;
	}


	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}


	public double getDuration() {
		return duration;
	}


	public void setDuration(double duration) {
		this.duration = duration;
	}


	public double getStartingMeterReading() {
		return startingMeterReading;
	}


	public void setStartingMeterReading(double startingMeterReading) {
		this.startingMeterReading = startingMeterReading;
	}


	public double getEndingMeterReading() {
		return endingMeterReading;
	}


	public void setEndingMeterReading(double endingMeterReading) {
		this.endingMeterReading = endingMeterReading;
	}


	public LocalDateTime getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}


	public LocalDateTime getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	public double getExtraChargesPerKilometer() {
		return extraChargesPerKilometer;
	}


	public void setExtraChargesPerKilometer(double extraChargesPerKilometer) {
		this.extraChargesPerKilometer = extraChargesPerKilometer;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
	
	

}
