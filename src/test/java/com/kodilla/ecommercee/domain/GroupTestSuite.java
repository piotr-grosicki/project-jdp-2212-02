package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.entity.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class GroupTestSuite {
    @Autowired
    private GroupRepository groupRepository;
    private final String GROUP_NAME = "Laptops";


    @Test
    void testAddGroup() {
        Group group = new Group(0l,GROUP_NAME);
        Group group1 = new Group(0l,GROUP_NAME);


        groupRepository.save(group);
        groupRepository.save(group1);

        long id = group.getId();
        long id2 = group1.getId();

        assertNotEquals(0, id);
        assertNotEquals(0, id2);
        assertEquals(2, groupRepository.findAll().size());

        groupRepository.deleteAll();

    }

}