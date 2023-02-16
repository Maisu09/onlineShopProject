package com.sda.OnlineShop.service;

import com.sda.OnlineShop.dto.ProductDto;
import com.sda.OnlineShop.entities.Product;
import com.sda.OnlineShop.mapper.ProductMapper;
import com.sda.OnlineShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductDto productDto) {
        Product product = productMapper.map(productDto);
        productRepository.save(product);
    }

}
