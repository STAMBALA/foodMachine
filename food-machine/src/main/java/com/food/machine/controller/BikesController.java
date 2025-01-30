package com.food.machine.controller;

import com.food.machine.entity.BikeEntity;
import com.food.machine.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/bikes")
@SuppressWarnings("All")
public class BikesController {

    /** @Service("bikeServiceFeebackImpl") it's work's without Primary and Profile annotation but need to provide @Qualifier annotation in controller class
     @Profile("feedback") it's work's  based on the condition bean ambiance
     @Primary its work's firstly **/

    @Autowired
    @Qualifier("bikeServiceImpl")

    private BikeService bikeService;

    public BikesController(@Qualifier("bikeServiceImpl") BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @PostMapping("/bikeModel")
    public ResponseEntity<ArrayList<BikeEntity>> createBikeModels(@RequestBody ArrayList<BikeEntity> bikesList) {
        ArrayList<BikeEntity> bikes = bikeService.bikeModels(bikesList);
        return new ResponseEntity<ArrayList<BikeEntity>>(bikes, HttpStatus.CREATED);
    }

    @GetMapping("/All bikes")
    public ResponseEntity<ArrayList<BikeEntity>> getAllBikes() {
        return ResponseEntity.ok(bikeService.getAllBikes());
    }

    @GetMapping("/feedback")
    public String getFeedback(String feedback) {
        return bikeService.vehicleService(feedback);
    }
}
