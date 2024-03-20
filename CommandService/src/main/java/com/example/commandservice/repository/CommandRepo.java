package com.example.commandservice.repository;

import com.example.commandservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepo extends JpaRepository<Product, Long>{

}
