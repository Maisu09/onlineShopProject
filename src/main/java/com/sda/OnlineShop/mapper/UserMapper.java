package com.sda.OnlineShop.mapper;

import com.sda.OnlineShop.dto.UserDto;
import com.sda.OnlineShop.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User map(UserDto userDto) {
        User user = new User();

        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());

        return user;
    }
}
