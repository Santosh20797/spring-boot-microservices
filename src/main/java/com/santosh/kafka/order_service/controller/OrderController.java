package com.santosh.kafka.order_service.controller;
import com.santosh.kafka.order_service.dto.OrderRequest;
import com.santosh.kafka.order_service.entity.OrderEntity;
import com.santosh.kafka.order_service.services.OrderService;
import com.santosh.kafka.order_service.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final PaymentService paymentService;

    @GetMapping
    public String test() {
        return "Order Service Running";
    }

    @GetMapping("/payment-test")
    public String paymentTest() {
        return paymentService.processPayment();
    }
}