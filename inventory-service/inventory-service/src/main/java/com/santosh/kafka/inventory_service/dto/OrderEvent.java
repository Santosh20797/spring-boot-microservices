package com.santosh.kafka.inventory_service.dto;
import lombok.Data;

@Data
public class OrderEvent {

    private Long orderId;
    private String productName;
    private Integer quantity;
    private Double price;
    private String status;
}