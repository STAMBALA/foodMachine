package com.food.machine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BikeEntity {
    @Id
    @Column(nullable = false, unique = true, length = 19)
    private String id;

    private String bikeName;
    private String bikeModel;
    private long bikePrice;
    private String color;
    private int cc;

    public BikeEntity() {
        this.id = generateCustomId();
    }

    private String generateCustomId() {
        return String.format("%04d-%04d-%04d-%04d",
                (int) (Math.random() * 10000),
                (int) (Math.random() * 10000),
                (int) (Math.random() * 10000),
                (int) (Math.random() * 10000));
    }
}
