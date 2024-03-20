package com.example.queryservice.service;


import com.example.queryservice.entity.Product;
import com.example.queryservice.repository.QueryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryService {

    private final QueryRepo queryRepo;
    public ResponseEntity<List<Product>> fetchAllProducts() {
        return ResponseEntity.ok(queryRepo.findAll());
    }

    public ResponseEntity<Product> fetchProductById(Long productId) {
        return ResponseEntity.ok(queryRepo.findById(productId).get());
    }
}
