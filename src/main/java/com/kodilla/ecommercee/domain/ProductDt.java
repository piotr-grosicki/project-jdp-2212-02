package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
<<<<<<<<< Temporary merge branch 1
=========
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
>>>>>>>>> Temporary merge branch 2

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductsDto {

    private long id;
    private String name;
    private long id_group;
    private double price;

}
