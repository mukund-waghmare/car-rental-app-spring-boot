package com.ty.car_rental_app_sping_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.car_rental_app_sping_boot.dto.Booking;
import com.ty.car_rental_app_sping_boot.repository.BookingRepository;

@Repository
public class BookingDao {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public Booking findBookingById(int id)
	{
		Optional<Booking> bookingobj=bookingRepository.findById(id);
		if(bookingobj.isPresent())
		{
			return bookingobj.get();
		}
		else
		{
			return null;
		}
	}
	
	public Booking saveBooking(Booking booking)
	{
		Booking bookingobj=bookingRepository.save(booking);
		return bookingobj;
	}
	

}
