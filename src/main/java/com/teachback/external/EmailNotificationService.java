package com.teachback.external;

import com.teachback.garage.NotificationService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {

    @PostConstruct
    void init() {
        System.out.println("[lifecycle] EmailNotificationService ready");
    }

    @PreDestroy
    void cleanup() {
        System.out.println("[lifecycle] EmailNotificationService closing");
    }

    @Override
    public void send(String message) {
        System.out.println("[email] " + message);
    }
}
