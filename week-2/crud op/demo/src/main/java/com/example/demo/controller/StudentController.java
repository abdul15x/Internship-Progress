package com.example.demo.controller;

import com.example.demo.component.StudentHelper;
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

    @Autowired
    private StudentHelper studentHelper;



    @GetMapping
    public List<Student> getStudents() {

        return studentService.getAllStudents();
    }



    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        return studentService.getStudentById(id);
    }



    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        return studentService.addStudent(student);
    }



    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }



    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {

        boolean deleted = studentService.deleteStudent(id);

        if (deleted) {
            return "Student deleted successfully";
        }

        return "Student not found";
    }


    @GetMapping("/message")
    public String message() {

        return studentHelper.getMessage();
    }
}