package com.zenaani.redlinegarage.service;

import com.zenaani.redlinegarage.data.Review;
import com.zenaani.redlinegarage.data.response.AccessoryResponse;
import com.zenaani.redlinegarage.data.response.ReviewResponse;
import com.zenaani.redlinegarage.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public Page<ReviewResponse> getReviewsByAccessory(Long accessory_id, Pageable pageable) {
        return reviewRepository.findByAccessoryId(accessory_id, pageable).map(ReviewResponse::fromEntity);
    }
}
