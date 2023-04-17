package com.sda.OnlineShop.service;

import com.sda.OnlineShop.entities.CustomerOrder;
import com.sda.OnlineShop.entities.SelectedProduct;
import com.sda.OnlineShop.entities.ShoppingCart;
import com.sda.OnlineShop.entities.User;
import com.sda.OnlineShop.repository.CustomerOrderRepository;
import com.sda.OnlineShop.repository.SelectedProductRepository;
import com.sda.OnlineShop.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private SelectedProductRepository selectedProductRepository;
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public void launchOrder(String authenticatedUserEmail) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserEmailAddress(authenticatedUserEmail);

        User user = shoppingCart.getUser();

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setUser(user);
        customerOrderRepository.save(customerOrder);

        for (SelectedProduct selectedProduct : shoppingCart.getSelectedProducts()) {
            selectedProduct.setShoppingCart(null);
            selectedProduct.setCustomerOrder(customerOrder);
            selectedProductRepository.save(selectedProduct);
        }
    }
}
