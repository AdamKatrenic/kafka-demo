package com.example.kafka_demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic demoTopic() {
        return TopicBuilder.name("moj-topic")
                .partitions(3) // Správy sa rozdelia do 3 partition pre lepšiu škálovateľnosť
                .replicas(1)   // Keďže v dockeri ti beží asi len 1 broker
                .build();
    }
}