package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CartDto {
    private long id;
    private double totalPrice;
    private List<ProductsDto> ordersList;
    private long userId;

}