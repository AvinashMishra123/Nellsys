package com.example.NellsysServerApplicant.repository;

import com.example.NellsysServerApplicant.Entity.DriverDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<DriverDo,Long> {

    List<DriverDo> findBySelectedBikeIsNotNullAndRatingGreaterThanEqual(Integer minRating);

    List<DriverDo> findBySelectedBikeIsNotNull();

    List<DriverDo> findBySelectedBikeIsNull();

    List<DriverDo> findByRatingGreaterThanEqual(Integer minRating);
}
