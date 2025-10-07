package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.OrderResponse;

@FeignClient(name = "order-service")
public interface OrderClient {

	
	@GetMapping("/orders/user")
	List<OrderResponse> getUserOrders(@RequestParam("userId") Long userId); 
	
}
