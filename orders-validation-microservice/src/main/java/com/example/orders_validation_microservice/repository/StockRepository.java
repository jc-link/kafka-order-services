package com.example.orders_validation_microservice.repository;

import com.example.orders_validation_microservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends MongoRepository<Product, Long> {

    // Add a method to find a stock by product name
    Optional<Product> findByProduct(String product);
}
