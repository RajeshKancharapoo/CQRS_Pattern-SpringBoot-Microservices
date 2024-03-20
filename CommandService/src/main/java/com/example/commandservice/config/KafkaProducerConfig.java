package com.example.commandservice.config;

import com.example.commandservice.entity.Product;
import com.example.commandservice.entity.ProductEvent;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, ProductEvent> producerFactory() {
        HashMap<String, Object> config = new HashMap<>();
        config.put("bootstrap.servers", "localhost:9092");
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.springframework.kafka.support.serializer.JsonSerializer");
        config.put("group.id", "group_id");
        return new DefaultKafkaProducerFactory<>(config, new StringSerializer(), new JsonSerializer<ProductEvent>());
    }

    @Bean
    public KafkaTemplate<String, ProductEvent> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
