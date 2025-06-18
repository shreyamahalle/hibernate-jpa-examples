package com.shreya.practice.service;

import com.shreya.practice.model.Group;
import com.shreya.practice.model.StudentGroupProjection;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    Group createGroup(Group group);

    List<Group> getAllGroups();

    Optional<Group> getGroupById(int id);

    Group deleteGroupById(int id);

    List<Group> getAllStudents();

    List<StudentGroupProjection> fetchStudentGroupById(int id);
}