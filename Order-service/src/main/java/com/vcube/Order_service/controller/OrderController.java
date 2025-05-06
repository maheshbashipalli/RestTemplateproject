package com.vcube.Order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.Order_service.model.FoodItem;
import com.vcube.Order_service.model.Order;
import com.vcube.Order_service.model.Restaurant;
import com.vcube.Order_service.model.RestaurantClient;
import com.vcube.Order_service.repo.OrderRepository;
import com.vcube.Order_service.response.OrderResponse;
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private RestaurantClient restaurantClient;

	@PostMapping
	public Order placeOrder(@RequestBody Order order) {
		return orderRepo.save(order);
	}
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable("id") Long id) {
		Order order = orderRepo.findById(id).orElseThrow();
		Restaurant restaurant = restaurantClient.getRestaurant(order.getRestaurantId());
		List<FoodItem> foodItems = restaurantClient.getFoods(order.getRestaurantId());
		FoodItem selected = foodItems.stream().filter(f -> f.getId().equals(order.getFoodItemId())).findFirst()
				.orElse(null);
		return ResponseEntity.ok(new OrderResponse(order.getCustomerName(), restaurant, selected));
	}

}
