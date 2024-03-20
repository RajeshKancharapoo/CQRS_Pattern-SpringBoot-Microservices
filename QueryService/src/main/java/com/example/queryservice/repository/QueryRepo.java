package com.example.queryservice.repository;

import com.example.queryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryRepo extends JpaRepository<Product, Long>{

}
