package com.santosh.kafka.order_service.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderEvent {

    private Long orderId;
    private String productName;
    private Integer quantity;
    private Double price;
    private String status;
}