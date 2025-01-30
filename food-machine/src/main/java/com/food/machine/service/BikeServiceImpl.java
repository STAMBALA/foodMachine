package com.food.machine.service;

import com.food.machine.Repository.BikeRepository;
import com.food.machine.entity.BikeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//@Primary
@Service("bikeServiceImpl")
public class BikeServiceImpl implements BikeService {

    /** @Service("bikeServiceFeebackImpl") it's work's without Primary and Profile annotation but need to provide @Qualifier annotation in controller class
     @Profile("feedback") it's work's  based on the condition bean ambiance
     @Primary its work's firstly **/

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public ArrayList<BikeEntity> bikeModels(ArrayList<BikeEntity> bikesList) {
        return new ArrayList<> (bikeRepository.saveAllAndFlush(bikesList));
    }

    @Override
    public ArrayList<BikeEntity> getAllBikes() {
        return new ArrayList<>(bikeRepository.findAll());
    }

    @Override
    public String vehicleService(String feedback) {
        return "GOOD";
    }
}
