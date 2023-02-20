package com.sda.OnlineShop.controller;

import com.sda.OnlineShop.dto.UserDto;
import com.sda.OnlineShop.entities.User;
import com.sda.OnlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String addUserGet(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUserPost(@ModelAttribute UserDto userDto){

        System.out.println("s-a apelat addUser");
        System.out.println(userDto);

        userService.addUser(userDto);

        return "addUser";
    }

}
