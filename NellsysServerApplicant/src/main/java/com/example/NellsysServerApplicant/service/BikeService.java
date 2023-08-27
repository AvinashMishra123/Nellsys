package com.example.NellsysServerApplicant.service;

import com.example.NellsysServerApplicant.Entity.Bike;
import com.example.NellsysServerApplicant.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public Bike createBike(Bike bike) {
        return bikeRepository.save(bike);
    }

    public Bike getBikeById(Long id) {
        return bikeRepository.findById(id).orElse(null);
    }


    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

}
