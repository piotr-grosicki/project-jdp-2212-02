package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("shop/carts")
public class CartController {

    @GetMapping
    public CartDto getCarts() {
        return new CartDto(1L, 2.0, new ArrayList<>(), 1L);
    }

    @GetMapping(value = "{cartId}")
    public CartDto getCart(@PathVariable long cartId) {
        return new CartDto(1, 3.4, new ArrayList<>(), 1L);
    }

    @DeleteMapping(value = "{cartId}")
    public CartDto deleteCart(@PathVariable long cartId) {
        return new CartDto(1L, 2.2, new ArrayList<>(), 1L);
    }

    @PostMapping(value = "{cardId}")
    public CartDto createCart(@PathVariable long cardId) {
        return new CartDto(1L, 5.5, new ArrayList<>(), 1L);
    }

    @PutMapping(value = "{cartId}")
    public CartDto updateCart(@PathVariable long cartId) {
        return new CartDto(1L, 2.5, new ArrayList<>(), 1L);
    }
}

