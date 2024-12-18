package com.gplayer.checkoutcomponent.service;

import com.gplayer.checkoutcomponent.model.Cart;
import com.gplayer.checkoutcomponent.model.Item;
import org.springframework.stereotype.Service;


@Service
public class PricingEngine {
    public int applyComboDiscount(Cart cart, Item itemX, Item itemY, int discount) {
        int countX = cart.getItems().getOrDefault(itemX, 0);
        int countY = cart.getItems().getOrDefault(itemY, 0);

        int combos = Math.min(countX, countY);
        return combos * discount;
    }
}
