package com.bloodBank.bbms.bbmsbackend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginDtoTest {

    private LoginDto loginDto;

    @BeforeEach
    void setUp() {
        loginDto = new LoginDto();
        loginDto.setEmail("user@example.com");
        loginDto.setPassword("password123");
    }

    @Test
    void testGetterMethods() {
        assertEquals("user@example.com", loginDto.getEmail());
        assertEquals("password123", loginDto.getPassword());
    }

    @Test
    void testSetterMethods() {
        loginDto.setEmail("newuser@example.com");
        loginDto.setPassword("newpassword123");

        assertEquals("newuser@example.com", loginDto.getEmail());
        assertEquals("newpassword123", loginDto.getPassword());
    }
}
