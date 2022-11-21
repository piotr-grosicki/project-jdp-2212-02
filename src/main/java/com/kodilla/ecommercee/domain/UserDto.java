package com.kodilla.ecommercee.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    private String name;
    private String lastName;
    private String phone;

    private Date birth;
    private String email;


    private LocalDate birth;
    private String email;
    private boolean isBlocked;

}

