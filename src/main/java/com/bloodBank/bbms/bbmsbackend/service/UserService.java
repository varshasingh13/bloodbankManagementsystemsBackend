package com.bloodBank.bbms.bbmsbackend.service;

import com.bloodBank.bbms.bbmsbackend.LoginResponse;
import com.bloodBank.bbms.bbmsbackend.dto.AppointmentDto;
import com.bloodBank.bbms.bbmsbackend.dto.BloodAvailabilityDto;
import com.bloodBank.bbms.bbmsbackend.dto.LoginDto;
import com.bloodBank.bbms.bbmsbackend.dto.SignUpDto;
import com.bloodBank.bbms.bbmsbackend.entity.Appointment;
import com.bloodBank.bbms.bbmsbackend.entity.BloodBankData;

import java.util.List;

public interface UserService {
     String addUser(SignUpDto signUpDto);
     LoginResponse loginUser(LoginDto loginDto);
      String newAppointment(AppointmentDto appointmentDto);
    String checkBloodAvailability(String bloodType, String quantity);
    List<Appointment> getUpcomingAppointmentsForUser();

    List<BloodBankData> getBloodBankdata();
    List<Appointment> getReceipientData();
    List<Appointment> getAdminNewAppointments();
    List<Appointment> getAdminPastAppointments();
    List<Appointment> getDonorData();
    List<Appointment> getPastDonorData();

}