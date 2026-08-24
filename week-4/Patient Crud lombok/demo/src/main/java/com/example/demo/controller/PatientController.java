package com.example.demo.controller;

import com.example.demo.dto.PatientDTO;
import com.example.demo.service.PatientService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;


    // CREATE
    @PostMapping
    public ResponseEntity<PatientDTO> addPatient(
            @Valid @RequestBody PatientDTO dto) {

        PatientDTO patient =
                service.addPatient(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(patient);
    }


    // GET ALL
    @GetMapping
    public ResponseEntity<List<PatientDTO>> getPatients() {

        return ResponseEntity.ok(
                service.getPatients()
        );
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(
            @PathVariable String id) {

        return ResponseEntity.ok(
                service.getPatientById(id)
        );
    }


    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(
            @PathVariable String id,
            @Valid @RequestBody PatientDTO dto) {

        return ResponseEntity.ok(
                service.updatePatient(id, dto)
        );
    }


    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(
            @PathVariable String id) {

        service.deletePatient(id);

        return ResponseEntity.noContent().build();
    }


    // CUSTOM QUERY
    @GetMapping("/search")
    public ResponseEntity<List<PatientDTO>>
    findByNameAndStatus(
            @RequestParam String name,
            @RequestParam String status) {

        return ResponseEntity.ok(
                service.findByNameAndStatus(
                        name,
                        status
                )
        );
    }
}