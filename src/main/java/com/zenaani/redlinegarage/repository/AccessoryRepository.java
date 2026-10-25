package com.zenaani.redlinegarage.repository;

import com.zenaani.redlinegarage.data.Accessory;
import com.zenaani.redlinegarage.data.Bike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessoryRepository extends JpaRepository<Accessory, Long> {

    Page<Accessory> findByBikeId(Long bikeId, Pageable pageable);

}
