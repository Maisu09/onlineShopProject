package com.sda.OnlineShop.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ShoppingCart {
    @Id
    @GeneratedValue
    private Integer shoppingCartId;
    @OneToOne
    @JoinColumn
    private User user;
    @OneToMany(mappedBy = "shoppingCart")
    private List<SelectedProduct> selectedProducts;

}
