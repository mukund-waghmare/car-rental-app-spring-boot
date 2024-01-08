package com.ty.car_rental_app_sping_boot.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Car {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	
	private String brand;
	
	private Availability carAvailabilityStatus;
	
	private String carNumber;
	
	private String carType;
	
	private String fuelType;
	
	private double mileage;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private String carModel;
	
	private int numberOfSeats;
	
	@ManyToMany
    @JsonIgnore
	List<User> users;
	
	@OneToOne
	Booking booking;


	
//-----------getters And Setters-------------------------------------------------------------------------------------------------------------
	
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Availability getCarAvailabilityStatus() {
		return carAvailabilityStatus;
	}

	public void setCarAvailabilityStatus(Availability carAvailabilityStatus) {
		this.carAvailabilityStatus = carAvailabilityStatus;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public List<User> getUser() {
		return users;
	}

	public void setUser(List<User> user) {
		this.users = user;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
	

}
