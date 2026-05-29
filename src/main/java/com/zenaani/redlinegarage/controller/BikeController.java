package com.zenaani.redlinegarage.controller;

import com.zenaani.redlinegarage.data.response.BikeDetailResponse;
import com.zenaani.redlinegarage.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/bikes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:61175")
public class BikeController {

    private final BikeService bikeService;

    @GetMapping("/{id}")
    public BikeDetailResponse getBike(@PathVariable Long id) {
        return bikeService.getBike(id);
    }

}
