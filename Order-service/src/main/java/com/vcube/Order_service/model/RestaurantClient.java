package com.vcube.Order_service.model;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "restaurant-service", url = "http://localhost:9292")

public interface RestaurantClient {

	@GetMapping("/restaurants/{id}")
	Restaurant getRestaurant(@PathVariable("id") Long id);

	@GetMapping("/restaurants/{id}/foods")
	List<FoodItem> getFoods(@PathVariable("id") Long id);

}
