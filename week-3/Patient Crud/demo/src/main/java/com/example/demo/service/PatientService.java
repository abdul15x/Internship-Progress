package com.example.demo.service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    // CREATE
    public Patient addPatient(Patient patient) {
        return repository.save(patient);
    }

    // READ
    public List<Patient> getPatients() {
        return repository.findAll();
    }

    // SEARCH BY NAME
    public List<Patient> findByName(String name) {
        return repository.findByName(name);
    }

    // SEARCH BY EMAIL
    public List<Patient> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    // SEARCH BY STATUS
    public List<Patient> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    // DELETE
    public void deletePatient(String id) {
        repository.deleteById(id);


    }

    public List<Patient> sortPatients() {
        return repository.findAllByOrderByNameAsc();


    }

    public List<Patient> findByNameAndStatus(String name, String status) {
        return repository.findByNameAndStatus(name, status);
    }
}