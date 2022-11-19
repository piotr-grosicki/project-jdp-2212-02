package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/carts")
public class CartController {

    @GetMapping
    public List<OrderDto> getOrders(Long id) {
        return new ArrayList<>();
    }

    @GetMapping(value = "{/cartId}")
    public OrderDto getCart(@PathVariable Long cartId) {
        return new OrderDto();
    }

    @DeleteMapping
    public void deleteCart() {

    }

    @PostMapping
    public void createCart() {

    }

    @PutMapping
    public OrderDto updateCart(OrderDto orderDto) {
        return new OrderDto();
    }
}
