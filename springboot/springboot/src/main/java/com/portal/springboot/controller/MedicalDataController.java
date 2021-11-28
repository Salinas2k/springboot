package com.portal.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.portal.springboot.exception.ResourceNotFoundException;
import com.portal.springboot.model.MedicalData;
import com.portal.springboot.repository.MedicalDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MedicalDataController {
    @Autowired
    private MedicalDataRepository medicalDataRepository;

    @GetMapping("medical")
    public List<MedicalData> getAllActivities() {
        return this.medicalDataRepository.findAll();
    }

    @GetMapping("medical/{id}")
    public ResponseEntity<MedicalData> getMedicalDataById(@PathVariable(value = "id") Long medicalDataId)
            throws ResourceNotFoundException {
        MedicalData medicalData = medicalDataRepository.findById(medicalDataId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Medical inform not found for this id :: " + medicalDataId));
        return ResponseEntity.ok().body(medicalData);
    }

    @PostMapping("medical")
    public MedicalData createMedicalData(@RequestBody MedicalData medicalData) {
        return medicalDataRepository.save(medicalData);
    }

    @DeleteMapping("medical")
    public Map<String, Boolean> deleteMedicalData(@PathVariable(value = "id") Long medicalDataId)
            throws ResourceNotFoundException {
        MedicalData medicalData = medicalDataRepository.findById(medicalDataId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Medal inform not found for this id :: " + medicalDataId));

        medicalDataRepository.delete(medicalData);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
