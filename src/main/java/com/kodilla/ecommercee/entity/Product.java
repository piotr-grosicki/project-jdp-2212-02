package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;
}