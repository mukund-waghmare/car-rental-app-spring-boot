package com.ty.car_rental_app_sping_boot.service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.car_rental_app_sping_boot.dao.BookingDao;
import com.ty.car_rental_app_sping_boot.dao.CarDao;
import com.ty.car_rental_app_sping_boot.dto.Availability;
import com.ty.car_rental_app_sping_boot.dto.Booking;
import com.ty.car_rental_app_sping_boot.dto.BookingStatus;
import com.ty.car_rental_app_sping_boot.dto.Car;
import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import com.ty.car_rental_app_sping_boot.dto.Role;
import com.ty.car_rental_app_sping_boot.dto.User;
import com.ty.car_rental_app_sping_boot.exception.CarNotAvailableException;
import com.ty.car_rental_app_sping_boot.exception.BookingIdNotFoundException;
import com.ty.car_rental_app_sping_boot.exception.BookingUnsuccessfullException;
import com.ty.car_rental_app_sping_boot.exception.BrandNotFound;
import com.ty.car_rental_app_sping_boot.exception.CarTypeNotFoundException;
import com.ty.car_rental_app_sping_boot.exception.NoOfSeatsFoundException;
import com.ty.car_rental_app_sping_boot.exception.UserIdNotFoundException;
import com.ty.car_rental_app_sping_boot.exception.UserRoleNotFoundException;
import com.ty.car_rental_app_sping_boot.repository.BookingRepository;
import com.ty.car_rental_app_sping_boot.repository.CarRepository;
import com.ty.car_rental_app_sping_boot.repository.UserRepository;

@Service
public class BookingService {

	 @Autowired
	    private BookingDao bookingDao;
	 @Autowired
	 private CarRepository carRepository;
	 
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private BookingRepository bookingRepository;
	 
