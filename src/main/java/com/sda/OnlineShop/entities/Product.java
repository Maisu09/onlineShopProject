package com.sda.OnlineShop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table   nu e oblig. face tabel direct cu numele Product
public class Product {
    @Id
    @GeneratedValue
//    @Column(name = "productId")   daca nu punem column pune default numele de la field
    private Integer productId;
    private String name;
    private Integer price;
    private String category;
    private Integer quantity;
    private String description;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] image;

}
