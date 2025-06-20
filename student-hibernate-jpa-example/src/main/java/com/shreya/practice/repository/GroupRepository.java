package com.shreya.practice.repository;

import com.shreya.practice.domain.GroupDomain;
import com.shreya.practice.model.StudentGroupProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<GroupDomain, Integer> {
    @Query(value = """
            SELECT 
                s.id AS studentId, 
                s.name AS studentName, 
                sg.name AS groupName
            FROM student s
            LEFT JOIN student_group_mapping sgm ON s.id = sgm.student_id
            JOIN student_group sg ON sgm.group_id = sg.id
            WHERE s.id = ?1
            """, nativeQuery = true)
    List<StudentGroupProjection> findStudentGroupProjectionById(int id);
}
