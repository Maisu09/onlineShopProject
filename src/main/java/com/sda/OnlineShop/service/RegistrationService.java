package com.sda.OnlineShop.service;

import com.sda.OnlineShop.dto.RegistrationDto;
import com.sda.OnlineShop.entities.User;
import com.sda.OnlineShop.mapper.UserMapper;
import com.sda.OnlineShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    public void addRegistration(RegistrationDto registrationDto) {

        User user = userMapper.map(registrationDto);
        userRepository.save(user);

    }

}
