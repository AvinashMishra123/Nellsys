package com.example.NellsysServerApplicant.service;

import com.example.NellsysServerApplicant.Entity.Bike;
import com.example.NellsysServerApplicant.Entity.DriverDo;
import com.example.NellsysServerApplicant.repository.BikeRepository;
import com.example.NellsysServerApplicant.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private BikeRepository bikeRepository;

    public void selectBike(Long driverId, Long bikeId) {
        Optional<DriverDo> optionalDriver = driverRepository.findById(driverId);
        Optional<Bike> optionalBike = bikeRepository.findById(bikeId);

        if (optionalDriver.isPresent() && optionalBike.isPresent()) {
            DriverDo driver = optionalDriver.get();
            Bike bike = optionalBike.get();

            driver.setSelectedBike(bike);
            driverRepository.save(driver);
        }
    }

    public void deselectBike(Long driverId) {
        Optional<DriverDo> optionalDriver = driverRepository.findById(driverId);

        if (optionalDriver.isPresent()) {
            DriverDo driver = optionalDriver.get();
            driver.setSelectedBike(null);
            driverRepository.save(driver);
        }
    }

    public List<DriverDo> getDriversByCharacteristics(Boolean hasSelectedBike, Integer minRating) {
        // Implement your filtering logic based on the provided characteristics
        // You can use the driverRepository to fetch drivers from the database
        // Return the filtered drivers
//        return null;
        List<DriverDo> filteredDrivers;
        if (hasSelectedBike != null && minRating != null) {
            filteredDrivers = driverRepository.findBySelectedBikeIsNotNullAndRatingGreaterThanEqual(minRating);
        } else if (hasSelectedBike != null) {
            if (hasSelectedBike) {
                filteredDrivers = driverRepository.findBySelectedBikeIsNotNull();
            } else {
                filteredDrivers = driverRepository.findBySelectedBikeIsNull();
            }
        } else if (minRating != null) {
            filteredDrivers = driverRepository.findByRatingGreaterThanEqual(minRating);
        } else {
            filteredDrivers = driverRepository.findAll();
        }

        return filteredDrivers;
    }

    // Other methods for driver-related operations



}

    // Other methods for driver-related operations



