package com.revature.repositories;

import com.revature.model.Dealership;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealershipRepo{

    List<Dealership> findDealershipByName(String name);
}
