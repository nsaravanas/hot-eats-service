package com.hoteats.controller;

import java.util.List;

import com.hoteats.models.Restaurant;

public interface RestaurantController {

	Restaurant getRestaurantById(Long restaurantId);

	List<Restaurant> getAllRestaurants();

}
