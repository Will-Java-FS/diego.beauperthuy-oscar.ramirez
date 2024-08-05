package com.revature.repositories;

import com.revature.model.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealershipRepo extends JpaRepository<Dealership, Integer> {

    Dealership findById(int id);
    void deleteById(int id);

    @Query("SELECT d FROM Dealership d WHERE LOWER(REPLACE(d.name, ' ', '')) = LOWER(REPLACE(:name, ' ', ''))")
    List<Dealership> findDealershipByName(@Param("name") String name);

    @Query("SELECT d FROM Dealership d WHERE LOWER(REPLACE(d.city, ' ', '')) = LOWER(REPLACE(:city, ' ', ''))")
    List<Dealership> findDealershipByCity(String city);

    @Query("SELECT d FROM Dealership d WHERE LOWER(REPLACE(d.state, ' ', '')) = LOWER(REPLACE(:state, ' ', ''))")
    List<Dealership> findDealershipByState(String state);


}
