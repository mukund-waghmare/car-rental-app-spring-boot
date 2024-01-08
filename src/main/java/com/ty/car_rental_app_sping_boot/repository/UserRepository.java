package com.ty.car_rental_app_sping_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.car_rental_app_sping_boot.dto.Role;
import com.ty.car_rental_app_sping_boot.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	

	@Query("select u from User u where u.userRole=?1")
	User findUserByRole(Role role);
	
	
	@Query("select u from User u where u.userEmail=?1 and u.userPassword=?2")
	User findUserByEmailAndPassword(String userEmail,String userPassword);
	
}
