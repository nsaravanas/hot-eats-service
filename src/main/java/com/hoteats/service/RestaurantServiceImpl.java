package com.hoteats.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteats.models.Coordinate;
import com.hoteats.models.Restaurant;
import com.hoteats.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository repository;

	@Override
	@Transactional
	public Restaurant getRestaurantById(Long restaurantId) {
		return this.repository.findOne(restaurantId);
	}

	@Override
	@Transactional
	public List<Restaurant> getAllRestaurants() {
		return this.repository.findAll();
	}

	@Override
	@Transactional
	public Restaurant saveRestaurant(Restaurant restaurant) {
		return this.repository.save(restaurant);
	}

	@Override
	@Transactional
	public Restaurant addRestaurant(Restaurant restaurant) {
		return this.repository.save(restaurant);
	}

	@Override
	@Transactional
	public Restaurant updateRestaurant(Restaurant restaurant) {
		return this.repository.save(restaurant);
	}

	@Override
	@Transactional
	public void deleteRestaurant(Long restaurantId) {
		this.repository.delete(restaurantId);
	}

	@Override
	@Transactional
	public List<Restaurant> restaurantsByGeo(Coordinate coordinate) {
		return this.repository.restaurantsByGeo(coordinate);
	}

	@Override
	@Transactional
	public List<Restaurant> restaurantsByLocation(String location) {
		return this.repository.restaurantsByLocation(location);
	}

}
