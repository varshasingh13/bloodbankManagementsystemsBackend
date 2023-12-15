package com.bloodBank.bbms.bbmsbackend.dto;

import lombok.Data;

@Data
public class BloodAvailabilityDto {
    private String bloodType;
    private String quantity;

    public BloodAvailabilityDto(String bloodType, String quantity) {
        this.bloodType = bloodType;
        this.quantity = quantity;
    }
}