package com.example.kafka_demo; // skontroluj, či ti sedí názov tvojho balíčka

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    // Kľúčové je, aby tu bol typ <String, UserEvent> namiesto starého <String, String>
    private final KafkaTemplate<String, UserEvent> kafkaTemplate;

    // Názov metódy musí byť presne sendUserEvent, aby ju Controller videl
    public void sendUserEvent(UserEvent event) {
        log.info("Posielam JSON objekt: {}", event);
        kafkaTemplate.send("user-topic", event);
    }
}