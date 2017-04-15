package com.hoteats.models;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hoteats.models.enums.ItemType;
import com.hoteats.models.enums.Status;

@Entity
public class Item {

	@Id
	private Long itemId;

	@Column
	private String name;

	@Column
	@Enumerated(EnumType.STRING)
	private Status status;

	@ElementCollection
	private Set<String> tags;

	@Column
	private BigDecimal price;

	@JsonBackReference
	@ManyToOne
	private Menu menu;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ItemOffer offer;

	@Column
	@Enumerated(EnumType.STRING)
	private ItemType type;

	@Column
	private String description;

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ItemOffer getOffer() {
		return offer;
	}

	public void setOffer(ItemOffer offer) {
		this.offer = offer;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

}
