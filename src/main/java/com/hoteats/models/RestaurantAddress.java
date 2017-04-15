package com.hoteats.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class RestaurantAddress {

	@Id
	private Long restaurantAddressId;

	@JsonBackReference
	@ManyToOne
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
