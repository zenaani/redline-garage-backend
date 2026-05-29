package com.zenaani.redlinegarage.data.response;

import com.zenaani.redlinegarage.data.Bike;

public record BikeDetailResponse(Long id, String brandName, String modelName, String variant, String segment,
                                 String launchYear, String glbModel, EngineSpecResponse engine, PerformanceMetricResponse performance) {

    public static BikeDetailResponse fromEntity(Bike bike) {
        return new BikeDetailResponse(
                bike.getId(),
                bike.getBrand().getName(),
                bike.getModelName(),
                bike.getVariant(),
                bike.getSegment(),
                bike.getLaunchYear(),
                bike.getGlbModel(),
                EngineSpecResponse.fromEntity(bike.getEngineSpec()),
                PerformanceMetricResponse.fromEntity(bike.getPerformanceMetric())
        );
    }


}
