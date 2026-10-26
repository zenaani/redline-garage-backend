package com.zenaani.redlinegarage.data.response;

import com.zenaani.redlinegarage.data.Review;

import java.time.LocalDateTime;

public record ReviewResponse(
        Long id,
        String name,
        Double stars,
        String message,
        LocalDateTime createdAt
) {
    public static ReviewResponse fromEntity(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getName(),
                review.getStars(),
                review.getMessage(),
                review.getCreatedAt()
        );
    }
}
