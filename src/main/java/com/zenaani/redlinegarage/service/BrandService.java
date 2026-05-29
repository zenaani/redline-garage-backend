package com.zenaani.redlinegarage.service;

import com.zenaani.redlinegarage.data.Brand;
import com.zenaani.redlinegarage.data.response.BikeSummaryResponse;
import com.zenaani.redlinegarage.data.response.BrandResponse;
import com.zenaani.redlinegarage.exception.ResourceNotFoundException;
import com.zenaani.redlinegarage.repository.BikeRepository;
import com.zenaani.redlinegarage.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final BikeRepository bikeRepository;

    public Page<BrandResponse> getAllBrands(Pageable pageable) {
        return brandRepository.findAll(pageable)
                .map(BrandResponse::fromEntity);
    }

    @Transactional(readOnly = true)
    public Page<BikeSummaryResponse> getBikesByBrand(Long brandId, Pageable pageable) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found"));

        return bikeRepository.findByBrandId(brand.getId(), pageable)
                .map(BikeSummaryResponse::fromEntity);
    }

}
