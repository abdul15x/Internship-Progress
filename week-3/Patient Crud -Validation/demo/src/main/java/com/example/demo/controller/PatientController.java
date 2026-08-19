package com.example.demo.controller;

import com.example.demo.dto.PatientDTO;
import com.example.demo.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public PatientDTO addPatient(
            @Valid @RequestBody PatientDTO dto) {

        return service.addPatient(dto);
    }
}