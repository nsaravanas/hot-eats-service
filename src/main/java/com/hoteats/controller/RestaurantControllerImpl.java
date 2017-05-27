package com.hoteats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoteats.commons.CommonStubs;
import com.hoteats.models.Coordinate;
import com.hoteats.models.Restaurant;
import com.hoteats.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantControllerImpl implements RestaurantController {

	@Autowired
	private RestaurantService service;

	@Override
	@RequestMapping(value = "/restaurant/{restaurantId}", method = RequestMethod.GET)
	public Restaurant getRestaurantById(@PathVariable Long restaurantId) {
		return this.service.getRestaurantById(restaurantId);
	}

	@Override
	@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
	public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
		return this.service.addRestaurant(restaurant);
	}

	@Override
	@RequestMapping(value = "/restaurant", method = RequestMethod.PUT)
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
		return this.service.updateRestaurant(restaurant);
	}

	@Override
	@RequestMapping(value = "/restaurant/{restaurantId}", method = RequestMethod.DELETE)
	public void deleteRestaurant(@PathVariable Long restaurantId) {
		this.service.deleteRestaurant(restaurantId);
	}

	@Override
	@RequestMapping(value = "/restaurant/geo", method = RequestMethod.GET)
	public List<Restaurant> restaurantsByGeo(@RequestBody Coordinate coordinate) {
		return this.service.restaurantsByGeo(coordinate);
	}

	@Override
	@RequestMapping(value = "/restaurant/{location}", method = RequestMethod.DELETE)
	public List<Restaurant> restaurantsByLocation(@PathVariable String location) {
		return this.service.restaurantsByLocation(location);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Restaurant> getAllRestaurants() {
		return this.service.getAllRestaurants();
	}

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Restaurant testRestaurant() {
		return this.service.addRestaurant(CommonStubs.testRestaurant());
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Restaurant addRestaurant() {
		return this.service.saveRestaurant(CommonStubs.testRestaurant());
	}
}
