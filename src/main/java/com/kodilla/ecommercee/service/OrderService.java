package com.kodilla.ecommercee.service;


import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.exception.OrderNotFoundException;

import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;

import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(final Long orderId) throws OrderNotFoundException {
        return orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }

    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(final Order order) throws OrderNotFoundException {
        if (orderRepository.existsById(order.getId())) {
            return orderRepository.save(order);
        } else {
            throw new OrderNotFoundException();
        }
    }

    public void deleteOrder(final Long orderId) throws OrderNotFoundException {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new OrderNotFoundException();
        }
    }
}