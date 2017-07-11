package com.hoteats.user.pref;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.hoteats.models.Item;
import com.hoteats.models.User;

@Entity
public class UserPreference {

	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@OneToMany
	private List<Item> favourites;

	@OneToMany
	private List<Item> pastOrders;

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

	public List<Item> getFavourites() {
		return favourites;
	}

	public void setFavourites(List<Item> favourites) {
		this.favourites = favourites;
	}

	public List<Item> getPastOrders() {
		return pastOrders;
	}

	public void setPastOrders(List<Item> pastOrders) {
		this.pastOrders = pastOrders;
	}

}
