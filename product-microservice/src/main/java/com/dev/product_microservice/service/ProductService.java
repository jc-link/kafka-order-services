package com.dev.product_microservice.service;

import com.dev.product_microservice.dto.ProductDTO;
import com.dev.product_microservice.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    public void addProduct(ProductDTO productDTO);
    public void updateProduct(ProductResponseDTO productResponseDTO);
    public void deleteProduct(String productId);
    public ProductResponseDTO getProduct(String productId);
    public List<ProductResponseDTO> getAllProducts();
}
