package com.sda.OnlineShop.service;

import com.sda.OnlineShop.dto.ProductDto;
import com.sda.OnlineShop.entities.Product;
import com.sda.OnlineShop.mapper.ProductMapper;
import com.sda.OnlineShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductDto productDto, MultipartFile productImage) {

        Product product = productMapper.map(productDto, productImage);
        productRepository.save(product);
    }

    public List<ProductDto> getAllProductDtos() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = productMapper.map(product);

            productDtos.add(productDto);
        }

        return productDtos;


    }
}
