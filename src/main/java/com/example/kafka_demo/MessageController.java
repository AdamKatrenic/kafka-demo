package com.example.kafka_demo; // <--- Skontroluj, či sedí s tvojím projektom

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // <--- Dôležité: Hovorí Springu, že toto je REST API
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer producer;

    // Presná URL bude: http://localhost:8080/api/v1/kafka/user
    @PostMapping("/api/v1/kafka/user")
    public String publishUser(@RequestBody UserEvent event) {
        producer.sendUserEvent(event);
        return "User event bol úspešne odoslaný!";
    }
}