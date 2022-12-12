package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.entity.Group;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.repository.GroupRepository;


import java.util.List;
import java.util.Optional;

public class GroupService {
private GroupRepository repository;

    public List<Group> getGroups() {
        return repository.findAll();
    }

    public Optional<Group> getGroup(Long id) throws GroupNotFoundException {
        Optional<Group> result = Optional.ofNullable(repository.findById(id).orElseThrow(GroupNotFoundException::new));
        return result;
    }

    public Group saveGroup(final Group group) {
        return repository.save(group);
    }

    public void deleteGroup(final Long id) {
        repository.deleteById(id);
    }
}