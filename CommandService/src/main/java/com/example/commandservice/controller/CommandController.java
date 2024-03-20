package com.example.commandservice.controller;

import com.example.commandservice.entity.Product;
import com.example.commandservice.service.CommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("command")
@RequiredArgsConstructor
@Slf4j
public class CommandController {

    private final CommandService commandService;
    @PostMapping("addProduct")
    public String addProduct(@RequestBody Product  product) {
        return commandService.addProduct(product);
    }

    @PutMapping("updateProduct")
    public String updateProduct(@RequestParam Long productId,@RequestBody Product product) {
        return commandService.updateProduct(productId,product);
    }
}
