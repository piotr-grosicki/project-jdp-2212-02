package com.kodilla.ecommercee.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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