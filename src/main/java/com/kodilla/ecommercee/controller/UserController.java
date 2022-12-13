package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.entity.User;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import com.kodilla.ecommercee.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shop/users")
public class UserController {

    @Autowired
    private final UserDbService userDbService;
    private final UserMapper userMapper;


    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) throws UserNotFoundException {
        User user = userMapper.mapToUser(userDto);
        userDbService.createUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "block/{userId}")
    public ResponseEntity<String> blockUser(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(userDbService.blockUser(userId));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body("User with this id does not exist " + userId);
        }
    }


    @PutMapping(value = "generateToken/{userId}/{userEmail}")
    public ResponseEntity<String> generateToken(@PathVariable Long userId, @PathVariable String userEmail) {
        try {
            return ResponseEntity.ok(userDbService.generateToken(userId, userEmail));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body("\"User with this id does not exist \" + userId");
        }
    }

    @PutMapping(value = "unblock/{userId}")
    public ResponseEntity<String> unblockUser(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(userDbService.unblockUser(userId));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body("User with this id does not exist " + userId);
        }
    }
}

