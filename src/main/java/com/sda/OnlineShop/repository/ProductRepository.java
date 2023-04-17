package com.sda.OnlineShop.repository;

import com.sda.OnlineShop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
