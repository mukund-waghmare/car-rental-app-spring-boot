package com.ty.car_rental_app_sping_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.InitBinder;

import com.ty.car_rental_app_sping_boot.dto.Address;
import com.ty.car_rental_app_sping_boot.dto.Role;
import com.ty.car_rental_app_sping_boot.dto.User;
import com.ty.car_rental_app_sping_boot.repository.AddressRepository;
import com.ty.car_rental_app_sping_boot.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class CarRentalAppSpingBootApplication {
	
	
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	AddressRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CarRentalAppSpingBootApplication.class, args);
	}

	@PostConstruct
	public void init()
	{
		
		
		if(userRepository.findUserByRole(Role.Admin)==null)
		{
			User user= new User();
			Address address= new Address();
			
			
			
		address.setCity("Mumbai");
		address.setPincode(412550);
		address.setState("Maharastra");
		
		addressRepository.save(address);
		
		user.setuserName("Aarav");
		user.setUserAddress(address);
		user.setUserEmail("Aarav@gmail.com");
		user.setUserPassword("Aarav@123");
		user.setUserRole(Role.Admin);
		user.setUserContact(888777666l);
	
		userRepository.save(user);
		System.out.println("Admin Created Successfully");
		}
		else
		{
			System.out.println("Admin Already Exists");
		}
		
		
		
	}
}
