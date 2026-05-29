package com.zenaani.redlinegarage.controller;

import com.zenaani.redlinegarage.data.response.BikeSummaryResponse;
import com.zenaani.redlinegarage.data.response.BrandResponse;
import com.zenaani.redlinegarage.data.response.PagedResponse;
import com.zenaani.redlinegarage.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:61175")
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public PagedResponse<BrandResponse> getAllBrands(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {

        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);

        Page<BrandResponse> brandPage = brandService.getAllBrands(pageRequest);

        return PagedResponse.from(brandPage);
    }

    @GetMapping("/{brandId}/bikes")
    public PagedResponse<BikeSummaryResponse> getBikesByBrand(
            @PathVariable long brandId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "modelName") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {

        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);

        Page<BikeSummaryResponse> bikePage = brandService.getBikesByBrand(brandId, pageRequest);

        return PagedResponse.from(bikePage);
    }

}
