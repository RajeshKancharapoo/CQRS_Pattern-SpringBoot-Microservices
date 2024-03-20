package com.example.commandservice.service;

import com.example.commandservice.entity.ProductEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaEventProducer {

    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;
    public void sendEvent(ProductEvent productEvent) {
        log.info("Sending event {}", productEvent);
        kafkaTemplate.send("product-topic", productEvent);
    }
}
