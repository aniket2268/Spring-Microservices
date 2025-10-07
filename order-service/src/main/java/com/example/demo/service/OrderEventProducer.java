package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventProducer {

	
	@Autowired
	private KafkaTemplate<String, String>kafkaTemplate;
	
	public void produceEvent(String orderEvent) {
		kafkaTemplate.send("order event",orderEvent);
		System.out.println("Event produced");
		
	}
}
