package com.gplayer.checkoutcomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gplayer.checkoutcomponent.controller", "com.gplayer.checkoutcomponent.model", "com.gplayer.checkoutcomponent.service"})
public class CheckoutComponentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckoutComponentApplication.class, args);
    }

}
