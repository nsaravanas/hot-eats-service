package com.hoteats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteats.models.Restaurant;
import com.hoteats.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository repository;

	@Override
	public Restaurant getRestaurantById(Long restaurantId) {
		return this.repository.findOne(restaurantId);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return this.repository.findAll();
	}

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		return this.repository.save(restaurant);
	}

}
