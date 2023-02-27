package com.sda.OnlineShop.service;

import com.sda.OnlineShop.dto.SelectedProductDto;
import com.sda.OnlineShop.dto.ShoppingCartDto;
import com.sda.OnlineShop.entities.Product;
import com.sda.OnlineShop.entities.SelectedProduct;
import com.sda.OnlineShop.entities.ShoppingCart;
import com.sda.OnlineShop.repository.ProductRepository;
import com.sda.OnlineShop.repository.SelectedProductRepository;
import com.sda.OnlineShop.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    SelectedProductRepository selectedProductRepository;

    public void addToCart(SelectedProductDto selectedProductDto,
                          String productId,
                          String authentificatedUserEmail
    ) {
        Optional<Product> optionalProduct = productRepository.findById(Integer.valueOf(productId));
        Product product = optionalProduct.get();
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserEmailAddress(authentificatedUserEmail);
        SelectedProduct selectedProduct = new SelectedProduct();

        selectedProduct.setQuantity(Integer.valueOf(selectedProductDto.getQuantity()));
        selectedProduct.setProduct(product);
        selectedProduct.setShoppingCart(shoppingCart);

        selectedProductRepository.save(selectedProduct);
    }

    private SelectedProduct buildProduct(SelectedProductDto selectedProductDto, Product product, ShoppingCart shoppingCart)
    {
        SelectedProduct selectedProduct = new SelectedProduct();

        selectedProduct.setQuantity(Integer.valueOf(selectedProductDto.getQuantity()));
        selectedProduct.setProduct(product);
        selectedProduct.setShoppingCart(shoppingCart);
    }

    public ShoppingCartDto getShoppingCartDto(String authentificatedEmail) {
        return  null;
        //TODO:

    }
}
