package com.ty.car_rental_app_sping_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.car_rental_app_sping_boot.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	
}
