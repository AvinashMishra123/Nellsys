package com.example.NellsysServerApplicant.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class DriverDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other attributes

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bike getSelectedBike() {
        return selectedBike;
    }

    public void setSelectedBike(Bike selectedBike) {
        this.selectedBike = selectedBike;
    }

    @ManyToOne
    private Bike selectedBike;

}
