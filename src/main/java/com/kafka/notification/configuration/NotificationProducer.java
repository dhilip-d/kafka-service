package com.kafka.notification.configuration;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "notification";

    public NotificationProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Kafka Notification Sent: " + message);
    }
}
