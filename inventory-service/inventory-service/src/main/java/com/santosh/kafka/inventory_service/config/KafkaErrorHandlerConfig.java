package com.santosh.kafka.inventory_service.config;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaErrorHandlerConfig {

    @Bean
    public DefaultErrorHandler errorHandler(
            KafkaTemplate<String, Object> kafkaTemplate) {

        DeadLetterPublishingRecoverer recoverer =
                new DeadLetterPublishingRecoverer(kafkaTemplate);

        FixedBackOff fixedBackOff =
                new FixedBackOff(2000L, 3);

        return new DefaultErrorHandler(
                recoverer,
                fixedBackOff);
    }

    @Bean
    public NewTopic dltTopic() {
        return TopicBuilder
                .name("order-events-dlt")
                .partitions(1)
                .replicas(1)
                .build();
    }
}