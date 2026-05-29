package com.zenaani.redlinegarage.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "bikes")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id",  nullable = false)
    private Brand brand;

    private String modelName;
    private String variant;
    private String segment;
    private String launchYear;
    private String glbModel;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engine_spec_id")
    private EngineSpec engineSpec;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_spec_id")
    private PerformanceMetric performanceMetric;

    private LocalDateTime createdAt = LocalDateTime.now();

}
