package com.bloodBank.bbms.bbmsbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@Entity
//@AllArgsConstructor
@NoArgsConstructor
//@DynamicUpdate
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "pincode")
    private Integer pincode;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "medical_history", length = 500)
    private String medicalHistory;

    @Column(name = "blood_group", length = 5)
    private String bloodGroup;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex", length = 10)
    private String sex;

    @Column(name = "last_donated_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastDonated;




    public User(String email, String password, String firstName, String lastName, String address, String country, Integer pincode, String phone, String medicalHistory, String bloodGroup, Integer age, String sex) {

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

