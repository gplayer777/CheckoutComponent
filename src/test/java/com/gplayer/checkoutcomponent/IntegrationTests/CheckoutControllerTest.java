package com.gplayer.checkoutcomponent.IntegrationTests;

import com.gplayer.checkoutcomponent.controller.CheckoutController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CheckoutController.class)
class CheckoutControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testScanItemEndpoint() throws Exception {
        String requestBody = """
            {
                "name": "A",
                "price": 40,
                "multiPriceThreshold": 3,
                "multiPriceValue": 30
            }
        """;

        mockMvc.perform(post("/checkout/scan")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("Item scanned: A"));
    }

    @Test
    void testGetTotalEndpoint() throws Exception {
        mockMvc.perform(get("/checkout/total"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(0.0));
    }

    @Test
    void testCompleteCheckoutEndpoint() throws Exception {
        mockMvc.perform(post("/checkout/complete"))
                .andExpect(status().isOk())
                .andExpect(content().string("Receipt:\nTotal: 0.0 cents\n"));
    }
}
