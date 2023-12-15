package com.bloodBank.bbms.bbmsbackend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SignUpDto {

    private Integer id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String country;

    private Integer pincode;

    private String phone;

    private String medicalHistory;

    private String bloodGroup;

    private Integer age;

    private String sex;


    public SignUpDto(Integer id, String email, String password, String firstName, String lastName, String address, String country, Integer pincode, String phone, String medicalHistory, String bloodGroup, Integer age, String sex) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.pincode = pincode;
        this.phone = phone;
        this.medicalHistory = medicalHistory;
        this.bloodGroup = bloodGroup;
        this.age = age;
        this.sex = sex;
    }

}
