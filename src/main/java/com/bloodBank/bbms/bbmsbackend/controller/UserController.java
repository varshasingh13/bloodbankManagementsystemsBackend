package com.bloodBank.bbms.bbmsbackend.controller;

import com.bloodBank.bbms.bbmsbackend.LoginResponse;
import com.bloodBank.bbms.bbmsbackend.dto.AppointmentDto;
import com.bloodBank.bbms.bbmsbackend.dto.BloodAvailabilityDto;
import com.bloodBank.bbms.bbmsbackend.dto.LoginDto;
import com.bloodBank.bbms.bbmsbackend.dto.SignUpDto;
import com.bloodBank.bbms.bbmsbackend.entity.Appointment;
import com.bloodBank.bbms.bbmsbackend.entity.BloodBankData;
import com.bloodBank.bbms.bbmsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
@Autowired
private UserService userService;
    @PostMapping(path = "/user/save")
    public String saveUser(@RequestBody SignUpDto signUpDto)
    {
        String id = userService.addUser(signUpDto);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto)
    {
        LoginResponse loginResponse = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
//    @PostMapping(path = "/admin/login")
//    public ResponseEntity<?> loginadmin(@RequestBody LoginDto loginDto) {
//        LoginResponse loginResponse = userService.loginUser(loginDto);
//        System.out.println("NewOne" + loginResponse.getMessage());
//    }

    @PostMapping(path = "/bookAppointment")
    public String bookDonorAppointment(@RequestBody AppointmentDto appointmentDto)
    {
        String id = userService.newAppointment(appointmentDto);
        return id;
    }

    @GetMapping("/upcomingAppointments")
    public ResponseEntity<List<Appointment>> getUpcomingAppointments() {
        List<Appointment> upcomingAppointments = userService.getUpcomingAppointmentsForUser();
        return ResponseEntity.ok(upcomingAppointments);
    }

    @GetMapping("/getReceipientData")
    public ResponseEntity<List<Appointment>> getReceipientData() {
        List<Appointment> receipientData = userService.getReceipientData();
        return ResponseEntity.ok(receipientData);
    }

    @GetMapping("/getDonorData")
    public ResponseEntity<List<Appointment>> getDonorData() {
        List<Appointment> donorData = userService.getDonorData();
        return ResponseEntity.ok(donorData);
    }

    @GetMapping("/adminNewAppointments")
    public ResponseEntity<List<Appointment>> getAdminNewAppointments() {
        List<Appointment> adminNewAppointments = userService.getAdminNewAppointments();
        return ResponseEntity.ok(adminNewAppointments);
    }

    @GetMapping("/adminPastAppointments")
    public ResponseEntity<List<Appointment>> getAdminPastAppointments() {
        List<Appointment> adminPastAppointments = userService.getAdminPastAppointments();
        return ResponseEntity.ok(adminPastAppointments);
    }

    @GetMapping("/getBloodBankdata")
    public ResponseEntity<List<BloodBankData>> getBloodBankdata() {
        List<BloodBankData> bloodBankData = userService.getBloodBankdata();
        return ResponseEntity.ok(bloodBankData);
    }


    @GetMapping("/pastDonorAppointments")
    public ResponseEntity<List<Appointment>> pastDonorAppointments() {
        List<Appointment> pastDonorData = userService.getPastDonorData();
        return ResponseEntity.ok(pastDonorData);
    }



    @GetMapping(path = "/test")
    public String demo(){

        return "Hi";
    }

    @GetMapping("/bloodAvailability")
    public String getBloodAvailability(@RequestParam String bloodType, @RequestParam String quantity) {
         return userService.checkBloodAvailability(bloodType, quantity);

    }

 


}