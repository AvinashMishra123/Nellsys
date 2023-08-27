package com.example.NellsysServerApplicant.repository;

import com.example.NellsysServerApplicant.Entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike,Long> {
}
