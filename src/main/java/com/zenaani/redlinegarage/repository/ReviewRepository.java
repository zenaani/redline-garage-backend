package com.zenaani.redlinegarage.repository;

import com.zenaani.redlinegarage.data.Accessory;
import com.zenaani.redlinegarage.data.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findByAccessoryId(Long accessoryId, Pageable pageable);
}
