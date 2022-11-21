package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CartDto {
    private long id;
    private double totalPrice;
    private List<OrderDto> ordersList;
    private long userId;

}
