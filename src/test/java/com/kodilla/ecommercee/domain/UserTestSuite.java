package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.entity.User;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;

@Transactional
@SpringBootTest
public class UserTestSuite {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderRepository orderRepository;
    Cart cart = new Cart();
    User user = new User();
    User user2 = new User();

    @BeforeEach
    public void settingValues(){
        cart.setId(1L);
        cart.setTotalPrice(150.79);
        cart.setProductList(new ArrayList<>());
        cart.setUser(user);

        user.setName("testName");
        user.setLastName("testUserLastName");
        user.setPhone("321123789");
        user.setBirth(LocalDate.of(1980,2,2));
        user.setEmail("test@testing.com");
        user.setBlocked(false);
        user.setOrderList(new ArrayList<>());
        user.setCart(cart);


        user2.setId(2L);
        user2.setName("testName2");
        user2.setLastName("testUserLastName2");
        user2.setPhone("111222333");
        user2.setBirth(LocalDate.of(2002,5,30));
        user2.setEmail("test2@testing.com");
        user2.setBlocked(true);
        user2.setOrderList(new ArrayList<>());

    }
    @Test
    public void saveUserTest(){
        //Given
        //When
        userRepository.save(user);
        //Then
        assertEquals(1,userRepository.findAll().size());
        //CleanUp
        userRepository.deleteAll();
    }
    @Test
    public void findAllTest(){
        //Given
        User user2 = new User();
        //When
        userRepository.save(user);
        userRepository.save(user2);
        int userRepoSize = userRepository.findAll().size();
        //Given
        assertEquals(2,userRepoSize);
        //CleanUp
        userRepository.deleteAll();
    }
    @Test
    public void deleteByIdTest(){
        //Given
        //When
        userRepository.save(user);
        //Then
        assertTrue(userRepository.findById(user.getId()).isPresent());
        //CleanUp
        userRepository.deleteById(user.getId());
    }
    @Test
    public void findByIdTest(){
        //Given
        //When
        userRepository.save(user);
        //Then
        assertTrue(userRepository.findById(user.getId()).isPresent());
        //CleanUp
        userRepository.deleteAll();
    }
}