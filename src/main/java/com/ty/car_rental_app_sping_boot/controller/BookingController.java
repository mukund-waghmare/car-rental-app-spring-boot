package com.ty.car_rental_app_sping_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.car_rental_app_sping_boot.dto.Booking;
import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import com.ty.car_rental_app_sping_boot.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/savebookingbybrand/{brand}/{id}")
    public ResponseEntity<ResponseStructure<Booking>> saveBookingByBrand(@RequestBody Booking booking,@PathVariable String brand, @PathVariable int id) {
        return bookingService.saveBookingByBrand(booking,brand,id);
    }
	
	@PostMapping("/savebookingbycartype/{carType}/{id}")
    public ResponseEntity<ResponseStructure<Booking>> saveBookingByCarType(@RequestBody Booking booking,@PathVariable String carType, @PathVariable int id) {
        return bookingService.saveBookingByCarType(booking,carType,id);
    }
	
	@PostMapping("/savebookingbycarseats/{seats}/{id}")
    public ResponseEntity<ResponseStructure<Booking>> saveBookingByCarSeats(@RequestBody Booking booking,@PathVariable int seats, @PathVariable int id) {
        return bookingService.saveBookingByCarSeats(booking,seats,id);
    }
	
	@PostMapping("/updatebooking/{pickuploc}/{droploc}/{id}/{bid}")
    public ResponseEntity<ResponseStructure<Booking>> UpdateLocationsById(@PathVariable String pickuploc,@PathVariable String droploc,@PathVariable int id,@PathVariable int bid) {
        return bookingService.UpdateLocationsById(pickuploc,droploc,id,bid);
    }

}
