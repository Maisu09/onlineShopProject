package com.sda.OnlineShop.mapper;


import com.sda.OnlineShop.dto.RegistrationDto;
import com.sda.OnlineShop.entities.ShoppingCart;
import com.sda.OnlineShop.entities.User;
import com.sda.OnlineShop.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User map(RegistrationDto registrationDto) {
        User user = new User();
        user.setFullName(registrationDto.getFullName());
        user.setEmailAddress(registrationDto.getEmailAddress());
        user.setPassword(bCryptPasswordEncoder.encode(registrationDto.getPassword()));
        user.setPhoneNumber(registrationDto.getPhoneNumber());
        user.setAddress(registrationDto.getAddress());
        user.setUserRole(UserRole.valueOf(registrationDto.getUserRole()));
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        user.setShoppingCart(shoppingCart);
        return user;
    }
}