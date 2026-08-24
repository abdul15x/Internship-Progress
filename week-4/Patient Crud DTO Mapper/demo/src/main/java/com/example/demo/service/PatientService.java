package com.example.demo.service;

import com.example.demo.dto.PatientDTO;
import com.example.demo.mapper.PatientMapper;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    // CREATE
    public PatientDTO addPatient(PatientDTO dto) {

        Patient patient = PatientMapper.toEntity(dto);

        Patient savedPatient = repository.save(patient);

        return PatientMapper.toDTO(savedPatient);
    }

    // GET ALL
    public List<PatientDTO> getPatients() {

        return repository.findAll()
                .stream()
                .map(PatientMapper::toDTO)
                .collect(Collectors.toList());
    }

    // CUSTOM QUERY
    public List<PatientDTO> findByNameAndStatus(
            String name, String status) {

        return repository.findByNameAndStatus(name, status)
                .stream()
                .map(PatientMapper::toDTO)
                .collect(Collectors.toList());
    }
}