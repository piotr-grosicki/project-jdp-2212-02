package com.kodilla.ecommercee.controller;
import com.kodilla.ecommercee.domain.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/shop/users")
@RequiredArgsConstructor
@Service
public class UserController {
    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
    }
    @PutMapping(value = "statusUser/{userId}")
    public UserDto banUser(@RequestBody long userId) {
        return new UserDto();
    }
    @PutMapping(value = "{userId}")
    public void changeUserStatus(@PathVariable long userId){
        }
    }