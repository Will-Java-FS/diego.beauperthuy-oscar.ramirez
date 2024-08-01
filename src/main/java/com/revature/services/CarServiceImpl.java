package com.revature.services;

import com.revature.model.Car;
import com.revature.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    CarRepo cr;

    @Autowired
    public CarServiceImpl (CarRepo cr) {
        this.cr = cr;
    }

    // READ METHOD(S)
    public List<Car> getAllCars() {
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


    public Car findCarById(long id) {
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
    /*public Car deleteCarById(long id) {
        Car c = cr.findById(id).get();
        cr.deleteById(id);
        return c;
    }*/

    public Car deleteCar(Car c) {
        cr.delete(c);
        return c;
    }

}
