package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderClient orderClient;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){
		  try {
			User saveUser= userRepository.save(user);
			return ResponseEntity.ok(saveUser);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body("Bad request");
		}
	}
	
	@GetMapping
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/orders")
    public List<OrderResponse> getUserOrders(@RequestParam Long userId) {
        return orderClient.getUserOrders(userId);
    }
}
