package com.shreya.practice.service;

import com.shreya.practice.domain.StudentDomain;
import com.shreya.practice.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> getStudentById(int id);

    Student deleteStudentById(int id);
    Student populateModel(StudentDomain domain);

    StudentDomain populateDomain(Student model);
}
