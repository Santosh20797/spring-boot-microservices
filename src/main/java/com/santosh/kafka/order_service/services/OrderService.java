package com.santosh.kafka.order_service.services;
import com.santosh.kafka.order_service.dto.OrderEvent;
import com.santosh.kafka.order_service.dto.OrderRequest;
import com.santosh.kafka.order_service.entity.OrderEntity;
import com.santosh.kafka.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderEntity createOrder(OrderRequest request) {

        OrderEntity savedOrder = repository.save(
                OrderEntity.builder()
                        .productName(request.getProductName())
                        .quantity(request.getQuantity())
                        .price(request.getPrice())
                        .status("CREATED")
                        .build());

        OrderEvent event = OrderEvent.builder()
                .orderId(savedOrder.getId())
                .productName(savedOrder.getProductName())
                .quantity(savedOrder.getQuantity())
                .price(savedOrder.getPrice())
                .status(savedOrder.getStatus())
                .build();

        kafkaTemplate.send("order-events", event);

        return savedOrder;
    }
}