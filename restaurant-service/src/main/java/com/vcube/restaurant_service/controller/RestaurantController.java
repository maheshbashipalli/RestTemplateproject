package com.vcube.restaurant_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.restaurant_service.model.FoodItem;
import com.vcube.restaurant_service.model.Restaurant;
import com.vcube.restaurant_service.repo.FoodItemRepository;
import com.vcube.restaurant_service.repo.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor

public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private FoodItemRepository foodItemRepository;

	@GetMapping
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	@GetMapping("/{id}/foods")
	public List<FoodItem> getAllItems(@PathVariable("id") long id) {
		return foodItemRepository.findByRestaurantId(id);
	}

	@PostMapping("/add")
	public Restaurant addRestaurants(@RequestBody Restaurant rst) {
		return restaurantRepository.save(rst);
	}

	@GetMapping("/{id}")
	public Restaurant getRestaurantById(@PathVariable("id") long id) {
		return restaurantRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));
	}

	@PostMapping("/additems")
	public ResponseEntity<FoodItem> createFooooodItem(@RequestBody FoodItem foodItem) {
		Restaurant restaurant = restaurantRepository.findById(foodItem.getRestaurant().getId())
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));
		foodItem.setRestaurant(restaurant);
		FoodItem savedFoodItem = foodItemRepository.save(foodItem);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedFoodItem);
	}
}
