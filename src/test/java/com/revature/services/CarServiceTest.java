package com.revature.services;

import com.revature.model.Car;
import com.revature.model.Dealership;
import com.revature.repositories.CarRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CarServiceTest {

    @MockBean
    CarRepo carRepository;

    @Autowired
    CarService carService;

    /*@Test
    void shouldFindCarById() {
        Optional<Car> expected = Optional.ofNullable(getCar());
        when(carRepository.findById(any())).thenReturn(expected);

        Optional<Car> actual = carService.findCarById(36);
        assertEquals(expected.get().getMake(), actual.get().getMake());
    }*/

//    @Test
//    void shouldAddValidCar() {
//
//    }

//    @Test
//    void shouldNotAddInvalidCar() {
//
//    }

//    @Test
//    void shouldNotAddNullMake() {
//
//    }

//    @Test
//    void shoudlNotAddNullModel() {
//
//    }

//    @Test
//    void shouldUpdateCar() {
//
//    }

//    @Test
//    void shouldNotUpdateWhenInvalid() {
//
//    }

//    @Test
//    void shouldDelete() {
//
//    }

    public Car getCar() {
        return new Car(
                36,"Subaru","Solterra",2023,
                new Dealership(1, "Carmax Inc.", "Richmond", "Virginia", null));
    }
}