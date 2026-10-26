package com.zenaani.redlinegarage.controller;

import com.zenaani.redlinegarage.data.response.AccessoryResponse;
import com.zenaani.redlinegarage.data.response.PagedResponse;
import com.zenaani.redlinegarage.data.response.ReviewResponse;
import com.zenaani.redlinegarage.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:61175")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{accessoryId}/reviews")
    public PagedResponse<ReviewResponse> getReviewsByAccessory(
            @PathVariable long accessoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);

        Page<ReviewResponse> reviewPage = reviewService.getReviewsByAccessory(accessoryId, pageRequest);

        return PagedResponse.from(reviewPage);
    }
}
