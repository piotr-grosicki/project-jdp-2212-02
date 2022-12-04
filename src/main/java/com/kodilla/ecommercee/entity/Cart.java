package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "carts")
public class Cart {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "totalPrice")
    private double totalPrice;

    @ManyToMany
    @Column(name = "productList")
    private List<Product> productList;

    @Column(name = "user")
    private long userId;
}
