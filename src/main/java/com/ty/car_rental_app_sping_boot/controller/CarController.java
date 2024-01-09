package com.ty.car_rental_app_sping_boot.controller;

import com.ty.car_rental_app_sping_boot.dto.Car;
import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import com.ty.car_rental_app_sping_boot.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(description = "Save Car", summary = "Car saved Successfully")
    @ApiResponses(value = {@ApiResponse(description = "Car saved successfully",responseCode = "201"),@ApiResponse(description = "Car Not Saved",responseCode = "404")})
    public ResponseEntity<ResponseStructure<Car>> saveCar(@RequestBody Car car, @PathVariable int ownerId) {
        return carService.saveCar(car, ownerId);
    }

    @GetMapping("/findbybrand/brand/{brand}")
    @Operation(description = "Find By Brand", summary = "Car Details is fetched based on brand")
    @ApiResponses(value = {@ApiResponse(description = "Car Found",responseCode = "201"),@ApiResponse(description = "Car Found",responseCode = "404")})
    public ResponseEntity<ResponseStructure<List<Car>>> findByBrand(@PathVariable String brand) {
        return carService.findByBrand(brand);
    }

    @Operation(description = "Find By Car Type", summary = "Car Details is fetched based on car type")
    @ApiResponses(value = {@ApiResponse(description = "Car Found",responseCode = "201"),@ApiResponse(description = "Car Found",responseCode = "404")})
    @GetMapping("/findbycartype/cartype/{carType}")
    public ResponseEntity<ResponseStructure<List<Car>>> findByCarType(@PathVariable String carType) {
        return carService.findByCarType(carType);
    }

    @Operation(description = "Find By Mileage", summary = "Car Details is fetched based on mileage")
    @ApiResponses(value = {@ApiResponse(description = "Car Found",responseCode = "201"),@ApiResponse(description = "Car Not Found",responseCode = "404")})
    @GetMapping("/findbymileage/mileage/{mileage}")
    public ResponseEntity<ResponseStructure<List<Car>>> findByMileage(@PathVariable Double mileage) {
        return carService.findByMileage(mileage);
    }

    @Operation(description = "Find By Fuel Type", summary = "Car Details is fetched based on fuel type")
    @ApiResponses(value = {@ApiResponse(description = "Car Found",responseCode = "201"),@ApiResponse(description = "Car Not Found",responseCode = "404")})
    @GetMapping("/findbyfueltype/fuelType/{fuelType}")
    public ResponseEntity<ResponseStructure<List<Car>>> findByFuelType(@PathVariable String fuelType) {
        return carService.findByFuelType(fuelType);
    }

    @Operation(description = "Find By No of Seats", summary = "Car Details is fetched based on Number of Seats")
    @ApiResponses(value = {@ApiResponse(description = "Car Found",responseCode = "201"),@ApiResponse(description = "Car Not Saved",responseCode = "404")})
    @GetMapping("/findbynoofseats/noOfSeats/{numberOfSeats}")
    public ResponseEntity<ResponseStructure<List<Car>>> findByNumberOfSeats(@PathVariable int numberOfSeats) {
        return carService.findByNumberOfSeats(numberOfSeats);
    }


}
