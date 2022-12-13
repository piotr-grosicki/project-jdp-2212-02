package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.entity.Order;
import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.service.CartDbService;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderMapper {
    @Autowired
    private CartDbService cartDbService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductMapper productMapper;
    public Order mapToOrder(final OrderDto orderDto) throws UserNotFoundException, CartNotFoundException {
        return new Order(
                orderDto.getId(),
                userService.getUserById(orderDto.getUserId()),
                orderDto.getOrderDate(),
                orderDto.getId(),
                orderDto.getProducts(),
                orderDto.getIsConfirmed(),
                cartDbService.getCard(orderDto.getId())
        );
    }
    public OrderDto mapToOrderDto(final Order order) throws CartNotFoundException {
        List<Product> products = cartDbService.getCard(order.getId()).getProductList();
        return new OrderDto(
                order.getId(),
                order.getUser(),
                order.getIsConfirmed(),
                order.getOrderDate(),
                order.getOrderDate(),
                productMapper.mapToProductDtoList(products)
        );
    }
    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(order -> {
                    try {
                        return mapToOrderDto(order);
                    } catch (CartNotFoundException e) {
                        return null;
                    }
                })
                .collect(Collectors.toList());
    }
}