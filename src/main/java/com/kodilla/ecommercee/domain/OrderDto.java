package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class OrderDto {
     long id;
     long userId;
     long cartId;
     LocalDate orderDate;
     boolean processing;
}
