package com.shreya.practice.service;

import com.shreya.practice.domain.GroupDomain;
import com.shreya.practice.exception.StudentNotFoundException;
import com.shreya.practice.model.Group;
import com.shreya.practice.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group createGroup(Group group) {
        System.out.println("Inside service: " + group);
        GroupDomain domain = this.populateDomain(group);
        return this.populateModel(groupRepository.save(domain));
    }

    @Override
    public List<Group> getAllGroups() {
        return List.of();
    }

    @Override
    public Group deleteGroupById(int id) {
        Optional<GroupDomain> domain = groupRepository.findById(id);
        if (domain.isEmpty()) {
            groupRepository.deleteById(id);
        } else {
            throw new StudentNotFoundException("Group not found");
        }
        return this.populateModel(domain.get());
    }


    @Override
    public Optional<Group> getGroupById(int id) {
        Optional<GroupDomain> getStudentById = groupRepository.findById(id);
        if (getStudentById.isEmpty()) {
            throw new StudentNotFoundException("Group not found");
        }
        return Optional.ofNullable(this.populateModel(getStudentById.get()));
    }


    @Override
    public List<Group> getAllStudents() {
        return groupRepository.findAll().stream().map(this::populateModel).toList();
    }

    protected Group populateModel(GroupDomain domain) {
        return Group.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

    protected GroupDomain populateDomain(Group model) {
        return GroupDomain.builder()
                .id(model.getId())
                .name(model.getName())
                .build();

    }
}

