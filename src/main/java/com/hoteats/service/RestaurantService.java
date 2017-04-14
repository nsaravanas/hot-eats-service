package com.hoteats.service;

import java.util.List;

import com.hoteats.models.Restaurant;

public interface RestaurantService {

	Restaurant getRestaurantById(Long restaurantId);

	List<Restaurant> getAllRestaurants();

}
