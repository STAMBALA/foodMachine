package com.food.machine.config;

import com.food.machine.service.BikeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class WebConfig {
    private final BikeService service;

    public WebConfig(@Qualifier("bikeServiceImpl") BikeService service) {
        this.service = service;
    }
}
