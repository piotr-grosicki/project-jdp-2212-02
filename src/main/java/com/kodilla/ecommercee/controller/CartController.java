package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("v1/carts")
public class CartController {

    @GetMapping
    public CartDto getCards() {
        return new CartDto(1L, 2.0, new ArrayList<>(), 1L);
    }

    @GetMapping(value = "{cartId}")
    public CartDto getCart(@PathVariable long cartId) {
        return new CartDto(1,3.4, new ArrayList<>(), 1L);
    }

    @DeleteMapping(value = "{cartId}")
    public CartDto deleteCart(@PathVariable long cartId) {
        return new CartDto(1L, 2.2, new ArrayList<>(), 1L);
    }

    @PostMapping
    public CartDto createCart() {
        return new CartDto(1L,5.5, new ArrayList<>(), 1L);
    }

    @PutMapping(value = "{cartId}")
    public CartDto updateCart(@PathVariable long cartId) {
        return new CartDto(1L, 2.5, new ArrayList<>(), 2);
    }
}
