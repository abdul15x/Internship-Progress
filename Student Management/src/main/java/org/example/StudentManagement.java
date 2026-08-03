package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
    }
}

public class StudentManagement {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Student> studentList = new ArrayList<>();
        HashMap<Integer, Student> studentMap = new HashMap<>();
        HashSet<Integer> studentIds = new HashSet<>();

        int choice;

        do {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {

                choice = input.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Student ID: ");
                        int id = input.nextInt();

                        if (studentIds.contains(id)) {
                            System.out.println("Student ID already exists.");
                            break;
                        }

                        System.out.print("Enter Student Name: ");
                        String name = input.next();

                        Student s = new Student(id, name);

                        studentList.add(s);
                        studentMap.put(id, s);
                        studentIds.add(id);

                        System.out.println("Student Added Successfully.");
                        break;

                    case 2:

                        if (studentList.isEmpty()) {
                            System.out.println("No Students Available.");
                        } else {

                            System.out.println("\nStudent List");

                            for (Student st : studentList) {
                                st.display();
                                System.out.println("----------------------");
                            }
                        }

                        break;

                    case 3:

                        System.out.print("Enter Student ID: ");
                        int searchId = input.nextInt();

                        if (studentMap.containsKey(searchId)) {

                            System.out.println("Student Found");

                            studentMap.get(searchId).display();

                        } else {

                            System.out.println("Student Not Found.");

                        }

                        break;

                    case 4:

                        System.out.print("Enter Student ID: ");
                        int deleteId = input.nextInt();

                        if (studentMap.containsKey(deleteId)) {

                            Student temp = studentMap.get(deleteId);

                            studentList.remove(temp);
                            studentMap.remove(deleteId);
                            studentIds.remove(deleteId);

                            System.out.println("Student Deleted Successfully.");

                        } else {

                            System.out.println("Student Not Found.");

                        }

                        break;

                    case 5:

                        System.out.println("Program Closed.");
                        break;

                    default:

                        System.out.println("Invalid Choice.");

                }

            } catch (Exception e) {

                System.out.println("Invalid Input! Please enter numbers only.");

                input.nextLine();

                choice = 0;
            }

        } while (choice != 5);

    }
}