package com.hoteats.common.review;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hoteats.models.User;

@Entity
@Table(name = "FEEDBACK")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Feedback {

	@Id
	private Long id;

	@ManyToOne
	private User user;

	@Column
	private String review;

	@Column
	private Integer rating;

	private LocalDateTime addedOn;

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
