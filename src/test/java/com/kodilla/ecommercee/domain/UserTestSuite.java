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

import java.time.LocalDate;
import java.util.ArrayList;

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

        @BeforeEach
        public void settingValues(){
            cart.setTotalPrice(150.79);
            cart.setProductList(new ArrayList<>());
            cart.setUser(user);

            user.setName("testName");
            user.setLastName("testUserLastName");
            user.setPhone("321123789");
            user.setBirth(LocalDate.of(1980,2,2));
            user.setEmail("test@testing.com");
            user.setBlocked(false);
            //user.setCart(cart);
            user.setOrderList(new ArrayList<>());

        }
        @Test
        public void saveUserTest(){
            //Given
            //When
            userRepository.save(user);
            //Then
            assertTrue(userRepository.findById(user.getId()).isPresent());
            //CleanUp
            userRepository.deleteById(user.getId());
        }
}
