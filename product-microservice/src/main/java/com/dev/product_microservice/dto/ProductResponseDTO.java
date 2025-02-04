package com.dev.product_microservice.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private String productId;
    private String name;
    private Integer quantity;
    private Integer price;
}
