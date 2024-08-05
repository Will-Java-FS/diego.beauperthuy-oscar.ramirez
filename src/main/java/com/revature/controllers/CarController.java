package com.revature.controllers;

import com.revature.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.model.Car;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    CarService cs;

    @Autowired
    public CarController (CarService cs) {
        this.cs = cs;
    }

    @GetMapping("car")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = cs.findAllCars();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @GetMapping("car/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable int id) {
        Optional<Car> c = cs.findCarById(id);
        return c.map(car -> ResponseEntity.status(HttpStatus.OK).body(car))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/car/make/{make}")
    public ResponseEntity<List<Car>> findCarByMake(@PathVariable String make) {
        List<Car> cars = cs.findCarsByMake(make);
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @GetMapping("/car/model/{model}")
    public ResponseEntity<List<Car>> findCarByModel(@PathVariable String model) {
        List<Car> cars =  cs.findCarsByModel(model);
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @GetMapping("/car/year/{year}")
    public ResponseEntity<List<Car>>  findCarByYear(@PathVariable int year) {
        List<Car> cars =  cs.findCarsByYear(year);
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @GetMapping("/car/dealership/{dealership_id}")
    public ResponseEntity<List<Car>> findCarByDealership(@PathVariable int dealershipID) {
        List<Car> cars =  cs.findCarsByYear(dealershipID);
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @PostMapping("/car")
    public ResponseEntity<Car> addCar(@RequestBody Car c) {
        List<Car> cars = cs.findAllCars();
        if (cars.contains(c)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(cs.saveCar(c));
    }

    @PutMapping("/car")
    public ResponseEntity<Car> updateCar(@RequestBody Car c) {
        List<Car> cars = cs.findAllCars();
        if (!cars.contains(c)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(c);
        }
        return ResponseEntity.status(HttpStatus.OK).body(cs.saveCar(c));
    }

    @DeleteMapping("car/")
    public ResponseEntity<Car> deleteCar(@RequestBody Car c) {
        return ResponseEntity.status(HttpStatus.OK).body(cs.deleteCar(c));
    }

}
