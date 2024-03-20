package com.example.commandservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEvent {

    private Long productId;
    private String productName;
    private Long price;
    private Long stock;
}
