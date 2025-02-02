package com.example.orders_microservice.service;

import com.example.orders_microservice.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private KafkaTemplate<String, OrderDTO> kafkaTemplate;

    @Override
    public String createOrder(OrderDTO orderDTO) {
        kafkaTemplate.send("orders", orderDTO);
        System.out.println("Order sended to topic");
        return "Hello there from service";
    }
}
