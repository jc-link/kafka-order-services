package com.example.orders_microservice.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private String product;
    private int quantity;
}
