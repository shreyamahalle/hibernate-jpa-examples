package com.shreya.practice.service;

import com.shreya.practice.domain.GroupDomain;
import com.shreya.practice.domain.StudentDomain;
import com.shreya.practice.exception.StudentNotFoundException;
import com.shreya.practice.model.Group;
import com.shreya.practice.model.Student;
import com.shreya.practice.model.StudentGroupProjection;
import com.shreya.practice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentService studentService;

    @Override
    public Group createGroup(Group group) {
        System.out.println("Inside service: " + group);
        GroupDomain domain = this.populateDomain(group);
        return this.populateModel(groupRepository.save(domain));
    }

    @Override
    public List<StudentGroupProjection> fetchStudentGroupById(int id) {
        System.out.println("Inside service: " + id);
        return groupRepository.findStudentGroupProjectionById(id);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll().stream()
                .map(this::populateModel)
                .collect(Collectors.toList());
    }

    @Override
    public Group deleteGroupById(int id) {
        Optional<GroupDomain> domain = groupRepository.findById(id);
        if (domain.isEmpty()) {
            throw new StudentNotFoundException("Group not found");
        }
        groupRepository.deleteById(id);
        return this.populateModel(domain.get());
    }

    @Override
    public Optional<Group> getGroupById(int id) {
        Optional<GroupDomain> getStudentById = groupRepository.findById(id);
        if (getStudentById.isEmpty()) {
            throw new StudentNotFoundException("Group not found");
        }
        return Optional.of(this.populateModel(getStudentById.get()));
    }

    @Override
    public List<Group> getAllStudents() {
        return groupRepository.findAll().stream()
                .map(this::populateModel)
                .collect(Collectors.toList());
    }

    private Group populateModel(GroupDomain domain) {
        Set<Student> studentList = domain.getStudents().stream()
                .map(studentService::populateModel)
                .collect(Collectors.toSet());
        return Group.builder()
                .id(domain.getId())
                .name(domain.getName())
                .students(studentList)
                .build();
    }

    private GroupDomain populateDomain(Group model) {
        Set<StudentDomain> studentList = model.getStudents().stream()
                .map(studentService::populateDomain)
                .collect(Collectors.toSet());
        return GroupDomain.builder()
                .id(model.getId())
                .name(model.getName())
                .students(studentList)
                .build();
    }
}
