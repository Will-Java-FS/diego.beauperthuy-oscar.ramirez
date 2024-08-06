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
    CarRepo carRepository;
    @Autowired
    DealershipRepo dealershipRepository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindCars() {
        List<Car> cars = carRepository.findAll();
        assertNotNull(cars);
        assertFalse(cars.isEmpty());
    }

    @Test
    void shouldFindAllInfiniti() {
        List<Car> cars = carRepository.findCarsByMake("Infiniti");
        assertFalse(cars.isEmpty());
        assertEquals(4, cars.size());
    }

    @Test
    void shouldNotFindByFakeMake() {
        List<Car> cars = carRepository.findCarsByMake("Bogus");
        assert(cars.isEmpty());
    }

    @Test
    void shouldFindAllS2000() {
        List<Car> cars = carRepository.findCarsByModel("S2000");
        assertFalse(cars.isEmpty());
        assertEquals(1, cars.size());
    }

    @Test
    void shouldNotFindFakeModel() {
        List<Car> cars = carRepository.findCarsByModel("Bogus");
        assert(cars.isEmpty());
    }

    @Test
    void shouldFindAllByModelYear2022() {
        List<Car> cars = carRepository.findCarsByYear(2022);
        assertFalse(cars.isEmpty());
        assertEquals(4, cars.size());
    }

    @Test
    void shouldNotFindByFakeYear() {
        List<Car> cars = carRepository.findCarsByYear(1800);
        assert(cars.isEmpty());
    }

    @Test
    void shouldFindCarsByDealershipId() {
        List<Car> cars = carRepository.findCarsByDealershipId(5);
        assertFalse(cars.isEmpty());
        assertEquals(9, cars.size());
    }

    @Test
    void shouldNotFindAnyCars() {
        List<Car> cars = carRepository.findCarsByYear(1000);
        List<Car> cars2 = carRepository.findCarsByDealershipId(6);
        List<Car> cars3 = carRepository.findCarsByMake("xxyyxx");
        List<Car> cars4 = carRepository.findCarsByModel("xxyyxx");

        assertTrue(cars.isEmpty());
        assertTrue(cars2.isEmpty());
        assertTrue(cars3.isEmpty());
        assertTrue(cars4.isEmpty());
    }

    @Test
    void shouldFind2014BuickVerano() {
        Optional<Car> actual = carRepository.findById(10);
        String expected = "Buick";
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get().getMake());
    }

    @Test
    void shouldNotFindNullNorNonExisting() {
        Optional<Car> actual = carRepository.findById(9999);
        assert(actual.isEmpty());
    }

    @Test
    void shouldAddCar() {
        Dealership ds = dealershipRepository.findById(1);
        Car c = new Car(0, "TestMake", "TestModel", 2024, ds);
        Car result = carRepository.save(c);
        Optional<Car> actual = carRepository.findById(46);

        assert(actual.isPresent());
        assertEquals("TestMake", actual.get().getMake());

    }

    @Test
    void shouldUpdateCar() {
        Optional<Car> toUpdate = carRepository.findById(2);
        assertEquals("Acura", toUpdate.get().getMake());

        toUpdate.get().setMake("TestMake");
        Car actual = carRepository.save(toUpdate.get());

        assertEquals("TestMake", actual.getMake());
    }

    @Test
    void shouldDeleteCar() {
        Optional<Car> toDelete = carRepository.findById(1);
        carRepository.delete(toDelete.get());

        assert(carRepository.findById(1).isEmpty());
    }

}