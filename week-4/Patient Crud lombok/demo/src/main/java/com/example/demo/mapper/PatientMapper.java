package com.example.demo.mapper;

import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Patient;

public class PatientMapper {

    public static Patient toEntity(PatientDTO dto) {

        Patient patient = new Patient();

        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setStatus(dto.getStatus());
        patient.setAge(dto.getAge());

        return patient;
    }

    public static PatientDTO toDTO(Patient patient) {

        PatientDTO dto = new PatientDTO();

        dto.setName(patient.getName());
        dto.setEmail(patient.getEmail());
        dto.setStatus(patient.getStatus());
        dto.setAge(patient.getAge());

        return dto;
    }
}