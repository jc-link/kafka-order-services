package com.dev.product_microservice.service;

import com.dev.product_microservice.dto.ProductDTO;
import com.dev.product_microservice.dto.ProductResponseDTO;
import com.dev.product_microservice.exceptions.ProductAlreadyExistsException;
import com.dev.product_microservice.exceptions.ProductNotFoundException;
import com.dev.product_microservice.model.Product;
import com.dev.product_microservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public void addProduct(ProductDTO productDTO) {
        LOGGER.info("Adding product: {}", productDTO);
        Product product = modelMapper.map(productDTO, Product.class);
        if(productRepository.findByName(product.getName()).isPresent()){
            throw new ProductAlreadyExistsException("Product already exists with name: " + product.getName());
        }
        productRepository.save(product);
    }

    @Override
    public void updateProduct(ProductResponseDTO productResponseDTO) {
        Product existingProduct = productRepository.findById(productResponseDTO.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productResponseDTO.getProductId()));

        if(productResponseDTO.getName() != null){
            existingProduct.setName(productResponseDTO.getName());
        }
        if(productResponseDTO.getQuantity() != null){
            existingProduct.setQuantity(productResponseDTO.getQuantity());
        }
        if(productResponseDTO.getPrice() != null){
            existingProduct.setPrice(productResponseDTO.getPrice());
        }

        productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductResponseDTO getProduct(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
        return modelMapper.map(product, ProductResponseDTO.class);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductResponseDTO.class)).toList();
    }
}
