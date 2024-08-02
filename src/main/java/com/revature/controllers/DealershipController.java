package com.revature.controllers;

import com.revature.model.Dealership;
import com.revature.services.DealershipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DealershipController {

    DealershipServiceImpl ds;

    @Autowired
    public DealershipController(DealershipServiceImpl ds){
        this.ds = ds;
    }

    @GetMapping("dealership")
    public List<Dealership> getAllDealerships(){
        return ds.getAllDealerships();
    }

    @GetMapping(value = "dealership", params = {"id"})
    public Dealership findDealershipById(@RequestParam("id") int id) {
        return ds.findById(id);
    }

    @GetMapping(value = "dealership", params = {"name"})
    public List<Dealership> findDealershipByName(@RequestParam("name") String name){
        return ds.findDealershipByName(name);
    }

    @GetMapping(value = "dealership", params = {"city"})
    public List<Dealership> findDealershipByCity(@RequestParam("name") String city){
        return ds.findDealershipByCity(city);
    }

    @GetMapping(value = "dealership", params = {"state"})
    public List<Dealership> findDealershipByState(@RequestParam("state") String state){
        return ds.findDealershipByState(state);
    }

    @PostMapping("dealership")
    public Dealership saveDealership(@RequestBody Dealership dealership){
        return ds.saveDealership(dealership);
    }

    @DeleteMapping("dealership")
    public Dealership deleteDealership(@RequestBody Dealership dealership){
        return ds.deleteDealership(dealership);
    }

    @DeleteMapping("dealership/{id}")
    public Dealership deleteDealershipById(@RequestParam("id") int id){
        return ds.deleteDealershipById(id);
    }

    @PutMapping("dealership/{id}")
    public ResponseEntity<Dealership> updateDealership(@PathVariable int id, @RequestBody Dealership dealship){

        dealship.setId(id);

        Dealership dealship2 = ds.findById(id);

        if(dealship2.getId() == id) {
            dealship = ds.updateDealership(dealship);
            return new ResponseEntity<>(dealship, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
