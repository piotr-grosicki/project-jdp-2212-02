package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.entity.User;
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


    public OrderDto(Long id, User user, Boolean isConfirmed, LocalDate orderDate, LocalDate orderDate1, List<ProductDto> mapToProductDtoList) {
    }
}