package com.zenaani.redlinegarage.data.response;

import com.zenaani.redlinegarage.data.Brand;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BrandResponse {

    Long id;
    String name;
    String country;
    String logoUrl;

    public static BrandResponse fromEntity(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .country(brand.getCountry())
                .logoUrl(brand.getLogoUrl())
                .build();
    }

}
