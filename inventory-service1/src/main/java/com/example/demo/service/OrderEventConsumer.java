package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

	
	@KafkaListener(topics = "order-topic",groupId = "inventory-group")
	public void consumeOrderEvent(String message) {
        System.out.println("📦 Inventory Service Consumed: " + message);
        
    }

}
