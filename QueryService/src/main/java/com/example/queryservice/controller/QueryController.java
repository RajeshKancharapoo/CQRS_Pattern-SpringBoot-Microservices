package com.example.queryservice.controller;

import com.example.queryservice.entity.Product;
import com.example.queryservice.service.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query")
@RequiredArgsConstructor
public class QueryController {

    private final QueryService queryService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>>fetchAllProducts(){
        return queryService.fetchAllProducts();
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> fetchProductById(@PathVariable Long productId){
        return queryService.fetchProductById(productId);
    }

}
