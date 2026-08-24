package com.example.demo.repository;

import com.example.demo.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {

    List<Patient> findByName(String name);

    List<Patient> findByEmail(String email);

    List<Patient> findByStatus(String status);

    List<Patient> findAllByOrderByNameAsc();

    @Query("{ 'name': ?0, 'status': ?1 }")
    List<Patient> findByNameAndStatus(String name, String status);
}