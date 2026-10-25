package com.zenaani.redlinegarage.service;

import com.zenaani.redlinegarage.data.Accessory;
import com.zenaani.redlinegarage.data.response.AccessoryResponse;
import com.zenaani.redlinegarage.repository.AccessoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccessoryService {

    private final AccessoryRepository accessoryRepository;

    @Transactional(readOnly = true)
    public Page<AccessoryResponse> getAccessoriesByBike(Long bike_id, Pageable pageable) {
        return accessoryRepository.findByBikeId(bike_id, pageable).map(AccessoryResponse::fromEntity);
    }
}
