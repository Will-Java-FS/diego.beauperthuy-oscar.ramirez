package com.revature.services;

import com.revature.model.Dealership;
import com.revature.repositories.DealershipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealershipServiceImpl {

    DealershipRepo dealershipRepo;

    @Autowired
    public DealershipServiceImpl (DealershipRepo dealershipRepo){
        this.dealershipRepo = dealershipRepo;
    }

    //Methods

    public List<Dealership> getAllDealerships(){
        return dealershipRepo.findAll();
    }

    public List<Dealership> findDealershipByName(String name){
        return dealershipRepo.findDealershipByName(name);
    }

    public List<Dealership> findDealershipByCity(String city){
        return dealershipRepo.findDealershipByCity(city);
    }

    public List<Dealership> findDealershipByState(String state){
        return dealershipRepo.findDealershipByState(state);
    }

    //Save a new Dealership
    public Dealership saveDealership(Dealership ds) {
        return dealershipRepo.save(ds);
    }

    //Delete Dealership
    public Dealership deleteDealership(Dealership ds) {
        dealershipRepo.delete(ds);
        return ds;
    }

    //Delete Dealership by ID
    public Dealership deleteDealershipById(long id) {
        Dealership ds = dealershipRepo.findById(id).get();
        dealershipRepo.deleteById(id);
        return ds;
    }

    //Update Dealership
    public Dealership updateDealership(Dealership ds){
        return dealershipRepo.save(ds);
    }
}
