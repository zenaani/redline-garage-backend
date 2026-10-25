package com.zenaani.redlinegarage.data.response;

import com.zenaani.redlinegarage.data.Accessory;

public record AccessoryResponse(
        Long id,
        String name,
        String description,
        String price,
        String imageUrl
) {
    public static AccessoryResponse fromEntity(Accessory accessory) {
        return new AccessoryResponse(
                accessory.getId(),
                accessory.getName(),
                accessory.getDescription(),
                accessory.getPrice(),
                accessory.getImageUrl()
        );
    }
}
