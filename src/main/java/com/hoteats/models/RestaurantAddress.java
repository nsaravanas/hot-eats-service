package com.hoteats.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class RestaurantAddress {

	@Id
	private Long restaurantAddressId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "restaurantId", nullable = false)
	private Restaurant restaurant;

	@Embedded
	private Address address;

	public Long getRestaurantAddressId() {
		return restaurantAddressId;
	}

	public void setRestaurantAddressId(Long restaurantAddressId) {
		this.restaurantAddressId = restaurantAddressId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
