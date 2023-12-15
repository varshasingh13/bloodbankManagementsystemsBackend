package com.bloodBank.bbms.bbmsbackend.service.serviceImpl;

import com.bloodBank.bbms.bbmsbackend.LoginResponse;
import com.bloodBank.bbms.bbmsbackend.dto.AppointmentDto;
import com.bloodBank.bbms.bbmsbackend.dto.LoginDto;
import com.bloodBank.bbms.bbmsbackend.dto.SignUpDto;
import com.bloodBank.bbms.bbmsbackend.entity.Appointment;
import com.bloodBank.bbms.bbmsbackend.entity.BloodBankData;
import com.bloodBank.bbms.bbmsbackend.entity.User;
import com.bloodBank.bbms.bbmsbackend.repository.AppointmentRepository;
import com.bloodBank.bbms.bbmsbackend.repository.BloodBankDataRepository;
import com.bloodBank.bbms.bbmsbackend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private BloodBankDataRepository bloodBankDataRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        // Additional setup if necessary
    }

    @Test
    void testAddUser() {
        SignUpDto signUpDto = new SignUpDto(1, "user@example.com", "encodedPassword", "John", "Doe", "123 Main St", "CountryName", 123456, "1234567890", "None", "A+", 30, "Male");
        User user = new User();
        user.setEmail("user@example.com");
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        String result = userService.addUser(signUpDto);

        assertEquals(user.getEmail(), result);
        verify(userRepository).save(any(User.class));
        verify(passwordEncoder).encode(anyString());
    }

    @Test
    void testLoginUser() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("John@email.com");;
        loginDto.setPassword("NotencodedPassword");
        User user = new User();
        user.setEmail("John@email.com");;
        user.setPassword("encodedPassword");
        when(userRepository.findByEmail(loginDto.getEmail())).thenReturn(user);
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);

        LoginResponse result;
        result = userService.loginUser(loginDto);

        assertEquals("Login Failed", result.getMessage());
        assertEquals(false, result.getStatus());
        verify(userRepository).findByEmail(loginDto.getEmail());
        verify(passwordEncoder).matches(anyString(), anyString());
    }

    @Test
    void testNewAppointment() {
        AppointmentDto appointmentDto = new AppointmentDto(1, "John Doe", "A+", "2023-12-05", "1234567890", "johndoe@example.com", "None", "500ml", 30, "City Hospital", "Donor");
        Appointment appointment = new Appointment();
        appointment.setName("John Doe");
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        String result = userService.newAppointment(appointmentDto);

        assertEquals(appointment.getName(), result);
        verify(appointmentRepository).save(any(Appointment.class));
    }

    @Test
    void testGetUpcomingAppointmentsForUser() {
        List<Appointment> mockAppointments = Collections.singletonList(new Appointment());
        when(appointmentRepository.findByEmail(anyString())).thenReturn(mockAppointments);

        List<Appointment> result = userService.getUpcomingAppointmentsForUser();

        assertEquals(mockAppointments, result);
        verify(appointmentRepository).findByEmail(anyString());
    }

    @Test
    void testGetReceipientData() {
        List<Appointment> mockAppointments = Collections.singletonList(new Appointment());
        when(appointmentRepository.findByRole("recipient")).thenReturn(mockAppointments);

        List<Appointment> result = userService.getReceipientData();

        assertEquals(mockAppointments, result);
        verify(appointmentRepository).findByRole("recipient");
    }

    @Test
    void testGetDonorData() {
        List<Appointment> mockAppointments = Collections.singletonList(new Appointment());
        when(appointmentRepository.findByRole("donor")).thenReturn(mockAppointments);

        List<Appointment> result = userService.getDonorData();

        assertEquals(mockAppointments, result);
        verify(appointmentRepository).findByRole("donor");
    }

    @Test
    void testGetAdminNewAppointments() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Appointment pastAppointment = new Appointment(1, "John Doe", "A+", dateFormat.format(new Date(System.currentTimeMillis() - 86400000)), 12, "johndoe@example.com", "None", "500ml", "30", "City Hospital", "Donor");
        Appointment futureAppointment = new Appointment(2, "Jane Doe", "B+", dateFormat.format(new Date(System.currentTimeMillis() + 86400000)), 12, "janedoe@example.com", "Minor", "1L", "28", "Town Clinic", "Recipient");
        List<Appointment> mockAppointments = Arrays.asList(pastAppointment, futureAppointment);

        when(appointmentRepository.findAll()).thenReturn(mockAppointments);

        List<Appointment> result = userService.getAdminNewAppointments();

        // Filter future appointments
        List<Appointment> expectedAppointments = mockAppointments.stream()
                .filter(a -> {
                    try {
                        return dateFormat.parse(a.getDateNeeded()).after(new Date());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                })
                .collect(Collectors.toList());

        assertEquals(expectedAppointments, result);
        verify(appointmentRepository).findAll();
    }

/*    @Test
    void testGetAdminPastAppointments() {
        // Assuming you have a method to create a list of past appointments
        List<Appointment> mockAppointments = createMockPastAppointments();
        when(appointmentRepository.findAll()).thenReturn(mockAppointments);

        List<Appointment> result = userService.getAdminPastAppointments();

        // Assuming you have a method to filter past appointments
        List<Appointment> expectedAppointments = filterPastAppointments(mockAppointments);
        assertEquals(expectedAppointments, result);
        verify(appointmentRepository).findAll();
    }*/

    @Test
    void testGetBloodBankdata() {
        BloodBankData bloodBankData = new BloodBankData(1,"","");
        List<BloodBankData> mockData = Collections.singletonList(new BloodBankData());
        when(bloodBankDataRepository.findAll()).thenReturn(mockData);

        List<BloodBankData> result = userService.getBloodBankdata();

        assertEquals(mockData, result);
        verify(bloodBankDataRepository).findAll();
    }

    @Test
    void testCheckBloodAvailability() {
        List<BloodBankData> mockData = Collections.singletonList(new BloodBankData());
        when(bloodBankDataRepository.findByBloodTypeAndQuantityGreaterThanEqual(anyString(), anyString())).thenReturn(mockData);

        String result = userService.checkBloodAvailability("A+", "1L");

        assertEquals("Yes", result);
        verify(bloodBankDataRepository).findByBloodTypeAndQuantityGreaterThanEqual(anyString(), anyString());
    }

}
