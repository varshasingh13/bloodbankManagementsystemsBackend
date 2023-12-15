package com.bloodBank.bbms.bbmsbackend.dto;

import lombok.Data;

@Data
public class AppointmentDto {

    private Integer id;


    private String name;

    private String bloodType;

    private String dateNeeded;

    private String phone;

    private String email;

    private String medicalInjuries;

    private String bloodAmount;

    private Integer age;

    private String location;

    private String role;

    public AppointmentDto(Integer id, String name, String bloodType, String dateNeeded, String phone, String email, String medicalInjuries, String bloodAmount, Integer age, String location, String role) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
        this.dateNeeded = dateNeeded;
        this.phone = phone;
        this.email = email;
        this.medicalInjuries = medicalInjuries;
        this.bloodAmount = bloodAmount;
        this.age = age;
        this.location = location;
        this.role = role;
    }
}
