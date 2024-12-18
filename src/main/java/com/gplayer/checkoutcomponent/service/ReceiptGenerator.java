package com.gplayer.checkoutcomponent.service;

import com.gplayer.checkoutcomponent.model.Cart;
import com.gplayer.checkoutcomponent.model.Item;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReceiptGenerator {
    public String generateReceipt(Cart cart, double total) {
        StringBuilder receipt = new StringBuilder("Receipt:\n");
        for (Map.Entry<Item, Integer> entry : cart.getItems().entrySet()) {
            receipt.append(entry.getValue())
                    .append(" x ")
                    .append(entry.getKey().getName())
                    .append(" @ ")
                    .append(entry.getKey().getPrice())
                    .append(" cents each\n");
        }
        receipt.append("Total: ").append(total).append(" cents\n");
        return receipt.toString();
    }
}