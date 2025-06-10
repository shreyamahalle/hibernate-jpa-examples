package com.shreya.jpa;

import com.shreya.jpa.model.Student;
import com.shreya.jpa.repository.StudentRepository;

public class MainApp {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Shreya");
        student.setCourse("Java");

        StudentRepository repo = new StudentRepository();
        repo.saveStudent(student);

        System.out.println("Student saved!");
    }
}
