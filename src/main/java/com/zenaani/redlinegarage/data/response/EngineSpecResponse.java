package com.zenaani.redlinegarage.data.response;

import com.zenaani.redlinegarage.data.EngineSpec;
import lombok.Builder;

@Builder
public record EngineSpecResponse(
        Double engineCc,
        String engineType,

        Double maxPowerBhp,
        Integer powerRpm,

        Double maxTorqueNm,
        Integer torqueRpm,

        String transmission,
        Double kerbWeightKg
) {
    public static EngineSpecResponse fromEntity(EngineSpec engineSpec) {
        if (engineSpec == null) return null;

        return EngineSpecResponse.builder()
                .engineCc(engineSpec.getEngineCc())
                .engineType(engineSpec.getEngineType())
                .maxPowerBhp(engineSpec.getMaxPowerBhp())
                .powerRpm(engineSpec.getPowerRpm())
                .maxTorqueNm(engineSpec.getMaxTorqueNm())
                .torqueRpm(engineSpec.getTorqueRpm())
                .transmission(engineSpec.getTransmission())
                .kerbWeightKg(engineSpec.getKerbWeightKg())
                .build();
    }
}
