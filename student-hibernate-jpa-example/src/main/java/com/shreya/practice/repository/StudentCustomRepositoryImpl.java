package com.shreya.practice.repository;

import com.shreya.practice.domain.StudentDomain;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentCustomRepositoryImpl implements StudentCustomRepository {

    private EntityManager entityManager;

    @Override
    public List<StudentDomain> findByCriteriaPercentage(double percentage) {
        return List.of();
    }
}
