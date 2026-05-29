package com.zenaani.redlinegarage.data.response;

import com.zenaani.redlinegarage.data.PerformanceMetric;
import lombok.Builder;

@Builder
public record PerformanceMetricResponse(

        Long id,
        Double zeroToSixtyBest,
        Double zeroToSixtyAvg,

        Double zeroToHundredBest,
        Double zeroToHundredAvg,

        Double topSpeedTestedKmh,

        Double quarterMileBest,
        Double quarterMileAvg

) {

    public static PerformanceMetricResponse fromEntity(PerformanceMetric performanceMetric) {
        if (performanceMetric == null) return null;

        return PerformanceMetricResponse.builder()
                .id(performanceMetric.getId())
                .zeroToSixtyBest(performanceMetric.getZeroToSixtyBest())
                .zeroToSixtyAvg(performanceMetric.getZeroToSixtyAvg())
                .zeroToHundredBest(performanceMetric.getZeroToHundredBest())
                .zeroToHundredAvg(performanceMetric.getZeroToHundredAvg())
                .topSpeedTestedKmh(performanceMetric.getTopSpeedTestedKmh())
                .quarterMileBest(performanceMetric.getQuarterMileBest())
                .quarterMileAvg(performanceMetric.getQuarterMileAvg())
                .build();
    }
}
