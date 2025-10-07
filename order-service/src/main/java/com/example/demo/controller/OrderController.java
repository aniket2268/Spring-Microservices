package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderEventProducer;

@RestController
@RequestMapping("/orders")
public class OrderController {

	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderEventProducer orderEventProducer;
	
	
	@PostMapping
	public Order addOrder(@RequestBody Order order) {
		  return orderRepository.save(order);
	}
	
	@GetMapping
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
	
	@GetMapping("/user")
	public List<Order>getUserOrders(@RequestParam Long userId){
		return orderRepository.findAll();
	}
	
	@PostMapping("/place")
	public String placeOrder(@RequestBody Order order) {
	    orderEventProducer.produceEvent("Order Placed: " + order.getId());

	    return "Order placed successfully!";
	}
}

