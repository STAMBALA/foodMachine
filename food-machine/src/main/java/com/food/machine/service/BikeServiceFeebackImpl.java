package com.food.machine.service;

import com.food.machine.entity.BikeEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@SuppressWarnings("All")
@Service("bikeServiceFeebackImpl")
public class BikeServiceFeebackImpl implements BikeService {

    /** @Service("bikeServiceFeebackImpl") it's work's without Primary and Profile annotation but need to provide @Qualifier annotation in controller class
     @Profile("feedback") it's work's  based on the condition bean ambiance
     @Primary its work's firstly **/

    @Override
    public ArrayList<BikeEntity> bikeModels(ArrayList<BikeEntity> bikesList) {
        return null;
    }

    @Override
    public ArrayList<BikeEntity> getAllBikes() {
        return null;
    }

    @Override
    public String vehicleService(String feedback) {
        return "Average";
    }
}
