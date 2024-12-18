package com.gplayer.checkoutcomponent.UnitTests;


import com.gplayer.checkoutcomponent.model.Item;
import com.gplayer.checkoutcomponent.service.CheckoutService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutServiceTest {
    private CheckoutService checkoutService;

    @BeforeEach
    void setUp() {
        checkoutService = new CheckoutService();
    }

    @Test
    void testScanItemAndCalculateTotal() {
        Item a = new Item("A", 40, 3, 30); // Multi-price: 3 for 90
        Item b= new Item("B", 10, 2, 7.5);


        checkoutService.scanItem(a);
        checkoutService.scanItem(a);
        checkoutService.scanItem(a);
        checkoutService.scanItem(b);


        double total = checkoutService.calculateTotal();
        assertEquals(100, total);
    }

    @Test
    void testEmptyCartTotal() {
        double total = checkoutService.calculateTotal();
        assertEquals(0, total);
    }
}

