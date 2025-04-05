package com.kafka.notification.configuration;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    private final WebSocketNotificationHandler notificationHandler;

    public NotificationConsumer(WebSocketNotificationHandler notificationHandler) {
        this.notificationHandler = notificationHandler;
    }

    @KafkaListener(topics = "notification", groupId = "notification-group")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Received Kafka Notification: " + record.value());
        notificationHandler.sendNotification(record.value());
    }
}
