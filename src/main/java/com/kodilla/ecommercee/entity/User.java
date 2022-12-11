package com.kodilla.ecommercee.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "user_id", unique = true)
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "user_birth")
    private LocalDate birth;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_blocked")
    private boolean isBlocked;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orderList;
}

