package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.entity.User;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuite {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    private final Order order = new Order();

    @BeforeEach
    public void prepareTests() {
        order.setId(new Long(1));
        order.setOrderDate(LocalDate.of(2022, 12, 12));
        order.setIsConfirmed(true);
    }

    @Test
    public void findOrderByAllFieldsTest() {
        //Given
        //When
        orderRepository.save(order);
        //Then
        Assertions.assertTrue(orderRepository.findById(order.getId()).isPresent());
        //CleanUp
        orderRepository.deleteById(order.getId());
    }

    @Test
    public void saveOrderTest() {
        //Given
        //When
        orderRepository.save(order);
        //Then
        assertTrue(orderRepository.findById(order.getId()).isPresent());
        //CleanUp
        orderRepository.deleteById(order.getId());
    }

    @Test
    public void deleteOrderTest() {
        //Given
        //When
        orderRepository.save(order);
        orderRepository.deleteById(order.getId());
        //Then
        Assertions.assertFalse(orderRepository.findById(order.getId()).isPresent());
    }

    @Test
    public void checkIfOrderIsRemoved() {
        //Given
        Cart cart = new Cart();
        cart.setId(new Long(0));
        order.setOrderDate(LocalDate.of(2022, 12, 12));
        //When
        orderRepository.save(order);
        cartRepository.deleteById(cart.getId());
        //Then
        Assertions.assertFalse(cartRepository.findById(cart.getId()).isPresent());
    }
}

