package com.gplayer.checkoutcomponent.service;


import com.gplayer.checkoutcomponent.model.Cart;
import com.gplayer.checkoutcomponent.model.Item;
import org.springframework.stereotype.Service;


import java.util.Map;

@Service
public class CheckoutService {
    private final Cart cart = new Cart();

    public void scanItem(Item item) {
        cart.addItem(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : cart.getItems().entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();

            // Apply multi-pricing discount if applicable
            if (item.getMultiPriceThreshold() > 0 && quantity >= item.getMultiPriceThreshold()) {
                total += quantity * item.getMultiPriceValue();
                total += (quantity % item.getMultiPriceThreshold()) * item.getPrice();
            } else {
                total += quantity * item.getPrice();
            }
        }
        return total;
    }

    public Cart getCart() {
        return cart;
    }

    public void clearCart() {
        cart.getItems().clear();
    }
}
