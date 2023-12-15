package com.bloodBank.bbms.bbmsbackend.controller;

import com.bloodBank.bbms.bbmsbackend.LoginResponse;
import com.bloodBank.bbms.bbmsbackend.dto.AppointmentDto;
import com.bloodBank.bbms.bbmsbackend.dto.SignUpDto;
import com.bloodBank.bbms.bbmsbackend.dto.LoginDto;
import com.bloodBank.bbms.bbmsbackend.entity.Appointment;
import com.bloodBank.bbms.bbmsbackend.entity.BloodBankData;
import com.bloodBank.bbms.bbmsbackend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        // Optional setup can go here.
    }

    @Test
    void testSaveUser() {
        SignUpDto signUpDto = new SignUpDto(1, "user@example.com", "password123", "John", "Doe", "123 Main St", "CountryName", 123456, "1234567890", "None", "A+", 30, "Male");

        when(userService.addUser(signUpDto)).thenReturn("1");

        String response = userController.saveUser(signUpDto);

        assertEquals("1", response);
        verify(userService).addUser(signUpDto);
    }

    @Test
    void testLoginUser() {
        LoginDto loginDto = new LoginDto();
        LoginResponse loginResponse = new LoginResponse();
        when(userService.loginUser(loginDto)).thenReturn(loginResponse);

        ResponseEntity<?> response = userController.loginUser(loginDto);

        assertEquals(ResponseEntity.ok(loginResponse), response);
        verify(userService).loginUser(loginDto);
    }

    // ...

    @Test
    void testBookDonorAppointment() {
        AppointmentDto appointmentDto = new AppointmentDto(1, "John Doe", "A+", "2023-12-05", "1234567890", "johndoe@example.com", "None", "500ml", 30, "City Hospital", "Donor");

        when(userService.newAppointment(appointmentDto)).thenReturn("appointmentId");

        String response = userController.bookDonorAppointment(appointmentDto);

        assertEquals("appointmentId", response);
        verify(userService).newAppointment(appointmentDto);
    }

    @Test
    void testGetUpcomingAppointments() {
        List<Appointment> mockAppointments = Arrays.asList(new Appointment(), new Appointment());
        when(userService.getUpcomingAppointmentsForUser()).thenReturn(mockAppointments);

        ResponseEntity<List<Appointment>> response = userController.getUpcomingAppointments();

        assertEquals(ResponseEntity.ok(mockAppointments), response);
        verify(userService).getUpcomingAppointmentsForUser();
    }

    @Test
    void testGetReceipientData() {
        List<Appointment> mockAppointments = Arrays.asList(new Appointment(), new Appointment());
        when(userService.getReceipientData()).thenReturn(mockAppointments);

        ResponseEntity<List<Appointment>> response = userController.getReceipientData();

        assertEquals(ResponseEntity.ok(mockAppointments), response);
        verify(userService).getReceipientData();
    }

    @Test
    void testGetDonorData() {
        List<Appointment> mockAppointments = Arrays.asList(new Appointment(), new Appointment());
        when(userService.getDonorData()).thenReturn(mockAppointments);

        ResponseEntity<List<Appointment>> response = userController.getDonorData();

        assertEquals(ResponseEntity.ok(mockAppointments), response);
        verify(userService).getDonorData();
    }

    @Test
    void testGetBloodBankdata() {
        List<BloodBankData> mockData = Arrays.asList(new BloodBankData(), new BloodBankData());
        when(userService.getBloodBankdata()).thenReturn(mockData);

        ResponseEntity<List<BloodBankData>> response = userController.getBloodBankdata();

        assertEquals(ResponseEntity.ok(mockData), response);
        verify(userService).getBloodBankdata();
    }

    @Test
    void testDemo() {
        String response = userController.demo();
        assertEquals("Hi", response);
    }

    @Test
    void testGetBloodAvailability() {
        when(userService.checkBloodAvailability("A+", "2L")).thenReturn("Available");

        String response = userController.getBloodAvailability("A+", "2L");

        assertEquals("Available", response);
        verify(userService).checkBloodAvailability("A+", "2L");
    }

// ...

    @Test
    void testGetAdminNewAppointments() {
        List<Appointment> mockAppointments = Arrays.asList(new Appointment(), new Appointment());
        when(userService.getAdminNewAppointments()).thenReturn(mockAppointments);

        ResponseEntity<List<Appointment>> response = userController.getAdminNewAppointments();

        assertEquals(ResponseEntity.ok(mockAppointments), response);
        verify(userService).getAdminNewAppointments();
    }

    @Test
    void testGetAdminPastAppointments() {
        List<Appointment> mockAppointments = Arrays.asList(new Appointment(), new Appointment());
        when(userService.getAdminPastAppointments()).thenReturn(mockAppointments);

        ResponseEntity<List<Appointment>> response = userController.getAdminPastAppointments();

        assertEquals(ResponseEntity.ok(mockAppointments), response);
        verify(userService).getAdminPastAppointments();
    }



// ...

}
