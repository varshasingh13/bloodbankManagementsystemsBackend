package com.bloodBank.bbms.bbmsbackend.payload.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginMessageTest {

    private LoginMessage loginMessage;

    @BeforeEach
    void setUp() {
        loginMessage = new LoginMessage("Login successful", true);
    }

    @Test
    void testConstructorAndGetterMethods() {
        assertEquals("Login successful", loginMessage.getMessage());
        assertTrue(loginMessage.getStatus());
    }

    @Test
    void testSetterMethods() {
        loginMessage.setMessage("Login failed");
        loginMessage.setStatus(false);

        assertEquals("Login failed", loginMessage.getMessage());
        assertFalse(loginMessage.getStatus());
    }
}
