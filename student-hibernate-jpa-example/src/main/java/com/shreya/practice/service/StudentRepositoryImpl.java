package com.shreya.practice.service;

import com.shreya.practice.domain.StudentDomain;
import com.shreya.practice.exception.StudentNotFoundException;
import com.shreya.practice.model.Student;
import com.shreya.practice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentRepositoryImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        StudentDomain domain = this.populateDomain(student);
        return this.populateModel(studentRepository.save(domain));
    }

    @Override
    public Student deleteStudentById(int id) {
        Optional<StudentDomain> domain = studentRepository.findById(id);
        if (domain.isEmpty()) {
            studentRepository.deleteById(id);
        } else {
            throw new StudentNotFoundException("Student not found");
        }
        return this.populateModel(domain.get());
    }


    @Override
    public Optional<Student> getStudentById(int id) {
        Optional<StudentDomain> getStudentById = studentRepository.findById(id);
        if (getStudentById.isEmpty()) {
            throw new StudentNotFoundException("Student not found");
        }
        return Optional.ofNullable(this.populateModel(getStudentById.get()));
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream().map(this::populateModel).toList();
    }

    private Student populateModel(StudentDomain domain){
        return Student.builder()
                .id(domain.getId())
                .name(domain.getName())
                .percentage(domain.getPercentage())
                .build();
    }
    private StudentDomain populateDomain(Student model){
        return StudentDomain.builder()
                .id(model.getId())
                .name(model.getName())
                .percentage(model.getPercentage())
                .build();

    }
}
