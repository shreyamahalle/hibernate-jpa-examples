package com.shreya.practice.repository;

import com.shreya.practice.domain.StudentDomain;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentCustomRepositoryImpl implements StudentCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<StudentDomain> findByCriteriaPercentage(double percentage) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentDomain> query = criteriaBuilder.createQuery(StudentDomain.class);
        Root<StudentDomain> root = query.from(StudentDomain.class);
        List<Predicate> predicates = new ArrayList<>();

        if (percentage > 0) {
            predicates.add(criteriaBuilder.greaterThan(root.get("percentage"), percentage));
        }

        query.select(root).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(query).getResultList();
    }
}
