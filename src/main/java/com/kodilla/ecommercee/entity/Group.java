package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Setter
@Table(name = "\"GROUPS\"")
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Group(String name) {
        this.name = name;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Product> products = new ArrayList<>();
}
