package com.food.machine.service;

import com.food.machine.entity.BikeEntity;

import java.util.ArrayList;

public interface BikeService {
    ArrayList<BikeEntity> bikeModels(ArrayList<BikeEntity> bikesList);

    ArrayList<BikeEntity> getAllBikes();

    String vehicleService(String feedback);
}
