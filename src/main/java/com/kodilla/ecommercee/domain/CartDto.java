package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CartDto {
    private long id;
    private double totalPrice;
    private List<ProductDto> productDtoList;
    private long userId;

}
