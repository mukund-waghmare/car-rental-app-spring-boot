package com.ty.car_rental_app_sping_boot.dao;

import com.ty.car_rental_app_sping_boot.dto.Car;
import com.ty.car_rental_app_sping_boot.dto.ResponseStructure;
import com.ty.car_rental_app_sping_boot.dto.Role;
import com.ty.car_rental_app_sping_boot.dto.User;
import com.ty.car_rental_app_sping_boot.repository.CarRepository;
import com.ty.car_rental_app_sping_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarDao {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;
    public Car saveCar(Car car, int ownerId) {
        User carOwner = userRepository.findUserByRole(Role.CarOwner);
        if (carOwner!=null) {
            Optional<User> optOwner = userRepository.findById(ownerId);
            if (optOwner.isPresent()) {
                User owner = optOwner.get();
                List<User> users = car.getUser();
                if (users==null){
                    users=new ArrayList<>();
                }
                users.add(owner);
                car.setUsers(users);
                List<Car> cars = owner.getCarListFromOwner();
                if (cars==null){
                    cars=new ArrayList<>();
                }
                cars.add(car);
                owner.setCarListFromOwner(cars);
                carRepository.save(car);
                userRepository.save(owner);
                return car;
            }else
                return null;
        }else{
            return null;
        }
    }

    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<Car> findByCarType(String carType) {
        return carRepository.findByCarType(carType);
    }

    public List<Car> findByMileage(Double mileage) {
        return carRepository.findByMileage(mileage);
    }


    public List<Car> findByNumberOfSeats(int numberOfSeats) {
        return carRepository.findByNumberOfSeats(numberOfSeats);
    }
}
