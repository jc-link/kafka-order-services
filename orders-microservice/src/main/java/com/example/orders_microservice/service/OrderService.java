package com.example.orders_microservice.service;

import com.example.orders_microservice.dto.OrderDTO;

public interface OrderService {
    public String createOrder(OrderDTO orderDTO);
}
