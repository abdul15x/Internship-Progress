package com.example.demo;

import com.example.demo.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    List<Student> students = new ArrayList<>();

    public StudentController() {

        students.add(new Student(1, "Ali", "BSCS"));
        students.add(new Student(2, "Ahmed", "BSIT"));

    }


    @GetMapping
    public List<Student> getStudents() {
        return students;
    }


    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }

        }

        return null;
    }


    @PostMapping
    public String addStudent(@RequestBody Student student) {

        students.add(student);

        return "Student Added Successfully";

    }


    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(updatedStudent.getName());
                student.setCourse(updatedStudent.getCourse());

                return "Student Updated Successfully";

            }

        }

        return "Student Not Found";
    }


    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                students.remove(student);

                return "Student Deleted Successfully";
            }

        }

        return "Student Not Found";
    }
}