package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Override
    List<Order> findAll();

    @Override
    Optional<Order> findById(Long orderId);

    @Override
    Order save(Order order);

    @Override
    void deleteById(Long orderId);
}
