package com.example.kafka_demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    // Spring ho automaticky nakonfiguruje a injektne vďaka Lombok @RequiredArgsConstructor
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Posielam spravu: {}", message);
        kafkaTemplate.send("moj-topic", message);
    }
}