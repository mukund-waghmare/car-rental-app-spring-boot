package com.ty.car_rental_app_sping_boot.service;

import com.ty.car_rental_app_sping_boot.dao.CarDao;
import com.ty.car_rental_app_sping_boot.dto.Car;
import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import com.ty.car_rental_app_sping_boot.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarDao carDao;

    public ResponseEntity<ResponseStructure<Car>> saveCar(Car car, int ownerId) {
       Car recCar = carDao.saveCar(car,ownerId);
        if (recCar!=null) {
            ResponseStructure<Car> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Car Created");
            responseStructure.setData(recCar);
            return new ResponseEntity<ResponseStructure<Car>>(responseStructure,HttpStatus.CREATED);
        }else{
            ResponseStructure<Car> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseStructure.setMessage("Not Created");
            responseStructure.setData(recCar);
            return new ResponseEntity<ResponseStructure<Car>>(responseStructure,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseStructure<List<Car>>> findByBrand(String brand) {
        List<Car> recCar = carDao.findByBrand(brand);
        if (recCar!=null) {
            ResponseStructure<List<Car>> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("Car Created");
            responseStructure.setData(recCar);
            return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure,HttpStatus.CREATED);
        }else{
            throw new BrandNotFound("Brand Not found");
        }
    }

    public ResponseEntity<ResponseStructure<List<Car>>> findByCarType(String carType) {
        List<Car> recCar = carDao.findByCarType(carType);
        if (recCar!=null) {
            ResponseStructure<List<Car>> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("CarType found");
            responseStructure.setData(recCar);
            return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure,HttpStatus.CREATED);
        }else{
            throw new CarTypeNotFoundException("Car Type Not Found");
        }
    }

    public ResponseEntity<ResponseStructure<List<Car>>> findByMileage(Double mileage) {
        List<Car> recCar = carDao.findByMileage(mileage);
        if (recCar!=null) {
            ResponseStructure<List<Car>> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("CarType found");
            responseStructure.setData(recCar);
            return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure,HttpStatus.CREATED);
        }else{
            throw new MileageNotFoundException("Mileage Not Found");
        }
    }

    public ResponseEntity<ResponseStructure<List<Car>>> findByFuelType(String fuelType) {
        List<Car> recCar = carDao.findByCarType(fuelType);
        if (recCar!=null) {
            ResponseStructure<List<Car>> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("CarType found");
            responseStructure.setData(recCar);
            return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure,HttpStatus.CREATED);
        }else{
            throw new FuelTypeNotFoundException("Fuel Type Not Found");
        }
    }

    public ResponseEntity<ResponseStructure<List<Car>>> findByNumberOfSeats(int numberOfSeats) {
        List<Car> recCar = carDao.findByNumberOfSeats(numberOfSeats);
        if (recCar!=null) {
            ResponseStructure<List<Car>> responseStructure = new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.CREATED.value());
            responseStructure.setMessage("CarType found");
            responseStructure.setData(recCar);
            return new ResponseEntity<ResponseStructure<List<Car>>>(responseStructure,HttpStatus.CREATED);
        }else{
            throw new NoOfSeatsNotFoundException("No number of seats found");
        }

    }
}
