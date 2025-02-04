package com.dev.product_microservice.controller;

import com.dev.product_microservice.dto.ProductDTO;
import com.dev.product_microservice.dto.ProductResponseDTO;
import com.dev.product_microservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @PostMapping
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        LOGGER.info("Adding product: {}", productDTO);
        productService.addProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        LOGGER.info("Fetching all products");
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable String productId) {
        LOGGER.info("Fetching product with id: {}", productId);
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @PatchMapping
    public ResponseEntity<?> updateProduct(@RequestBody ProductResponseDTO productDTO) {
        LOGGER.info("Updating product: {}", productDTO);
        productService.updateProduct(productDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId) {
        LOGGER.info("Deleting product with id: {}", productId);
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }


}
