package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.entity.Product;
import com.kodilla.ecommercee.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Data
public class CartDto {
    private Long id;
    private Double totalPrice;
    private List<Product> productList;
    private Long userId;
    private User user;
}
