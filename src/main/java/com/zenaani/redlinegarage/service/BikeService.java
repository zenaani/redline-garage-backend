package com.zenaani.redlinegarage.service;

import com.zenaani.redlinegarage.data.Bike;
import com.zenaani.redlinegarage.data.response.BikeDetailResponse;
import com.zenaani.redlinegarage.exception.ResourceNotFoundException;
import com.zenaani.redlinegarage.repository.BikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BikeService {

    private final BikeRepository bikeRepository;

    @Transactional(readOnly = true)
    public BikeDetailResponse getBike(Long id) {

        Bike bike = bikeRepository.findBikeById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Bike not found with id: " + id)
                );
        return BikeDetailResponse.fromEntity(bike);
    }
}
