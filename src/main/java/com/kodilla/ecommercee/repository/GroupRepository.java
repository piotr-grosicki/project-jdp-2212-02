package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Override
    List<Group> findAll();

    @Override
    Optional<Group> findById(Long groupId);

    @Override
    Group save(Group group);

    @Override
    void deleteById(Long groupId);
}
