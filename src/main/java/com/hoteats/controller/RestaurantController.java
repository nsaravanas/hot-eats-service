package com.hoteats.controller;

import java.util.List;

import com.hoteats.models.Coordinate;
import com.hoteats.models.Restaurant;

public interface RestaurantController {

	Restaurant getRestaurantById(Long restaurantId);

	Restaurant addRestaurant(Restaurant restaurant);

	Restaurant updateRestaurant(Restaurant restaurant);

	void deleteRestaurant(Long restaurantId);

	List<Restaurant> restaurantsByGeo(Coordinate coordinate);

	List<Restaurant> restaurantsByLocation(String location);

}
