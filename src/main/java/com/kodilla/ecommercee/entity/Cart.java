package com.kodilla.ecommercee.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "cart_id", unique = true)
    private Long id;

    @Column(name = "totalPrice")
    private Double totalPrice;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "kodilla_project",
            joinColumns = { @JoinColumn(name = "carts_id") },
            inverseJoinColumns = { @JoinColumn(name = "products_id") }
    )
    private List<Product> productList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