	 //booking based on brand
	 public ResponseEntity<ResponseStructure<Booking>> saveBookingByBrand(Booking booking,String brand,int id) {
		 
		 Optional<User> ctmr=userRepository.findById(id);
		 if(ctmr.isPresent())
		 {
		 User customer=ctmr.get();
		 if(customer.getUserRole()==Role.Customer)
		 {
		 List<Car> cars=carRepository.findByBrand(brand);
		 
		 if(cars.size()!=0)
		 {
			 for(int i=0;i<cars.size();i++)
			 {
				Car car=cars.get(i);
				if(car.getCarAvailabilityStatus()==Availability.Available)
				{
					 booking.setBookingStatus(BookingStatus.NotComfirmed);
					 Car car1=booking.getCar();
					 car1=car;
					 booking.setCar(car1);
					 Booking bookingobj=bookingDao.saveBooking(booking);
		 
					 car.setBooking(booking);
					 carRepository.save(car);
					 
					 
					 customer.setBooking(bookingobj);
					 userRepository.save(customer);
					 
					 if (bookingobj!=null) {
				            ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
				            responseStructure.setStatusCode(HttpStatus.CREATED.value());
				            responseStructure.setMessage("Booking Success");
				            responseStructure.setData(bookingobj);
				            return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.CREATED);
				        }else{
				        	throw new BookingUnsuccessfullException("Booking UnsuccessFull");
				        } 	 
				}
			 }
			 throw new CarNotAvailableException();
		 }
		 else
		 {
			 throw new BrandNotFound(brand+ " doesnt exist"); 
		 }
		 }
		 else
		 {
			throw new UserRoleNotFoundException(); 
		 }
		 }
		 else
		 {
			throw new UserIdNotFoundException();
		 }
	 }
	 
	//booking based on cartype 
   public ResponseEntity<ResponseStructure<Booking>> saveBookingByCarType(Booking booking,String carType,int id) {
		 
		 Optional<User> ctmr=userRepository.findById(id);
		 if(ctmr.isPresent())
		 {
		 User customer=ctmr.get();
		 if(customer.getUserRole()==Role.Customer)
		 {
		 List<Car> cars=carRepository.findByCarType(carType);
		 
		 if(cars.size()!=0)
		 {
			 for(int i=0;i<cars.size();i++)
			 {
				Car car=cars.get(i);
				if(car.getCarAvailabilityStatus()==Availability.Available)
				{
					 booking.setBookingStatus(BookingStatus.NotComfirmed);
					 
					 Car car1=booking.getCar();
					 car1=car;
					 booking.setCar(car1);
					 Booking bookingobj=bookingDao.saveBooking(booking);
					 
					 
					 car.setBooking(booking);
					 carRepository.save(car);
					 
					 
					 customer.setBooking(bookingobj);
					 userRepository.save(customer);
					 
					 if (bookingobj!=null) {
				            ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
				            responseStructure.setStatusCode(HttpStatus.CREATED.value());
				            responseStructure.setMessage("Booking Success");
				            responseStructure.setData(bookingobj);
				            return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.CREATED);
				        }else{
				            throw new BookingUnsuccessfullException("Booking UnsuccessFull");
				        } 	 
				}
			 }
			 throw new CarNotAvailableException();
		 }
		 else
		 {
			 throw new CarTypeNotFoundException(carType+ " doesnt exist");
		 }
		 }
		 else
		 {
			 throw new UserRoleNotFoundException();
		 }
		 }
		 else
		 {
			throw new UserIdNotFoundException();
		 }
	 }
   
   
   //booking based on no of seats
   public ResponseEntity<ResponseStructure<Booking>> saveBookingByCarSeats(Booking booking,int seats,int id) {
		 
		 Optional<User> ctmr=userRepository.findById(id);
		 if(ctmr.isPresent())
		 {
		 User customer=ctmr.get();
		 if(customer.getUserRole()==Role.Customer)
		 {
		 List<Car> cars=carRepository.findByNumberOfSeats(seats);
		 
		 if(cars.size()!=0)
		 {
			 for(int i=0;i<cars.size();i++)
			 {
				Car car=cars.get(i);
				if(car.getCarAvailabilityStatus()==Availability.Available)
				{
					 booking.setBookingStatus(BookingStatus.NotComfirmed);
					 
					 Car car1=booking.getCar();
					 car1=car;
					 booking.setCar(car1);
					 Booking bookingobj=bookingDao.saveBooking(booking);
					 
					 
					 car.setBooking(booking);
					 carRepository.save(car);
					 
					 
					 customer.setBooking(bookingobj);
					 userRepository.save(customer);
					 
					 if (bookingobj!=null) {
				            ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
				            responseStructure.setStatusCode(HttpStatus.CREATED.value());
				            responseStructure.setMessage("Booking Success");
				            responseStructure.setData(bookingobj);
				            return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.CREATED);
				        }else{
				        	throw new BookingUnsuccessfullException("Booking UnsuccessFull");
				        } 	 
				}
			 }
			 throw new CarNotAvailableException();
		 }
		 else
		 {
			 throw new NoOfSeatsFoundException(seats+" Seaters dosent exist");
		 }
		 }
		 else
		 {
			 throw new UserRoleNotFoundException();
		 }
		 }
		 else
		 {
			throw new UserIdNotFoundException();
		 }
	 }
   
   //update pickup,droplocations
   public ResponseEntity<ResponseStructure<Booking>> UpdateLocationsById(String pickuploc,String droploc,int id,int bid) {
		 
		 Optional<User> ctmr=userRepository.findById(id);
		 if(ctmr.isPresent())
		 {
		 User customer=ctmr.get();
		 if(customer.getUserRole()==Role.Customer)
		 {
			 Optional<Booking> bookingobj=bookingRepository.findById(bid);
			 System.out.println(bookingobj);
			 if(bookingobj.isPresent())
			 {
	
				 Booking bookobj=bookingobj.get();
				 bookobj.setPickUpLocation(pickuploc);
				 bookobj.setDropLocation(droploc);
				 
				 Car car=bookobj.getCar();
				 
				 car.setBooking(bookobj);
				 carRepository.save(car);
				 
				 
				 bookobj.setCar(car);
				 Booking bobj=bookingRepository.save(bookobj);
				 
				 
				 customer.setBooking(bobj);
				 userRepository.save(customer);
				 if (bobj!=null) {
			            ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			            responseStructure.setStatusCode(HttpStatus.CREATED.value());
			            responseStructure.setMessage("Updated drop,pickup locations Success");
			            responseStructure.setData(bobj);
			            return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.CREATED);
			        }else{
			            ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
			            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			            responseStructure.setMessage("Upadate Locations Unsuccessfull");
			            responseStructure.setData(null);
			            return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.BAD_REQUEST);
			        } 
			 }
			 else
			 {
				 throw new BookingIdNotFoundException();
			 }
		 }
		 else
		 {
			 ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
	            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
	            responseStructure.setMessage("YOU ARE NOT A CUSTOMER");
	            responseStructure.setData(null);
	            return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.BAD_REQUEST); 
		 }
		 }
		 else
		 {
			throw new UserIdNotFoundException();
		 }
}
}
