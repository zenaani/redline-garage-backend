package com.zenaani.redlinegarage.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "performance_metrics")
public class PerformanceMetric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "bike_id", nullable = false)
    private Bike bike;

    private Double zeroToSixtyBest;
    private Double zeroToSixtyAvg;

    private Double zeroToHundredBest;
    private Double zeroToHundredAvg;

    private Double topSpeedTestedKmh;

    private Double quarterMileBest;
    private Double quarterMileAvg;

    @Enumerated(EnumType.STRING)
    private ConfidenceLevel confidenceLevel;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
