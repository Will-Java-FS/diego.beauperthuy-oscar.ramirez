package com.revature.controllers;

import com.revature.model.Dealership;
import com.revature.services.DealershipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealership")
public class DealershipController {

    DealershipServiceImpl ds;

    @Autowired
    public DealershipController(DealershipServiceImpl ds){
        this.ds = ds;
    }

    @GetMapping
    public List<Dealership> getAllDealerships(){
        return ds.getAllDealerships();
    }

    @GetMapping("/{id}")
    public Dealership findDealershipById(@PathVariable int id) {
        return ds.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Dealership> findDealershipByName(@PathVariable String name){
        return ds.findDealershipByName(name.trim().toLowerCase());
    }

    @GetMapping("/city/{city}")
    public List<Dealership> findDealershipByCity(@PathVariable String city){
        return ds.findDealershipByCity(city);
    }

    @GetMapping("/state/{state}")
    public List<Dealership> findDealershipByState(@PathVariable String state){
        return ds.findDealershipByState(state);
    }

    @PostMapping
    public ResponseEntity<Dealership> saveDealership(@RequestBody Dealership dealership) {

        try {

            Dealership savedDealership = ds.saveDealership(dealership);

            return new ResponseEntity<>(savedDealership, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDealershipById(@PathVariable int id) {

        try {

            ds.deleteDealershipById(id);

            return ResponseEntity.ok().build();

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dealership> updateDealership(@PathVariable int id, @RequestBody Dealership dealership) {

        try {

            Dealership updatedDealership = ds.updateDealership(dealership);

            return ResponseEntity.ok(updatedDealership);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
