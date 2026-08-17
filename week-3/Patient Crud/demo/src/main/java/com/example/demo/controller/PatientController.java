package com.example.demo.controller;

import com.example.demo.model.Patient;
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
    public Patient addPatient(@RequestBody Patient patient) {
        return service.addPatient(patient);
    }

    // GET ALL
    @GetMapping
    public List<Patient> getPatients() {
        return service.getPatients();
    }

    // SEARCH BY NAME
    @GetMapping("/name/{name}")
    public List<Patient> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    // SEARCH BY EMAIL
    @GetMapping("/email/{email}")
    public List<Patient> findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    // SEARCH BY STATUS
    @GetMapping("/status/{status}")
    public List<Patient> findByStatus(@PathVariable String status) {
        return service.findByStatus(status);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable String id) {

        service.deletePatient(id);

        return "Patient Deleted Successfully";
    }
    @GetMapping("/sort")
    public List<Patient> sortPatients() {
        return service.sortPatients();
    }
    @GetMapping("/search")
    public List<Patient> findByNameAndStatus(
            @RequestParam String name,
            @RequestParam String status) {

        return service.findByNameAndStatus(name, status);
    }
}