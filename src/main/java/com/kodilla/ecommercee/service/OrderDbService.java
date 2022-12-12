package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderDbService {
    private final OrderRepository orderRepository;
    public void createOrder(final Order order) {
        order.setOrderDate(LocalDate.now());
        orderRepository.save(order);
    }
}