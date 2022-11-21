package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class OrderDto {
     long id;
     long userId;
     long cartId;
     Date orderDate;
     boolean processing;
}
