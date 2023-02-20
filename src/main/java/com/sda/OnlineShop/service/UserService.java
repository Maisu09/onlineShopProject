package com.sda.OnlineShop.service;

import com.sda.OnlineShop.dto.UserDto;
import com.sda.OnlineShop.entities.User;
import com.sda.OnlineShop.mapper.UserMapper;
import com.sda.OnlineShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    public void addUser(UserDto userDto) {
        User user = userMapper.map(userDto);
        userRepository.save(user);
    }
}
