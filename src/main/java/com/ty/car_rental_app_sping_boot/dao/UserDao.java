package com.ty.car_rental_app_sping_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.car_rental_app_sping_boot.dto.Booking;
import com.ty.car_rental_app_sping_boot.dto.Car;
import com.ty.car_rental_app_sping_boot.dto.Role;
import com.ty.car_rental_app_sping_boot.dto.User;
import com.ty.car_rental_app_sping_boot.repository.AddressRepository;
import com.ty.car_rental_app_sping_boot.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	UserRepository userRepositoryObject;
	
	@Autowired
	AddressRepository addressRepository;
	
	public User registerUser(User passedUser)
	{
		addressRepository.save(passedUser.getUserAddress());
		userRepositoryObject.save(passedUser);
		return passedUser;
	}
	
	public User getUserById(int passedUserId)
	{
		Optional<User> user=userRepositoryObject.findById(passedUserId);
		if(user.isPresent())
		{
			return user.get();
		}
		return null;
	}
	
	public User updateUserById(int passedUserId, User passedUser)
	{

		Optional<User> user=userRepositoryObject.findById(passedUserId);
		
		if(user.isPresent())
		{
			User userToUpdate=user.get();
			userToUpdate.setuserName(passedUser.getuserName());
			userToUpdate.setUserEmail(passedUser.getUserEmail());
			userToUpdate.setUserPassword(passedUser.getUserPassword());
			userToUpdate.setCarListFromOwner(passedUser.getCarListFromOwner());
			userToUpdate.setBooking(passedUser.getBooking());
			
			return userToUpdate;
		}
		return null;
		
	}
	
	public boolean deleteUserById(int passedUserId)
	{
		Optional<User> user=userRepositoryObject.findById(passedUserId);
		
		if(user.isPresent())
		{
			
			userRepositoryObject.delete(user.get());
			return true;
		}
		return false;

	}

	public Car addCarToOwnerById(int ownerId,Car passedCarInfo)
	{
		
		return null;
	}
	
	public Car getCarOnRent(int passedCustomerId,int carId,Booking bookingInfo)
	{
		Optional<User> user=userRepositoryObject.findById(passedCustomerId);
		
		Optional<Car> car= null;
		
		if(user.isPresent() && car.isPresent())
		{
		   User userToGetCar=user.get();
		   
		   Booking booking=userToGetCar.getBooking();
		   if (booking==null) {
			   booking.setCar(bookingInfo.getCar());
			   booking.setPickUpLocation(bookingInfo.getPickUpLocation());
			   booking.setDropLocation(bookingInfo.getDropLocation());
			   booking.setStartDate(bookingInfo.getStartDate());
			   booking.setEndDate(bookingInfo.getEndDate());
			   booking.setStartingMeterReading(bookingInfo.getStartingMeterReading());
			   booking.setEndingMeterReading(bookingInfo.getEndingMeterReading());
			
		}
		}
		
		return null;
		
	}
	
	public User getUserByRole(Role role)
	{
		User user=userRepositoryObject.findUserByRole(role);
		return user;
	}
	
	public User userLogin(String email,String password)
	{
		User user=userRepositoryObject.findUserByEmailAndPassword(email, password);
		
		return user;
	}
	

	
	
}
