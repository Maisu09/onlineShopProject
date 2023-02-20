package com.sda.OnlineShop.controller;

import com.sda.OnlineShop.dto.ProductDto;
import com.sda.OnlineShop.entities.Product;
import com.sda.OnlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
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
        return "addProduct";
    }

    @GetMapping("/home")
    public String homeGet(Model model) {
        List<ProductDto> productDtos = productService.getAllProductDtos();
        model.addAttribute("productDtos", productDtos);

        return "home";
    }

    @GetMapping("/cart")
    public String cartGet() {
        return "cart";
    }

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
