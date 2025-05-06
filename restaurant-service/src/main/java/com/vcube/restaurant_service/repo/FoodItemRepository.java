package com.vcube.restaurant_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.restaurant_service.model.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

	List<FoodItem> findByRestaurantId(Long restaurantId);

}
