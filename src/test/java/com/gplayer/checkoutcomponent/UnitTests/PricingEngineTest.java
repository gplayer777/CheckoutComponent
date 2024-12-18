package com.gplayer.checkoutcomponent.UnitTests;

import com.gplayer.checkoutcomponent.model.Cart;
import com.gplayer.checkoutcomponent.model.Item;
import com.gplayer.checkoutcomponent.service.PricingEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingEngineTest {
    private PricingEngine pricingEngine;

    @BeforeEach
    void setUp() {
        pricingEngine = new PricingEngine();
    }

    @Test
    void testApplyComboDiscount() {
        Cart cart = new Cart();
        Item itemX = new Item("ItemX", 100, 0, 0);
        Item itemY = new Item("ItemY", 50, 0, 0);

        cart.addItem(itemX);
        cart.addItem(itemY);
        cart.addItem(itemY);


        int discount = pricingEngine.applyComboDiscount(cart, itemX, itemY, 30);
        assertEquals(30, discount);
    }
}

