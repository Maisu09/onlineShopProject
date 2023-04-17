package com.sda.OnlineShop.mapper;

import com.sda.OnlineShop.dto.SelectedProductDto;
import com.sda.OnlineShop.entities.SelectedProduct;
import org.springframework.stereotype.Component;

@Component
public class SelectedProductMapper {

    public SelectedProductDto map(SelectedProduct selectedProduct) {
        SelectedProductDto selectedProductDto = new SelectedProductDto();

        selectedProductDto.setName(selectedProduct.getProduct().getName());
        selectedProductDto.setPriceOfProduct(String.valueOf(selectedProduct.getProduct().getName()));
        selectedProductDto.setQuantity(String.valueOf(selectedProduct.getQuantity()));
        selectedProductDto.setPriceTimesQuantity(String.valueOf(selectedProduct.getProduct().getPrice() * selectedProduct.getQuantity()));

        return selectedProductDto;
    }
}
