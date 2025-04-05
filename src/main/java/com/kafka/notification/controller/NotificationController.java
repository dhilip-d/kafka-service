package com.kafka.notification.controller;

import com.kafka.notification.configuration.NotificationProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationProducer notificationProducer;

    public NotificationController(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    @PostMapping("/send")
    public String sendNotification(@RequestParam String message) {
        notificationProducer.sendNotification(message);
        return "Notification request sent!";
    }
}

