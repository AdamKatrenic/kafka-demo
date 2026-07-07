package com.example.kafka_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    // Táto anotácia povie Springu, aby metódu spustil zakaždým, keď do topicu príde správa
    @KafkaListener(topics = "moj-topic", groupId = "my-demo-group")
    public void consume(String message) {
        log.info("==> PRIJATA SPRAVA: {}", message);
    }
}