package com.example.kafka_demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer producer;

    // Volanie cez: http://localhost:8080/api/v1/kafka/publish?msg=AhojKafka
    @GetMapping("/api/v1/kafka/publish")
    public String publish(@RequestParam("msg") String message) {
        producer.sendMessage(message);
        return "Správa bola úspešne odoslaná do Kafky!";
    }
}