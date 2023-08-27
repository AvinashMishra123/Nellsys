package com.example.NellsysServerApplicant.controller;


import com.example.NellsysServerApplicant.Entity.Bike;
import com.example.NellsysServerApplicant.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bikes")
public class Bikecontroller {
    @Autowired
    private BikeService bikeService;

    @PostMapping
    public ResponseEntity<Bike> createBike(@RequestBody Bike bike) {
        Bike createdBike = bikeService.createBike(bike);
        return ResponseEntity.created(URI.create("/bikes/" + createdBike.getId())).body(createdBike);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBikeById(@PathVariable Long id) {
        Bike bike = bikeService.getBikeById(id);
        return ResponseEntity.ok(bike);
    }

    // Implement update and delete methods

    @GetMapping
    public ResponseEntity<List<Bike>> getAllBikes() {
        List<Bike> bikes = bikeService.getAllBikes();
        return ResponseEntity.ok(bikes);
    }
}
