    package com.santosh.kafka.order_service.services;

    import org.springframework.beans.factory.annotation.Autowired;
    import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.RestTemplate;

    @Service
    public class PaymentService {

        @Autowired
        private RestTemplate restTemplate;

        @CircuitBreaker(
                name = "paymentService",
                fallbackMethod = "paymentFallback")
        public String processPayment() {

            return restTemplate.getForObject(
                    "http://localhost:8083/payments",
                    String.class);
        }

        public String paymentFallback(Exception ex) {

            System.out.println("Fallback Triggered : "
                    + ex.getMessage());

            return "Payment Service is Down";
        }
    }