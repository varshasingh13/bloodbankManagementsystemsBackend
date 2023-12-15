package com.bloodBank.bbms.bbmsbackend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SignUpDtoTest {

    private SignUpDto signUpDto;

    @BeforeEach
    void setUp() {
        signUpDto = new SignUpDto(1, "user@example.com", "password123", "John", "Doe", "123 Main St", "CountryName", 123456, "1234567890", "None", "A+", 30, "Male");
    }

    @Test
    void testConstructorAndGetterMethods() {
        assertEquals(1, signUpDto.getId());
        assertEquals("user@example.com", signUpDto.getEmail());
        assertEquals("password123", signUpDto.getPassword());
        assertEquals("John", signUpDto.getFirstName());
        assertEquals("Doe", signUpDto.getLastName());
        assertEquals("123 Main St", signUpDto.getAddress());
        assertEquals("CountryName", signUpDto.getCountry());
        assertEquals(123456, signUpDto.getPincode());
        assertEquals("1234567890", signUpDto.getPhone());
        assertEquals("None", signUpDto.getMedicalHistory());
        assertEquals("A+", signUpDto.getBloodGroup());
        assertEquals(30, signUpDto.getAge());
        assertEquals("Male", signUpDto.getSex());
    }

    @Test
    void testSetterMethods() {
        signUpDto.setId(2);
        signUpDto.setEmail("newuser@example.com");
        signUpDto.setPassword("newpassword123");
        signUpDto.setFirstName("Jane");
        signUpDto.setLastName("Smith");
        signUpDto.setAddress("456 Another St");
        signUpDto.setCountry("AnotherCountry");
        signUpDto.setPincode(654321);
        signUpDto.setPhone("0987654321");
        signUpDto.setMedicalHistory("Allergy");
        signUpDto.setBloodGroup("B+");
        signUpDto.setAge(28);
        signUpDto.setSex("Female");

        assertEquals(2, signUpDto.getId());
        assertEquals("newuser@example.com", signUpDto.getEmail());
        assertEquals("newpassword123", signUpDto.getPassword());
        assertEquals("Jane", signUpDto.getFirstName());
        assertEquals("Smith", signUpDto.getLastName());
        assertEquals("456 Another St", signUpDto.getAddress());
        assertEquals("AnotherCountry", signUpDto.getCountry());
        assertEquals(654321, signUpDto.getPincode());
        assertEquals("0987654321", signUpDto.getPhone());
        assertEquals("Allergy", signUpDto.getMedicalHistory());
        assertEquals("B+", signUpDto.getBloodGroup());
        assertEquals(28, signUpDto.getAge());
        assertEquals("Female", signUpDto.getSex());
    }
}
