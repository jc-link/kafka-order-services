package com.example.orders_validation_microservice.DTO;

import lombok.Data;

@Data
public class Order {
    private String product;
    private int quantity;
}