package com.sda.OnlineShop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SelectedProduct {
    @Id
    @GeneratedValue
    private Integer selectedProductId;
    @ManyToOne
    @JoinColumn
    private Product product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn
    private ShoppingCart shoppingCart;
}
