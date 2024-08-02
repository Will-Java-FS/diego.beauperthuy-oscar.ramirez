package com.revature.controllers;

import com.revature.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.model.Car;
import java.util.List;

@RestController
public class CarController {

    CarService cs;

    @Autowired
    public CarController (CarService cs) {
        this.cs = cs;
    }

/*    @GetMapping("hello")
    public String greeting() {
        return "ARE WE RUNNING";
    }*/
    // NEED TO UPDATE USING RESPONSEENTITY<T>
    // BASIC STUFF WORKS!

    @GetMapping("car")
    public List<Car> getAllCars(){
        return cs.findAllCars();
    }

    @GetMapping("car/{id}")
    public Car findCarById(@PathVariable int id) {
        return cs.findCarById(id);
    }

    @GetMapping("/car/make/{make}")
    public List<Car> findCarByMake(@PathVariable String make) {
        return cs.findCarsByMake(make.toLowerCase());
    }

    @GetMapping("/car/model/{model}")
    public List<Car> findCarByModel(@PathVariable String model) {
        return cs.findCarsByModel(model.toLowerCase());
    }

    @GetMapping("/car/year/{year}")
    public List<Car> findCarByYear(@PathVariable String year) {
        return cs.findCarsByModel(year.toLowerCase());
    }


}
