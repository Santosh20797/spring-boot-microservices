package com.santosh.kafka.order_service.repository;



import com.santosh.kafka.order_service.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}