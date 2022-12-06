package com.kodilla.ecommercee.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "product_id", unique = true)
    private Long id;
}
