package com.bloodBank.bbms.bbmsbackend.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private Date testDate;

    @BeforeEach
    void setUp() {
        testDate = new Date();
        user = new User("email@example.com", "password123", "John", "Doe", "123 Main St", "Country", 12345, "123-456-7890", "No allergies", "A+", 30, "Male");
        user.setLastDonated(testDate);
    }

    @Test
    void testUserCreation() {
        assertNotNull(user, "User should not be null");
    }

    @Test
    void testEmail() {
        assertEquals("email@example.com", user.getEmail(), "Email should match");
        user.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", user.getEmail(), "Email should be updated");
    }

    // ... similar tests for password, firstName, lastName ...

    @Test
    void testAddress() {
        assertEquals("123 Main St", user.getAddress(), "Address should match");
        user.setAddress("456 Elm St");
        assertEquals("456 Elm St", user.getAddress(), "Address should be updated");
    }

    @Test
    void testCountry() {
        assertEquals("Country", user.getCountry(), "Country should match");
        user.setCountry("Another Country");
        assertEquals("Another Country", user.getCountry(), "Country should be updated");
    }

    @Test
    void testPincode() {
        assertEquals(12345, user.getPincode(), "Pincode should match");
        user.setPincode(54321);
        assertEquals(54321, user.getPincode(), "Pincode should be updated");
    }

    @Test
    void testPhone() {
        assertEquals("123-456-7890", user.getPhone(), "Phone should match");
        user.setPhone("098-765-4321");
        assertEquals("098-765-4321", user.getPhone(), "Phone should be updated");
    }

    @Test
    void testMedicalHistory() {
        assertEquals("No allergies", user.getMedicalHistory(), "Medical history should match");
        user.setMedicalHistory("Allergic to penicillin");
        assertEquals("Allergic to penicillin", user.getMedicalHistory(), "Medical history should be updated");
    }

    @Test
    void testBloodGroup() {
        assertEquals("A+", user.getBloodGroup(), "Blood group should match");
        user.setBloodGroup("O-");
        assertEquals("O-", user.getBloodGroup(), "Blood group should be updated");
    }

    @Test
    void testAge() {
        assertEquals(30, user.getAge(), "Age should match");
        user.setAge(31);
        assertEquals(31, user.getAge(), "Age should be updated");
    }

    @Test
    void testSex() {
        assertEquals("Male", user.getSex(), "Sex should match");
        user.setSex("Female");
        assertEquals("Female", user.getSex(), "Sex should be updated");
    }

    @Test
    void testLastDonatedDate() {
        assertEquals(testDate, user.getLastDonated(), "Last donated date should match");
        Date newDate = new Date(testDate.getTime() + 100000);
        user.setLastDonated(newDate);
        assertEquals(newDate, user.getLastDonated(), "Last donated date should be updated");
    }

}

