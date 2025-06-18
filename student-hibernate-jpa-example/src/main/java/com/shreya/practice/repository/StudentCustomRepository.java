package com.shreya.practice.repository;

import com.shreya.practice.domain.StudentDomain;

import java.util.List;

public interface StudentCustomRepository {
    List<StudentDomain> findByCriteria(double percentage);
}