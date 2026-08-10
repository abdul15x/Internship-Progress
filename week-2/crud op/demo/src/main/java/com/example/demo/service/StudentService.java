package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1, "Ali", "BSCS"));
        students.add(new Student(2, "Ahmed", "BSIT"));
    }


    public List<Student> getAllStudents() {
        return students;
    }


    public Student getStudentById(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }


    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }


    public Student updateStudent(int id, Student updatedStudent) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(updatedStudent.getName());
                student.setCourse(updatedStudent.getCourse());

                return student;
            }
        }

        return null;
    }


    public boolean deleteStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {

                students.remove(student);
                return true;
            }
        }

        return false;
    }
}