package com.revature.repositories;

import com.revature.model.Dealership;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DealershipRepoTest {

    @Autowired
    DealershipRepo dealershipRepository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindAllDealerships() {
        List<Dealership> dealerships = dealershipRepository.findAll();
        assertFalse(dealerships.isEmpty());
    }

    @Test
    void findDealershipByName() {
        List<Dealership> ds = dealershipRepository.findDealershipByName("Auto Haven");
        assertFalse(ds.isEmpty());
    }

    @Test
    void findDealershipByCity() {
        List<Dealership> ds = dealershipRepository.findDealershipByCity("Brooklyn");
        assertFalse(ds.isEmpty());
    }

    @Test
    void findDealershipByState() {
        List<Dealership> ds = dealershipRepository.findDealershipByState("New York");
        assertFalse(ds.isEmpty());
    }

    @Test
    void shouldDeleteById() {
        Dealership ds = dealershipRepository.findById(1);
        dealershipRepository.deleteById(ds.getId());
        assertNull(dealershipRepository.findById(1));
    }
}

