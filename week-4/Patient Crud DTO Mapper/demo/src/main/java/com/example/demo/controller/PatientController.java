package com.example.demo.controller;

import com.example.demo.dto.PatientDTO;
import com.example.demo.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    // POST
    @PostMapping
    public PatientDTO addPatient(@RequestBody PatientDTO dto) {

        return service.addPatient(dto);
    }

    // GET ALL
    @GetMapping
    public List<PatientDTO> getPatients() {

        return service.getPatients();
    }

    // CUSTOM QUERY
    @GetMapping("/search")
    public List<PatientDTO> findByNameAndStatus(
            @RequestParam String name,
            @RequestParam String status) {

        return service.findByNameAndStatus(name, status);
    }
}