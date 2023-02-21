package com.sda.OnlineShop.controller;

import com.sda.OnlineShop.dto.ProductDto;
import com.sda.OnlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
@Controller
public class ViewProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{productId}")
    public String viewProductGet(
            Model model,
            @PathVariable(value = "productId") String productId
    ) {
        Optional<ProductDto> optionalProductDto = productService.getOptionalProductDtoById(productId);

        if (optionalProductDto.isEmpty())
        {
            return "error";
        }

        model.addAttribute("productDto", optionalProductDto.get());
        System.out.println("Am dat click pe prod cu id: " + productId);
        return "viewProduct";
    }
}
