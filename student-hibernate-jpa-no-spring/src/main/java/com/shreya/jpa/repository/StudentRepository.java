package com.shreya.jpa.repository;

import com.shreya.jpa.model.Student;

import javax.persistence.*;

public class StudentRepository {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student-unit");

    public void saveStudent(Student student) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(student);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
