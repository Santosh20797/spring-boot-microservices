package com.santosh.kafka.inventory_service.consumer;
import com.santosh.kafka.inventory_service.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DltConsumer {

    @KafkaListener(
            topics = "order-events-dlt",
            groupId = "inventory-dlt-group"
    )
    public void consumeDlt(OrderEvent event) {

        System.out.println("================================");
        System.out.println("MESSAGE MOVED TO DLQ");
        System.out.println(event);
        System.out.println("================================");
    }
}