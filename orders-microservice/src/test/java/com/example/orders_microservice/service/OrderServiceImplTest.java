package com.example.orders_microservice.service;

import com.example.orders_microservice.dto.OrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class OrderServiceImplTest {

    @Mock
    private KafkaTemplate<String, OrderDTO> kafkaTemplate;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createOrder() {
        // given
        OrderDTO orderDTO = new OrderDTO();
        String expectedResponse = "Hello there from service";

        // when
        String actualResponse = orderService.createOrder(orderDTO);

        // then
        assertEquals(expectedResponse, actualResponse);
        verify(kafkaTemplate).send("orders", orderDTO);
    }
}