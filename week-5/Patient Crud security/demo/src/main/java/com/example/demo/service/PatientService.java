package com.example.demo.service;

import com.example.demo.dto.PatientDTO;
import com.example.demo.mapper.PatientMapper;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private static final Logger logger =
            LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository repository;


    // CREATE
    public PatientDTO addPatient(PatientDTO dto) {

        logger.info("Adding new patient: {}", dto.getName());

        Patient patient = PatientMapper.toEntity(dto);

        Patient savedPatient = repository.save(patient);

        logger.info(
                "Patient added successfully with ID: {}",
                savedPatient.getId()
        );

        return PatientMapper.toDTO(savedPatient);
    }


    // READ ALL
    public List<PatientDTO> getPatients() {

        logger.info("Getting all patients");

        return repository.findAll()
                .stream()
                .map(PatientMapper::toDTO)
                .toList();
    }


    // READ BY ID
    public PatientDTO getPatientById(String id) {

        logger.info("Searching patient with ID: {}", id);

        Patient patient = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Patient not found with ID: " + id
                        )
                );

        return PatientMapper.toDTO(patient);
    }


    // UPDATE
    public PatientDTO updatePatient(
            String id,
            PatientDTO dto) {

        logger.info("Updating patient with ID: {}", id);

        Patient patient = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Patient not found with ID: " + id
                        )
                );

        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setStatus(dto.getStatus());
        patient.setAge(dto.getAge());

        Patient updatedPatient =
                repository.save(patient);

        logger.info(
                "Patient updated successfully: {}",
                id
        );

        return PatientMapper.toDTO(updatedPatient);
    }


    // DELETE
    public void deletePatient(String id) {

        logger.info("Deleting patient with ID: {}", id);

        if (!repository.existsById(id)) {

            throw new RuntimeException(
                    "Patient not found with ID: " + id
            );
        }

        repository.deleteById(id);

        logger.info(
                "Patient deleted successfully: {}",
                id
        );
    }


    // CUSTOM QUERY
    public List<PatientDTO> findByNameAndStatus(
            String name,
            String status) {

        logger.info(
                "Searching patients by name: {} and status: {}",
                name,
                status
        );

        return repository
                .findByNameAndStatus(name, status)
                .stream()
                .map(PatientMapper::toDTO)
                .toList();
    }
}