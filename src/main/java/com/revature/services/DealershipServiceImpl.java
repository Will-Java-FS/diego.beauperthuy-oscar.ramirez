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

    public Dealership findById(int id){
        return dealershipRepo.findById(id);
    }

    public List<Dealership> findDealershipByName(String name){
        return dealershipRepo.findDealershipByName(name.trim().toLowerCase());
    }

    public List<Dealership> findDealershipByCity(String city){
        return dealershipRepo.findDealershipByCity(city.toLowerCase());
    }

    public List<Dealership> findDealershipByState(String state){
        return dealershipRepo.findDealershipByState(state.toLowerCase());
    }

    //Save a new Dealership
    public Dealership saveDealership(Dealership ds) {
        return dealershipRepo.save(ds);
    }

    //Delete Dealership by ID
    public void deleteDealershipById(int id) {
        dealershipRepo.deleteById(id);
    }

    //Update Dealership
    public Dealership updateDealership(Dealership ds){
        return dealershipRepo.save(ds);
    }
}
