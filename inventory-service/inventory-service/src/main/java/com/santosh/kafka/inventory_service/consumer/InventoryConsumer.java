package com.santosh.kafka.inventory_service.consumer;
import com.santosh.kafka.inventory_service.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryConsumer {

//    @KafkaListener(
//            topics = "order-events",
//            groupId = "inventory-group"
//    )
//    public void consume(OrderEvent event) {
//
//        System.out.println("================================");
//
//        System.out.println(
//                "Inventory Updated For Order : "
//                        + event.getOrderId());
//
//        System.out.println(event);
//
//        System.out.println("================================");
//    }
//}

    @KafkaListener(topics = "order-events", groupId = "inventory-group")
    public void consume(OrderEvent orderEvent) {

        throw new RuntimeException("Inventory Service Failed");

    }
}