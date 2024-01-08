package com.ty.car_rental_app_sping_boot.controller;

import com.ty.car_rental_app_sping_boot.dto.Car;
import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import com.ty.car_rental_app_sping_boot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/savecar/ownerId/{ownerId}")
    public ResponseEntity<ResponseStructure<Car>> saveCar(@RequestBody Car car, @PathVariable int ownerId) {
        return carService.saveCar(car, ownerId);
    }

    @GetMapping("/findbybrand/brand/{brand}")
    public ResponseEntity<ResponseStructure<List<Car>>> saveCar(@PathVariable String brand) {
        return carService.findByBrand(brand);
    }

    @GetMapping("/findbycartype/cartype/{carType}")
    public ResponseEntity<ResponseStructure<List<Car>>> findByCarType(@PathVariable String carType) {
        return carService.findByCarType(carType);
    }

    @GetMapping("/findbymileage/mileage/{mileage}")
    public ResponseEntity<ResponseStructure<List<Car>>> findByMileage(@PathVariable Double mileage) {
        return carService.findByMileage(mileage);
    }

    @GetMapping("/findbyfueltype/fuelType/{fuelType}")
    public ResponseEntity<ResponseStructure<List<Car>>> findByFuelType(@PathVariable String fuelType) {
        return carService.findByFuelType(fuelType);
    }

    @GetMapping("/findbynoofseats/noOfSeats/{noOfSeats}")
    public ResponseEntity<ResponseStructure<List<Car>>> findByNumberOfSeats(@PathVariable int numberOfSeats) {
        return carService.findByNumberOfSeats(numberOfSeats);
    }



}
