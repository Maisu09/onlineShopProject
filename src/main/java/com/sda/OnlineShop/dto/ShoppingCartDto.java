package com.sda.OnlineShop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ShoppingCartDto {
    private List<SelectedProductDto> selectedProductDtos;
    private String subtotal;
    private String shipping;
    private String total;
}
