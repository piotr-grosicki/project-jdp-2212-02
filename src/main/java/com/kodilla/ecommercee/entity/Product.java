package com.kodilla.ecommercee.entity;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private double price;

    @Column(name = "availability")
    private boolean availability;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "carts_has_product",
            joinColumns = {@JoinColumn(name = "products_id", referencedColumnName = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")}
    )
    private List<Cart> carts;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_has_product",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")}
    )
    private List<Order> orders;

    public Product(Long productId, String productName, double price, boolean availability, Group group) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.availability = availability;
        this.group = group;
    }
}

