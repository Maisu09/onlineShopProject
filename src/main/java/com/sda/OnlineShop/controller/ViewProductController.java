package com.sda.OnlineShop.controller;

import com.sda.OnlineShop.dto.ProductDto;
import com.sda.OnlineShop.dto.SelectedProductDto;
import com.sda.OnlineShop.service.ProductService;
import com.sda.OnlineShop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ViewProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/product/{name}/{productId}")
    public String viewProductGet(Model model,
                                 @PathVariable(value = "productId") String productId,
                                 @PathVariable(value = "name") String name) {
        Optional<ProductDto> optionalProductDto = productService.getOptionalProductDtoById(productId);
        if (optionalProductDto.isEmpty()) {
            return "error";
        }
        model.addAttribute("productDto", optionalProductDto.get());

        SelectedProductDto selectedProductDto = new SelectedProductDto();
        model.addAttribute("selectedProductDto", selectedProductDto);

        return "viewProduct";
    }

    @PostMapping("/product/{name}/{productId}")
    public String viewProductPost(@ModelAttribute SelectedProductDto selectedProductDto,
                                  @PathVariable(value = "productId") String productId,
                                  @PathVariable(value = "name") String name,
                                  Authentication authentification
    ) {
        System.out.println(selectedProductDto);
        System.out.println(authentification.getName());

        shoppingCartService.addToCart(selectedProductDto, productId, authentification.getName());
        return "redirect:/product/" + name + "/" + productId;
    }
}
