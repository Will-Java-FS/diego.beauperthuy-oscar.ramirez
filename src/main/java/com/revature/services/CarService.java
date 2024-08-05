package com.revature.services;

import com.revature.model.Car;
import com.revature.model.Dealership;
import com.revature.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    CarRepo cr;

    @Autowired
    public CarService (CarRepo cr) {
        this.cr = cr;
    }

    // READ METHOD(S)
    public List<Car> findAllCars() {
        return cr.findAll();
    }

    public List<Car> findCarsByMake(String make) {
        return cr.findCarsByMake(make);
    }

    public List<Car> findCarsByModel(String model) {
        return cr.findCarsByModel(model);
    }

    public List<Car> findCarsByYear(int year) {
        return cr.findCarsByYear(year);
    }

    public List<Car> findCarsByDealershipId(int dealershipId) {
        return cr.findCarsByDealershipId(dealershipId);
    }

    public Optional<Car> findCarById(int id) {
        return cr.findById(id);
    }

    // CREATE METHOD(S)
    public Car saveCar(Car c) {
        return cr.save(c);
    }

    // UPDATE METHOD(S)
    public Car updateCar(Car c) {
        if (cr.findAll().contains(c)) {
            return cr.save(c);
        }
        return null;
    }

    // DELETE METHOD(S)
    public Car deleteCar(Car c) {
        cr.delete(c);
        return c;
    }

}
