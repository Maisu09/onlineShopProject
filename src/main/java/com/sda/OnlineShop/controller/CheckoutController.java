package com.sda.OnlineShop.controller;

import com.sda.OnlineShop.dto.ShoppingCartDto;
import com.sda.OnlineShop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {
    @Autowired
    ShoppingCartService shoppingCartService;
    @GetMapping("/checkout")
    public String viewCheckout(Authentication authentication,
                               Model model
    ){
        ShoppingCartDto shoppingCartDto = shoppingCartService.getShoppingCartDto(authentication.getName());
        model.addAttribute("shoppingCartDto", shoppingCartDto);
        System.out.println(shoppingCartDto);
        return "checkout";
    }


}
