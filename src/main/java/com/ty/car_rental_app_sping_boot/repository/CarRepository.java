package com.ty.car_rental_app_sping_boot.repository;

import com.ty.car_rental_app_sping_boot.dto.Car;
import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findByCarType(String carType);

    List<Car> findByBrand(String brand);
    
    List<Car> findByMileage(Double mileage);

    List<Car> findByNumberOfSeats(int numberOfSeats);
}
