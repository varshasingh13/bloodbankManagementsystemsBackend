package com.bloodBank.bbms.bbmsbackend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BloodAvailabilityDtoTest {

    private BloodAvailabilityDto bloodAvailabilityDto;

    @BeforeEach
    void setUp() {
        bloodAvailabilityDto = new BloodAvailabilityDto("A+", "2L");
    }

    @Test
    void testConstructorAndGetterMethods() {
        assertEquals("A+", bloodAvailabilityDto.getBloodType());
        assertEquals("2L", bloodAvailabilityDto.getQuantity());
    }

    @Test
    void testSetterMethods() {
        bloodAvailabilityDto.setBloodType("O-");
        bloodAvailabilityDto.setQuantity("3L");

        assertEquals("O-", bloodAvailabilityDto.getBloodType());
        assertEquals("3L", bloodAvailabilityDto.getQuantity());
    }
}
