package com.portal.springboot.repository;

import com.portal.springboot.model.MedicalData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalDataRepository extends JpaRepository<MedicalData, Long> {

}