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
@Table(name = "engine_specs")
public class EngineSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "bike_id", nullable = false)
    private Bike bike;

    private Double engineCc;
    private String engineType;

    private Double maxPowerBhp;
    private Integer powerRpm;

    private Double maxTorqueNm;
    private Integer torqueRpm;

    private String transmission;
    private Double kerbWeightKg;

    private LocalDateTime createdAt = LocalDateTime.now();
}
