package com.sda.OnlineShop.controller;

import com.sda.OnlineShop.dto.ProductDto;
import com.sda.OnlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AddProductRepository {
    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public String addProductGet(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProductPost(@ModelAttribute ProductDto productDto,
                                 @RequestParam("productImage") MultipartFile productImage) {
        System.out.println("S-a apelat add product!");
        System.out.println(productDto);
        productService.addProduct(productDto, productImage);
        return "redirect:/addProduct";
    }

    @GetMapping("/cart")
    public String cartGet() {
        return "cart";
    }



}
