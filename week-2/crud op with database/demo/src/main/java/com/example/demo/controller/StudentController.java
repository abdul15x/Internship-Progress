package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    // GET all students
    @GetMapping
    public List<Student> getStudents() {

        return studentService.getAllStudents();

    }


    // GET student by ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        return studentService.getStudentById(id);

    }


    // POST
    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        return studentService.addStudent(student);

    }


    // PUT
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable String id,
            @RequestBody Student student) {

        return studentService.updateStudent(id, student);

    }


    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {

        boolean deleted = studentService.deleteStudent(id);

        if (deleted) {
            return "Student deleted successfully";
        }

        return "Student not found";
    }
}