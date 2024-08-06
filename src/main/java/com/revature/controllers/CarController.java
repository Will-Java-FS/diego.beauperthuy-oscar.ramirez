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
@RequestMapping("/cars")
public class CarController {

    CarService cs;

    @Autowired
    public CarController (CarService cs) {
        this.cs = cs;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = cs.findAllCars();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable int id) {
        Optional<Car> c = cs.findCarById(id);
        return c.map(car -> ResponseEntity.status(HttpStatus.OK).body(car))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/make/{make}")
    public ResponseEntity<List<Car>> findCarByMake(@PathVariable String make) {
        List<Car> cars = cs.findCarsByMake(make);
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<Car>> findCarByModel(@PathVariable String model) {
        List<Car> cars =  cs.findCarsByModel(model);
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Car>>  findCarByYear(@PathVariable int year) {
        List<Car> cars =  cs.findCarsByYear(year);
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @GetMapping("/dealership/{dealershipID}")
    public ResponseEntity<List<Car>> findCarByDealership(@PathVariable int dealershipID) {
        List<Car> cars =  cs.findCarsByDealershipId(dealershipID);
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car c) {
        Optional<Car> car = cs.findCarById(c.getId());
        if (car.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Car result = cs.saveCar(c);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping
    public ResponseEntity<Car> updateCar(@RequestBody Car c) {
        Optional<Car> car = cs.findCarById(c.getId());
        if (car.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(c);
        }
        Car result = cs.saveCar(c);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping
    public ResponseEntity<Car> deleteCar(@RequestBody Car c) {
        Car car = cs.deleteCar(c);
        return ResponseEntity.status(HttpStatus.OK).body(car);
    }

}
