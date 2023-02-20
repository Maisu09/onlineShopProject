package com.sda.OnlineShop.mapper;

import com.sda.OnlineShop.dto.ProductDto;
import com.sda.OnlineShop.entities.Product;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ProductMapper {

    public Product map(ProductDto productDto, MultipartFile productImage) {
        Product product = new Product();

        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setPrice(Integer.valueOf(productDto.getPrice()));
        product.setQuantity(Integer.valueOf(productDto.getQuantity()));
        product.setDescription(productDto.getDescription());
        product.setImage(convertToByte(productImage));
        productDto.setImage(Base64.encodeBase64String(product.getImage()));

        return product;
    }

    public ProductDto map(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(String.valueOf(product.getPrice()));
        productDto.setCategory(product.getCategory());
        productDto.setQuantity(String.valueOf(product.getQuantity()));
        productDto.setDescription(product.getDescription());
        productDto.setId(String.valueOf(product.getProductId()));
        return productDto;
    }

    private byte[] convertToByte(MultipartFile multipartFile) {
        try {
            return multipartFile.getBytes();
        } catch (IOException e) {
            return new byte[0];
        }

    }

}
