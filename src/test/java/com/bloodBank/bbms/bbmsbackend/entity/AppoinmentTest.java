package com.bloodBank.bbms.bbmsbackend.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    private Appointment appointment;

    @BeforeEach
    void setUp() {
        appointment = new Appointment();
    }

    @Test
    void testIdSetterGetter() {
        appointment.setId(1);
        assertEquals(1, appointment.getId());
    }

    @Test
    void testNameSetterGetter() {
        appointment.setName("John Doe");
        assertEquals("John Doe", appointment.getName());
    }

    @Test
    void testBloodTypeSetterGetter() {
        appointment.setBloodType("A+");
        assertEquals("A+", appointment.getBloodType());
    }

    @Test
    void testDateNeededSetterGetter() {
        appointment.setDateNeeded("2023-12-10");
        assertEquals("2023-12-10", appointment.getDateNeeded());
    }

    @Test
    void testAgeSetterGetter() {
        appointment.setAge(30);
        assertEquals(30, appointment.getAge());
    }

    @Test
    void testPhoneSetterGetter() {
        appointment.setPhone("1234567890");
        assertEquals("1234567890", appointment.getPhone());
    }

    @Test
    void testEmailSetterGetter() {
        appointment.setEmail("johndoe@example.com");
        assertEquals("johndoe@example.com", appointment.getEmail());
    }

    @Test
    void testBloodAmountSetterGetter() {
        appointment.setBloodAmount("2 units");
        assertEquals("2 units", appointment.getBloodAmount());
    }

    @Test
    void testMedicalInjuriesSetterGetter() {
        appointment.setMedicalInjuries("None");
        assertEquals("None", appointment.getMedicalInjuries());
    }

    @Test
    void testLocationSetterGetter() {
        appointment.setLocation("City Hospital");
        assertEquals("City Hospital", appointment.getLocation());
    }

    @Test
    void testRoleSetterGetter() {
        appointment.setRole("Donor");
        assertEquals("Donor", appointment.getRole());
    }

    @Test
    void testAppointmentConstructor() {
        Appointment newAppointment = new Appointment(2, "Jane Doe", "O-", "2023-12-15", 28, "0987654321", "janedoe@example.com", "1 unit", "None", "Local Clinic", "Recipient");
        assertEquals(2, newAppointment.getId());
        assertEquals("Jane Doe", newAppointment.getName());
        assertEquals("O-", newAppointment.getBloodType());
        assertEquals("2023-12-15", newAppointment.getDateNeeded());
        assertEquals(28, newAppointment.getAge());
        assertEquals("0987654321", newAppointment.getPhone());
        assertEquals("janedoe@example.com", newAppointment.getEmail());
        assertEquals("1 unit", newAppointment.getBloodAmount());
        assertEquals("None", newAppointment.getMedicalInjuries());
        assertEquals("Local Clinic", newAppointment.getLocation());
        assertEquals("Recipient", newAppointment.getRole());
    }
}
