package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "GROUP")
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID", unique = true)
    private Long id;



    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Product> products = new ArrayList<>();
}
