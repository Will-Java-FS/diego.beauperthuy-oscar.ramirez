package com.revature.repositories;

import com.revature.model.Car;
import com.revature.model.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealershipRepo{

    List<Dealership> findDealershipByName(String name);
}
