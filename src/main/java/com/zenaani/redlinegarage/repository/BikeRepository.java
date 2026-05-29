package com.zenaani.redlinegarage.repository;

import com.zenaani.redlinegarage.data.Bike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {

    @EntityGraph(attributePaths = {
            "brand",
            "engineSpec",
            "performanceMetric"
    })
    Optional<Bike> findBikeById(Long id);

    Page<Bike> findByBrandId(Long brandId, Pageable pageable);

}
