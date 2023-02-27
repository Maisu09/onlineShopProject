package com.sda.OnlineShop.repository;

import com.sda.OnlineShop.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    ShoppingCart findByUserEmailAddress(String emailAddress);

}
