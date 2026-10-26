package com.zenaani.redlinegarage.controller;

import com.zenaani.redlinegarage.data.response.AccessoryResponse;
import com.zenaani.redlinegarage.data.response.BikeSummaryResponse;
import com.zenaani.redlinegarage.data.response.PagedResponse;
import com.zenaani.redlinegarage.service.AccessoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/bikes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:61175")
public class AccessoryController {

    private final AccessoryService accessoryService;

    @GetMapping("{bikeId}/accessories")
    public PagedResponse<AccessoryResponse> getAccessoriesByBike(
            @PathVariable long bikeId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {

        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);

        Page<AccessoryResponse> accessoryPage = accessoryService.getAccessoriesByBike(bikeId, pageRequest);

        return PagedResponse.from(accessoryPage);
    }

}
