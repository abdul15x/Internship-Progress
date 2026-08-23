package com.example.demo.repository;

import com.example.demo.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PatientRepository
        extends MongoRepository<Patient, String> {

    @Query("{ 'name': ?0, 'status': ?1 }")
    List<Patient> findByNameAndStatus(
            String name,
            String status
    );
}