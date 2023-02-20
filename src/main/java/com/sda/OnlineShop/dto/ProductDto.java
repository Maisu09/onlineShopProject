package com.sda.OnlineShop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
    private String id;
    private String name;
    private String price;
    private String category;
    private String quantity;
    private String description;
    @ToString.Exclude
    private String image;

}
