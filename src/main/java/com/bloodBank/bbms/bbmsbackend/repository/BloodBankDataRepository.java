package com.bloodBank.bbms.bbmsbackend.repository;

import com.bloodBank.bbms.bbmsbackend.entity.Appointment;
import com.bloodBank.bbms.bbmsbackend.entity.BloodBankData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface BloodBankDataRepository extends JpaRepository<BloodBankData, Integer> {

     List<BloodBankData> findAll();
     List<BloodBankData> findByBloodTypeAndQuantityGreaterThanEqual(String bloodType, String quantity);
}