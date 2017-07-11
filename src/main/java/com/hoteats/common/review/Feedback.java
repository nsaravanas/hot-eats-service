package com.hoteats.common.review;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hoteats.models.User;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = ItemFeedback.class, name = "item"),
		@JsonSubTypes.Type(value = OrdersFeedback.class, name = "orders"),
		@JsonSubTypes.Type(value = RestaurantFeedback.class, name = "restaurant"),
		@JsonSubTypes.Type(value = AppFeedback.class, name = "app") })
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@Column
	private String review;

	@Column
	private Integer rating;

	@Column
	private LocalDateTime addedOn;

	@Column
	private LocalDateTime updatedOn;

	public Integer getRating() {
		return rating;
	}

	public String getReview() {
		return review;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public void setReview(String review) {
		this.review = review;
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

	public LocalDateTime getAddedOn() {
		return addedOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setAddedOn(LocalDateTime addedOn) {
		this.addedOn = addedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
}
