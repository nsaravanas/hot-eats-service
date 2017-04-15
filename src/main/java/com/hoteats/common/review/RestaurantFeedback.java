package com.hoteats.common.review;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hoteats.models.Restaurant;

@Entity
@Table(name = "FEEDBACK_RESTAURANT")
public class RestaurantFeedback extends Feedback {

	@ManyToOne
	private Restaurant restaurant;

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
