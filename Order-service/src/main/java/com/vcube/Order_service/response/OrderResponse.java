package com.vcube.Order_service.response;

import com.vcube.Order_service.model.FoodItem;
import com.vcube.Order_service.model.Restaurant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class OrderResponse {

	public OrderResponse(String customerName2, Restaurant restaurant2, FoodItem fooditem) {
		this.customerName=customerName2;
		this.restaurant=restaurant2;
		this.foodItem=fooditem;
		
		

	}
	
	
	private String customerName;
	private Restaurant restaurant;
	private FoodItem foodItem;
	
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public FoodItem getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
		
	}
	
	
	

}

