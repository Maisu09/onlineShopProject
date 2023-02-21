package com.sda.OnlineShop.controller;

import com.sda.OnlineShop.dto.RegistrationDto;
import com.sda.OnlineShop.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String viewRegistrationGet(Model model) {
        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute("registrationDto", registrationDto);
        return "registration";
    }

    @PostMapping("/registration")
    public String viewRegistrationPost(@ModelAttribute RegistrationDto registrationDto ){

        System.out.println("s-a apelat");
        System.out.println(registrationDto);
        registrationService.addRegistration(registrationDto);
        return "registration";

    }

    @GetMapping("/login")
    public String viewLoginGet() {

        return "login";
    }
}
