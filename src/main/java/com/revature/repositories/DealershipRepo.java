package com.revature.repositories;

import com.revature.model.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealershipRepo extends JpaRepository<Dealership, Long> {

    List<Dealership> findDealershipByName(String name);
    List<Dealership> findDealershipByCity(String city);
    List<Dealership> findDealershipByState(String state);
}
