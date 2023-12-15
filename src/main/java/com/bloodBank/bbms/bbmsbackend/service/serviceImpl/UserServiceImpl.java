package com.bloodBank.bbms.bbmsbackend.service.serviceImpl;

import com.bloodBank.bbms.bbmsbackend.LoginResponse;
import com.bloodBank.bbms.bbmsbackend.dto.AppointmentDto;
import com.bloodBank.bbms.bbmsbackend.dto.BloodAvailabilityDto;
import com.bloodBank.bbms.bbmsbackend.dto.LoginDto;
import com.bloodBank.bbms.bbmsbackend.dto.SignUpDto;
import com.bloodBank.bbms.bbmsbackend.entity.Appointment;
import com.bloodBank.bbms.bbmsbackend.entity.BloodBankData;
import com.bloodBank.bbms.bbmsbackend.entity.User;
import com.bloodBank.bbms.bbmsbackend.repository.BloodBankDataRepository;
import com.bloodBank.bbms.bbmsbackend.repository.UserRepository;
import com.bloodBank.bbms.bbmsbackend.repository.AppointmentRepository;
import com.bloodBank.bbms.bbmsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private AppointmentRepository  appointmentRepository;

    @Autowired
    private BloodBankDataRepository bloodBankDataRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(SignUpDto signUpDto) {

        User user = new User(
                signUpDto.getEmail(),
                this.passwordEncoder.encode(signUpDto.getPassword()),
                //signUpDto.getPassword(),
                signUpDto.getFirstName(),
                signUpDto.getLastName(),
                signUpDto.getAddress(),
                signUpDto.getCountry(),
                signUpDto.getPincode(),
                signUpDto.getPhone(),
                signUpDto.getMedicalHistory(),
                signUpDto.getBloodGroup(),
                signUpDto.getAge(),
                signUpDto.getSex());

        userRepository.save(user);

        return user.getEmail();
    }
    SignUpDto signUpDto;

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }


    }

    @Override
    public String newAppointment(AppointmentDto appointmentDto) {

        Appointment appointment = new Appointment(
                appointmentDto.getId(),
                appointmentDto.getName(),
                appointmentDto.getBloodType(),
                appointmentDto.getDateNeeded(),
                appointmentDto.getAge(),
                appointmentDto.getPhone(),
                appointmentDto.getEmail(),
                appointmentDto.getBloodAmount(),
                appointmentDto.getMedicalInjuries(),
                appointmentDto.getLocation(),
                appointmentDto.getRole()

        );

        appointmentRepository.save(appointment);

        return appointment.getName();
    }

    public List<Appointment> getUpcomingAppointmentsForUser() {
         List<Appointment> appointmentsByEmail = appointmentRepository.findByEmail("sagar@gcl.nic");

        return appointmentsByEmail;
    }

    public List<Appointment> getReceipientData() {
        List<Appointment> appointmentsByRoleRecipient = appointmentRepository.findByRole("recipient");

        return appointmentsByRoleRecipient;
    }

    public List<Appointment> getDonorData() {
        List<Appointment> appointmentsByRoleDonor = appointmentRepository.findByRole("donor");

        return appointmentsByRoleDonor;
    }
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    public List<Appointment> getAdminNewAppointments() {
        List<Appointment> allAppointments = appointmentRepository.findAll();

        List<Appointment> futureAppointments = new ArrayList<>();

        for (Appointment appointment : allAppointments) {
            try {
                Date appointmentDate = new SimpleDateFormat(DATE_FORMAT).parse(appointment.getDateNeeded());

                if (appointmentDate.after(new Date())) {
                    futureAppointments.add(appointment);
                }
            } catch (ParseException e) {

                e.printStackTrace();
            }
        }
        return futureAppointments;
    }

    public List<Appointment> getAdminPastAppointments() {
        List<Appointment> allAppointments = appointmentRepository.findAll();

        List<Appointment> pastAppointments = new ArrayList<>();

        for (Appointment appointment : allAppointments) {
            try {
                Date appointmentDate = new SimpleDateFormat(DATE_FORMAT).parse(appointment.getDateNeeded());

                if (appointmentDate.before(new Date())) {

                    pastAppointments.add(appointment);
                }
            } catch (ParseException e) {

                e.printStackTrace();
            }
        }
        return pastAppointments;
    }

    public List<BloodBankData> getBloodBankdata() {
         return bloodBankDataRepository.findAll();

    }

    public List<Appointment> getPastDonorData() {
        List<Appointment> appointmentsPastDonor = appointmentRepository.findByRole("donor");
        List<Appointment> pastDonorAppointments = new ArrayList<>();

        for (Appointment appointment : appointmentsPastDonor) {
            try {
                Date appointmentDate = new SimpleDateFormat(DATE_FORMAT).parse(appointment.getDateNeeded());

                if (appointmentDate.before(new Date())) {
                    pastDonorAppointments.add(appointment);
                }
            } catch (ParseException e) {

                e.printStackTrace();
            }
        }

        return pastDonorAppointments;
    }



    public String checkBloodAvailability( String bloodType, String quantity) {
         List<BloodBankData> bbdata= bloodBankDataRepository.findByBloodTypeAndQuantityGreaterThanEqual(bloodType, quantity);
        if (bbdata.size()>0 ){
            return "Yes";
        }
        else{
            return "No";
        }

    }

}