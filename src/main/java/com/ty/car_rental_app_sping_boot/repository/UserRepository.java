package com.ty.car_rental_app_sping_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.car_rental_app_sping_boot.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	

}
