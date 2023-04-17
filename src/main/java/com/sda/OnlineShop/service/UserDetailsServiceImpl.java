package com.sda.OnlineShop.service;

import com.sda.OnlineShop.entities.User;
import com.sda.OnlineShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmailAddress(emailAddress);  // search in database the user by e-mail

        if (optionalUser.isEmpty()) {  // if cannot fount the exception is thrown
            throw new UsernameNotFoundException(emailAddress);
        }
        User user = optionalUser.get();  // if the user exist, we unpacked the box
        Set<GrantedAuthority> roles = new HashSet<>();  // preparing the collection in which we'll put the user roles and add the user role because we only have one
        roles.add(new SimpleGrantedAuthority(user.getUserRole().name()));
        return new org.springframework.security.core.userdetails.User(emailAddress, user.getPassword(),roles);  // we instantiate the user object from spring security
    }
}
