package com.gplayer.checkoutcomponent.controller;

import com.gplayer.checkoutcomponent.model.Item;
import com.gplayer.checkoutcomponent.service.CheckoutService;
import com.gplayer.checkoutcomponent.service.ReceiptGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    private final CheckoutService checkoutService;
    private final ReceiptGenerator receiptGenerator;

    public CheckoutController(CheckoutService checkoutService, ReceiptGenerator receiptGenerator) {
        this.checkoutService = checkoutService;
        this.receiptGenerator = receiptGenerator;
    }

    @PostMapping("/scan")
    public String scanItem(@RequestBody Item item) {
        checkoutService.scanItem(item);
        return "Item scanned: " + item.getName();
    }

    @GetMapping("/total")
    public Map<String, Object> getTotal() {
        double total = checkoutService.calculateTotal();
        return Map.of(
                "cart", checkoutService.getCart().getItems(),
                "total", total
        );
    }

    @PostMapping("/complete")
    public String completeCheckout() {
        double total = checkoutService.calculateTotal();
        String receipt = receiptGenerator.generateReceipt(checkoutService.getCart(), total);
        checkoutService.clearCart();
        return receipt;
    }
}