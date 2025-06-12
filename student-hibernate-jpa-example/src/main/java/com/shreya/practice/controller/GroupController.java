package com.shreya.practice.controller;

import com.shreya.practice.model.Group;
import com.shreya.practice.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groupManagement")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        System.out.println("Inside controller " + group);
        Group createGroup = groupService.createGroup(group);
        return ResponseEntity.ok(createGroup);
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable int id) {
        Optional<Group> group = groupService.getGroupById(id);
        return group.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<Group> deleteGroupById(@PathVariable int id) {
        Group deletedGroup = groupService.deleteGroupById(id);
        return (deletedGroup != null) ? ResponseEntity.ok(deletedGroup) : ResponseEntity.notFound().build();
    }
}
