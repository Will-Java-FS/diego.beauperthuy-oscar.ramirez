package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.Car;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository <Car, Long> {

    public List<Car> findCarsByMake(String make);
    public List<Car> findCarsByModel(String model);
    public List<Car> findCarsByYear(int year);

}
