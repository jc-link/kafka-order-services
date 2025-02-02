package com.example.orders_validation_microservice.service;


import com.example.orders_validation_microservice.DTO.Order;
import com.example.orders_validation_microservice.repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class StockValidationService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final StockRepository stockRepository;

    @KafkaListener(topics = "orders", groupId = "stock-validation", containerFactory = "kafkaListenerContainerFactory")
    @Transactional
    public void consumeOrder(Order order) {
        // log the order received
        System.out.println("Order received: " + order);
//        Optional<Stock> stockOpt = stockRepository.findByProductName(orderDTO.getProduct());
//
//        if(stockOpt.isPresent()) {
//            Stock stock = stockOpt.get();
//            if(stock.getQuantity() >= orderDTO.getQuantity()) {
//                stock.setQuantity(stock.getQuantity() - orderDTO.getQuantity());
//                stockRepository.save(stock);
//                kafkaTemplate.send("orders-validated", orderDTO);
//            } else {
//                kafkaTemplate.send("orders-rejected", orderDTO);
//            }
//        } else {
//            kafkaTemplate.send("orders-rejected", orderDTO);
//        }
    }
}
