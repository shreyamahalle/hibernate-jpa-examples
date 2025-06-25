package com.shreya.practice.repository;

import com.shreya.practice.domain.StudentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDomain, Integer>, StudentCustomRepository {

}
