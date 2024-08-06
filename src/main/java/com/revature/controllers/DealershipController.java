package com.revature.controllers;

import com.revature.model.Dealership;
import com.revature.services.DealershipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dealership")
public class DealershipController {

    DealershipServiceImpl ds;

    @Autowired
    public DealershipController(DealershipServiceImpl ds){
        this.ds = ds;
    }

    @GetMapping
    public ResponseEntity<List<Dealership>> getAllDealerships(){
        List<Dealership> dealerships = ds.getAllDealerships();

        if (dealerships == null || dealerships.isEmpty()) {

            // No Content
            return ResponseEntity.noContent().build();

        } else {

            // 200 OK
            return ResponseEntity.ok(dealerships);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dealership> findDealershipById(@PathVariable int id) {

        Optional<Dealership> dealership = Optional.ofNullable(ds.findById(id));

        // 200 OK if found
        return dealership.map(ResponseEntity::ok)

                //404 Not found
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Dealership>> findDealershipByName(@PathVariable String name){

        List<Dealership> dealerships = ds.findDealershipByName(name.trim().toLowerCase());

        if (dealerships == null || dealerships.isEmpty()) {

            // 404 Not found
            return ResponseEntity.notFound().build();

        }   else {

            // 200 OK
            return ResponseEntity.ok(dealerships);
        }
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Dealership>> findDealershipByCity(@PathVariable String city){

        List<Dealership> dealerships = ds.findDealershipByCity(city.trim().toLowerCase());

        if (dealerships == null || dealerships.isEmpty()) {

            // 404 Not found
            return ResponseEntity.notFound().build();

        }   else {

            // 200 OK
            return ResponseEntity.ok(dealerships);
        }
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<Dealership>> findDealershipByState(@PathVariable String state){

        List<Dealership> dealerships = ds.findDealershipByState(state.trim().toLowerCase());

        if (dealerships == null || dealerships.isEmpty()) {

            // 404 Not found
            return ResponseEntity.notFound().build();

        }   else {

            // 200 OK
            return ResponseEntity.ok(dealerships);
        }
    }

    @PostMapping
    public ResponseEntity<Dealership> saveDealership(@RequestBody Dealership dealership) {

        try {

            Dealership savedDealership = ds.saveDealership(dealership);

            // Created
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDealership);

        } catch (Exception e) {

            // 500 Internal server error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDealershipById(@PathVariable int id) {

        try {

            Optional<Dealership> dealership = Optional.ofNullable(ds.findById(id));

            if (dealership.isPresent()) {
                ds.deleteDealershipById(id);

                // 200 OK
                return ResponseEntity.ok().build();

            }   else {

                    // 404 Not found
                    return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {

            // 500 Internal server error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dealership> updateDealership(@PathVariable int id, @RequestBody Dealership dealership) {

        try {

            Optional <Dealership> existingDealership = Optional.ofNullable(ds.findById(id));

            if (existingDealership.isPresent()) {

                Dealership updatedDealership = ds.updateDealership(dealership);

                // 200 OK
                return ResponseEntity.ok(updatedDealership);

            }   else {

                    // 404 Not found
                    return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {

            // 500 Internal server error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}
