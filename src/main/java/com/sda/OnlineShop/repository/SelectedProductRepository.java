package com.sda.OnlineShop.repository;

import com.sda.OnlineShop.entities.SelectedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectedProductRepository extends JpaRepository<SelectedProduct, Integer> {
}
