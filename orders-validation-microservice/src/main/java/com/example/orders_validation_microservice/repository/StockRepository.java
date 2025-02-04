package com.example.orders_validation_microservice.repository;

import com.example.orders_validation_microservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface StockRepository extends MongoRepository<Product, String> {

    Optional<Product> findByName(String name);

}
