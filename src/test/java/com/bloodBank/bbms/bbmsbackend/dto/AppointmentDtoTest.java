package com.bloodBank.bbms.bbmsbackend.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentDtoTest {

    private AppointmentDto appointmentDto;

    @BeforeEach
    void setUp() {
        appointmentDto = new AppointmentDto(1, "John Doe", "A+", "2023-12-05", "1234567890", "johndoe@example.com", "None", "500ml", 30, "City Hospital", "Donor");
    }

    @Test
    void testConstructorAndGetterMethods() {
        assertEquals(1, appointmentDto.getId());
        assertEquals("John Doe", appointmentDto.getName());
        assertEquals("A+", appointmentDto.getBloodType());
        assertEquals("2023-12-05", appointmentDto.getDateNeeded());
        assertEquals("1234567890", appointmentDto.getPhone());
        assertEquals("johndoe@example.com", appointmentDto.getEmail());
        assertEquals("None", appointmentDto.getMedicalInjuries());
        assertEquals("500ml", appointmentDto.getBloodAmount());
        assertEquals(30, appointmentDto.getAge());
        assertEquals("City Hospital", appointmentDto.getLocation());
        assertEquals("Donor", appointmentDto.getRole());
    }

    @Test
    void testSetterMethods() {
        appointmentDto.setId(2);
        appointmentDto.setName("Jane Doe");
        appointmentDto.setBloodType("O-");
        appointmentDto.setDateNeeded("2023-12-10");
        appointmentDto.setPhone("0987654321");
        appointmentDto.setEmail("janedoe@example.com");
        appointmentDto.setMedicalInjuries("Minor injuries");
        appointmentDto.setBloodAmount("1L");
        appointmentDto.setAge(28);
        appointmentDto.setLocation("Town Clinic");
        appointmentDto.setRole("Recipient");

        assertEquals(2, appointmentDto.getId());
        assertEquals("Jane Doe", appointmentDto.getName());
        assertEquals("O-", appointmentDto.getBloodType());
        assertEquals("2023-12-10", appointmentDto.getDateNeeded());
        assertEquals("0987654321", appointmentDto.getPhone());
        assertEquals("janedoe@example.com", appointmentDto.getEmail());
        assertEquals("Minor injuries", appointmentDto.getMedicalInjuries());
        assertEquals("1L", appointmentDto.getBloodAmount());
        assertEquals(28, appointmentDto.getAge());
        assertEquals("Town Clinic", appointmentDto.getLocation());
        assertEquals("Recipient", appointmentDto.getRole());
    }
}
