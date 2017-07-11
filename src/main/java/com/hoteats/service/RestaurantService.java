package com.hoteats.service;

import java.util.List;

import com.hoteats.models.Coordinate;
import com.hoteats.models.Restaurant;

public interface RestaurantService {

	Restaurant getRestaurantById(Long restaurantId);

	List<Restaurant> getAllRestaurants();

	Restaurant saveRestaurant(Restaurant testRestaurant);

	Restaurant addRestaurant(Restaurant restaurant);

	Restaurant updateRestaurant(Restaurant restaurant);

	void deleteRestaurant(Long restaurantId);

	List<Restaurant> restaurantsByGeo(Coordinate coordinate);

	List<Restaurant> restaurantsByLocation(String location);

}
