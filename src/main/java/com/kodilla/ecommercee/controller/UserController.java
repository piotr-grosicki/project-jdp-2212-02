package com.kodilla.ecommercee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

public class UserController {

}

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/shop/users")
public class UserController {
    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
    }
    @PutMapping(value = "changeUserStatus/{userId}")
    public UserDto changeUserStatus(@RequestBody UserDto userDto) {
        return new UserDto(1L, "Marek", "Markowski", "666888555", LocalDate.of(2000, 02, 15), "aaa@gmail.com", false);
    }
    @PutMapping()
    public UserDto generateUserKey(@RequestBody UserDto userDto){
        return new UserDto(1L, "Sławek", "Sławkowski", "111222333", LocalDate.of(1998, 05, 22), "bbb@gmail.com", false);
        }
    }

