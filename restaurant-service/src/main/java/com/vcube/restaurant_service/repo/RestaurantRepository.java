package com.vcube.restaurant_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.restaurant_service.model.Restaurant;

public interface RestaurantRepository  extends JpaRepository<Restaurant, Long> {


}
