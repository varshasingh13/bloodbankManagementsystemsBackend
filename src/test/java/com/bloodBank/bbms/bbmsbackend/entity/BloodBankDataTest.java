package com.bloodBank.bbms.bbmsbackend.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BloodBankDataTest {

    private BloodBankData bloodBankData;

    @BeforeEach
    void setUp() {
        bloodBankData = new BloodBankData(1, "500ml", "A+");
    }

    @Test
    void testConstructor() {
        assertEquals(1, bloodBankData.getId());
        assertEquals("500ml", bloodBankData.getQuantity());
        assertEquals("A+", bloodBankData.getBloodType());
    }

    @Test
    void testSetAndGetId() {
        bloodBankData.setId(2);
        assertEquals(2, bloodBankData.getId());
    }

    @Test
    void testSetAndGetQuantity() {
        bloodBankData.setQuantity("250ml");
        assertEquals("250ml", bloodBankData.getQuantity());
    }

    @Test
    void testSetAndGetBloodType() {
        bloodBankData.setBloodType("O-");
        assertEquals("O-", bloodBankData.getBloodType());
    }
}
