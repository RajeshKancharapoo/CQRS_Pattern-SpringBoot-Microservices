package com.example.commandservice.service;

import com.example.commandservice.entity.Product;
import com.example.commandservice.entity.ProductEvent;
import com.example.commandservice.repository.CommandRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandService {
    private final CommandRepo commandRepo;
    private final KafkaEventProducer kafkaEventProducer;
    public String addProduct(Product product) {
        commandRepo.save(product);
        return "Product added successfully";
    }

    public String updateProduct(Long productId,Product product) {
        Product ans = commandRepo.findById(productId).orElse(null);
        ans.setPrice(product.getPrice());
        ans.setProductName(product.getProductName());
        ans.setStock(product.getStock());
        kafkaEventProducer.sendEvent(ProductEvent.builder()
                .productId(ans.getProductId())
                .productName(ans.getProductName())
                .price(ans.getPrice())
                .stock(ans.getStock())
                .build());
        return "Product updated successfully";
    }
}
