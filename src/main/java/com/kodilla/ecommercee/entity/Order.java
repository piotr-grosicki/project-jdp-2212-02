package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;

    @NotNull
    @Column(name = "IS_CONFIRMED")
    private Boolean isConfirmed;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
            name = "JOIN_ORDERS_WITH_PRODUCTS",
            joinColumns = { @JoinColumn(name = "ORDER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID") }
    )
    private List<Product> products = new ArrayList<>();
}