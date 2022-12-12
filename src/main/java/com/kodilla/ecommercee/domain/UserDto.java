package com.kodilla.ecommercee.domain;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String lastName;
    private String phone;
    private LocalDate birth;
    private String email;
    private boolean isBlocked;
    private boolean active;
    private String sessionToken;
    private LocalDateTime sessionStartTime;


}

