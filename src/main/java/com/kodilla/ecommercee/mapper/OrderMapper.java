package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.entity.Cart;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.service.CartDbService;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
public class OrderMapper {

    CartDbService cartDbService;

    public Order mapToOrder(final OrderDto orderDto) throws OrderNotFoundException {
        Order order = new Order();
        orderDto.getId();
        order.getUser();
        return order;
    }
    public OrderDto mapToOrderDto(final Order order) throws CartNotFoundException {
        return new OrderDto(
                order.getId(),
                order.getOrderDate(),
                order.getIsConfirmed(),
                order.getUser().getId(),
                order.getProducts());
    }

}