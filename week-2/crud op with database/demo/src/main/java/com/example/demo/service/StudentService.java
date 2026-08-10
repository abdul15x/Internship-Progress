package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    // GET all students
    public List<Student> getAllStudents() {

        return studentRepository.findAll();

    }


    // GET student by ID
    public Student getStudentById(String id) {

        return studentRepository.findById(id).orElse(null);

    }


    // POST - Add student
    public Student addStudent(Student student) {

        return studentRepository.save(student);

    }


    // PUT - Update student
    public Student updateStudent(String id, Student updatedStudent) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {

            student.setName(updatedStudent.getName());
            student.setCourse(updatedStudent.getCourse());

            return studentRepository.save(student);
        }

        return null;
    }


    // DELETE student
    public boolean deleteStudent(String id) {

        if (studentRepository.existsById(id)) {

            studentRepository.deleteById(id);

            return true;
        }

        return false;
    }
}