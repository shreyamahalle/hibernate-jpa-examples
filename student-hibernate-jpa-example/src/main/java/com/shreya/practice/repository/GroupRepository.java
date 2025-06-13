package com.shreya.practice.repository;

import com.shreya.practice.domain.GroupDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupDomain, Integer> {
}
