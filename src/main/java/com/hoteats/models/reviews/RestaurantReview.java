package com.hoteats.models.reviews;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.hoteats.models.Restaurant;
import com.hoteats.models.User;
import com.hoteats.models.audit.AuditInfo;

@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
public class RestaurantReview extends AuditInfo {

	@Id
	private Long id;

	@ManyToOne
	private User user;

	@ManyToOne
	private Restaurant restaurant;

	@Column
	private String review;

	@Column
	private Integer rating;

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
}
