package com.example.NellsysServerApplicant.controller;

import com.example.NellsysServerApplicant.Entity.DriverDo;
import com.example.NellsysServerApplicant.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("/{driverId}/select-bike/{bikeId}")
    public ResponseEntity<Void> selectBike(@PathVariable Long driverId, @PathVariable Long bikeId) {
        driverService.selectBike(driverId, bikeId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{driverId}/deselect-bike")
    public ResponseEntity<Void> deselectBike(@PathVariable Long driverId) {
        driverService.deselectBike(driverId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<DriverDo>> getDriversWithCharacteristics(
            @RequestParam(required = false) Boolean hasSelectedBike,
            @RequestParam(required = false) Integer minRating
    ) {
        List<DriverDo> filteredDrivers = driverService.getDriversByCharacteristics(hasSelectedBike, minRating);
        return ResponseEntity.ok(filteredDrivers);
    }
}
