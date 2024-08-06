package com.revature.repositories;

import com.revature.model.Car;
import com.revature.model.Dealership;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CarRepoTest {

    @Autowired
    CarRepo repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindCars() {
        List<Car> cars = repository.findAll();
        assertNotNull(cars);
        assertFalse(cars.isEmpty());
    }

    @Test
    void shouldFindAllInfiniti() {
        List<Car> cars = repository.findCarsByMake("Infiniti");
        assertFalse(cars.isEmpty());
        assertEquals(4, cars.size());
    }

    @Test
    void shouldFindAllS2000() {
        List<Car> cars = repository.findCarsByModel("S2000");
        assertFalse(cars.isEmpty());
        assertEquals(1, cars.size());
    }

    @Test
    void shouldFindAllByModelYear2022() {
        List<Car> cars = repository.findCarsByYear(2022);
        assertFalse(cars.isEmpty());
        assertEquals(4, cars.size());
    }

    @Test
    void shouldFindCarsByDealershipId() {
        List<Car> cars = repository.findCarsByDealershipId(5);
        assertFalse(cars.isEmpty());
        assertEquals(9, cars.size());
    }

    @Test
    void shouldNotFindAnyCars() {
        List<Car> cars = repository.findCarsByYear(1000);
        List<Car> cars2 = repository.findCarsByDealershipId(6);
        List<Car> cars3 = repository.findCarsByMake("xxyyxx");
        List<Car> cars4 = repository.findCarsByModel("xxyyxx");

        assertTrue(cars.isEmpty());
        assertTrue(cars2.isEmpty());
        assertTrue(cars3.isEmpty());
        assertTrue(cars4.isEmpty());
    }

//    @Test
//    void shouldFind2014BuickVerano() {
//        Car expected = new Car(10, "Buick", "Verano", 2014, null);
//        Optional<Car> actual = repository.findById(10);
//
////        assertTrue(actual.isPresent());
//        assertEquals(expected.getMake(), actual.get().getMake());
//        assertEquals(expected.getModel(), actual.get().getModel());
//        assertEquals(expected.getYear(), actual.get().getYear());
//    }

//    @Test
//    void shouldFindAll___() {
//    }
//
//    @Test
//    void shouldFindAll___() {
//    }
//
//    @Test
//    void shouldFindAll___() {
//    }
//
//    @Test
//    void shouldFindAll___() {
//    }
}