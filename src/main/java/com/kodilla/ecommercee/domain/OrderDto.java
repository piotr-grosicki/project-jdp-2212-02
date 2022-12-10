package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;


@Getter
@ToString
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private LocalDate orderDate;
    private Boolean isConfirmed;
    private Long userId;
    private List<Product> products;
}