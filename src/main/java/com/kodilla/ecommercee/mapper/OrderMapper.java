package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.service.CartDbService;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    private CartDbService cartDbService;
    public OrderDto mapToOrderDto(final Order order) throws CartNotFoundException {
        return new OrderDto(
                order.getId(),
                order.getOrderDate(),
                order.getIsConfirmed(),
                order.getUser().getId(),
                order.getProducts());
    }
}
