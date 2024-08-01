package com.revature.controllers;

import com.revature.services.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealershipController {

    DealershipService ds;

    @Autowired
    public DealershipController(DealershipService ds){
        this.ds = ds;
    }


}
