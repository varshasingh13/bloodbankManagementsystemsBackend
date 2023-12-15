package com.bloodBank.bbms.bbmsbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
//@AllArgsConstructor
@NoArgsConstructor
//@DynamicUpdate
@Table(name = "blood_bank_detail")
public class BloodBankData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "quantity", nullable = false, length = 20)
    private String quantity;

    @Column(name = "blood_type", length = 255)
    private String bloodType;

    public BloodBankData(Integer id, String quantity, String bloodType) {
        this.id = id;
        this.quantity = quantity;
        this.bloodType = bloodType;
    }
}

