package com.example.queryservice.service;

import com.example.queryservice.entity.ProductEvent;
import com.example.queryservice.repository.QueryRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaEventConsumer {

        private final QueryRepo queryRepo;

        @KafkaListener(topics = "product-topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
        public void consume(String productEvent) throws JsonProcessingException {
                ObjectMapper objectMapper = new ObjectMapper();
                var product = objectMapper.readValue(productEvent, ProductEvent.class);
                log.info("Consumed product event: {}", product);
                queryRepo.findById(product.getProductId())
                        .ifPresentOrElse(
                                p -> {
                                    p.setProductId(product.getProductId());
                                    p.setProductName(product.getProductName());
                                    p.setPrice(product.getPrice());
                                    p.setStock(product.getStock());
                                    queryRepo.save(p);
                                    log.info("Product quantity updated: {}", p);
                                },
                                () -> log.info("Product not found: {}", product.getProductId()));
        }
}
