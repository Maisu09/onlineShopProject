package com.sda.OnlineShop.mapper;

import com.sda.OnlineShop.dto.ProductDto;
import com.sda.OnlineShop.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product map(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setPrice(Integer.valueOf(productDto.getPrice()));
        product.setQuantity(Integer.valueOf(productDto.getQuantity()));
        product.setDescription(productDto.getDescription());

        return product;
    }

}
