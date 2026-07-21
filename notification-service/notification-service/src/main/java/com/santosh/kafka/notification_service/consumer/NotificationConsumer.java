package com.santosh.kafka.notification_service.consumer;
import com.santosh.kafka.notification_service.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @KafkaListener(topics = "order-events", groupId = "notification-group")
    public void consume(OrderEvent orderEvent) {

        System.out.println("================================");
        System.out.println("Notification Sent For Order : "
                + orderEvent.getOrderId());
        System.out.println(orderEvent);
        System.out.println("================================");
    }
}