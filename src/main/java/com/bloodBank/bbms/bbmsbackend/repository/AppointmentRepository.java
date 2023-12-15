package com.bloodBank.bbms.bbmsbackend.repository;

import com.bloodBank.bbms.bbmsbackend.entity.Appointment;
import com.bloodBank.bbms.bbmsbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

     List<Appointment> findAll();

     List<Appointment> findByEmail(String email);

     List<Appointment> findByRole(String role);

}