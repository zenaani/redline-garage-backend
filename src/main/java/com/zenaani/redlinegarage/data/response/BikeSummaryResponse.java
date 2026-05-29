package com.zenaani.redlinegarage.data.response;

import com.zenaani.redlinegarage.data.Bike;

public record BikeSummaryResponse(
        Long id,
        String modelName,
        String variant,
        String segment
) {
    public static BikeSummaryResponse fromEntity(Bike bike) {
        return new BikeSummaryResponse(
                bike.getId(),
                bike.getModelName(),
                bike.getVariant(),
                bike.getSegment()
        );
    }
}