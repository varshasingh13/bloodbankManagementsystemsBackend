package com.bloodBank.bbms.bbmsbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
//@AllArgsConstructor
@NoArgsConstructor
//@DynamicUpdate
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "blood_type", length = 255)
    private String bloodType;

    @Column(name = "date_needed", length = 50)
    private String dateNeeded;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "blood_amount", length = 500)
    private String bloodAmount;

    @Column(name = "medical_injuries", length = 100)
    private String medicalInjuries;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "role", length = 100)
    private String role;


    public Appointment(Integer id, String name, String bloodType, String dateNeeded, Integer age, String phone,String email, String bloodAmount, String medicalInjuries, String location, String role) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
        this.dateNeeded = dateNeeded;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.bloodAmount = bloodAmount;
        this.medicalInjuries = medicalInjuries;
        this.location = location;
        this.role = role;
    }
}

