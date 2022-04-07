package com.apigateway.controller;

import com.apigateway.exception.ServiceUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FallBackController {
    @GetMapping("/profileServiceFallBack")
    public String profileServiceFallBack() {
        return "Profile service is down at this time";
    }

    @GetMapping("/productServiceFallBack")
    public String productServiceFallBack() {
        return "Product service is down at this time";
    }

    @GetMapping("/cartServiceFallBack")
    public String cartServiceFallBack() {
        return "Cart service is down at this time";
    }

    @GetMapping("/orderServiceFallBack")
    public String orderServiceFallBack() {
        return "Order service is down at this time";
    }

    @GetMapping("/authServiceFallBack")
    public void authServiceFallBack() {
        throw new ServiceUnavailableException("Auth service is down at this time");
//        return new ResponseEntity<>("Auth service is down at this time", HttpStatus.SERVICE_UNAVAILABLE);
    }

    @GetMapping("/paymentServiceFallBack")
    public String paymentServiceFallBack() {
        return "Payment service is down at this time";
    }


}
