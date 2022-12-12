package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.entity.User;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto) throws UserNotFoundException {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        user.setBirth(userDto.getBirth());
        user.setEmail(userDto.getEmail());
        user.setBlocked(userDto.isBlocked());
        return user;
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getPhone(),
                user.getBirth(),
                user.getEmail(),
                user.isBlocked(),
                user.isActive(),
                user.getSessionToken(),
                user.getSessionStartTime()
        );
    }

}
