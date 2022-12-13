package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.entity.Group;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class GroupTestSuite {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ProductRepository productRepository;
    private final String GROUP_NAME = "RTV";
    private final String PRODUCTS_NAME = "Laptops";

    private final Group group = new Group();
    private final Product product = new Product();
    @BeforeEach
    public void prepareTests() {
        group.setName(GROUP_NAME);
        product.setProductName(PRODUCTS_NAME);

    }
    @Test
    void testAddGroup() {
        groupRepository.save(group);

        assertEquals(1, groupRepository.findAll().size());

        groupRepository.deleteAll();

    }

    @Test
    public void testFindAllGroups() {
        //Given

        //When
        for(int i = 0; i < 10; i ++) {
            String name = "Products: " + i;
          Group  group = new Group(name);
            groupRepository.save(group);
        }
        //Then
        assertEquals(10, groupRepository.count());
        //clean
        groupRepository.deleteAll();
    }


    @Test
    public void testFindGroupById() {
        //Given

        //When
        groupRepository.save(group);
        Long groupId = group.getId();
        Optional<Group> testId = groupRepository.findById(groupId);
        //Then
        assertEquals(groupId, testId.get().getId());

        //clean
        groupRepository.deleteAll();
    }

    @Test
    public void testAddProductsToGroup() {
        //Given

        productRepository.save(product);

        groupRepository.save(group);

        //When
        List<Product> products = productRepository.findAll();

        //Then
        assertEquals(1, products.size());
        //clean
        groupRepository.deleteAll();
        productRepository.deleteAll();
    }




}