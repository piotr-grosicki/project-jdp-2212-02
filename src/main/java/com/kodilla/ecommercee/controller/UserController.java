package com.kodilla.ecommercee.controller;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop/users")
public class UserController {
    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
    }
    @PutMapping(value = "statusUser/{userId}")
    public UserDto changeUserStatus(@RequestBody long userId) {
        return new UserDto();
    }
    @PutMapping(value = "{userId}")
    public void generateUserKey(@PathVariable long userId){
        }
    }