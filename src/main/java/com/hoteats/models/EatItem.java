package com.hoteats.models;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hoteats.models.enums.ItemType;
import com.hoteats.models.enums.Status;

@Entity
public class EatItem {

	@Id
	@GeneratedValue
	private Long eatItemId;

	@Column
	private String name;

	@Column
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column
	private BigDecimal price;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "itemOfferId", nullable = true)
	private ItemOffer offer;

	@Column
	@Enumerated(EnumType.STRING)
	private ItemType type;

	@Column
	private String description;

	public Long getEatItemId() {
		return eatItemId;
	}

	public void setEatItemId(Long eatItemId) {
		this.eatItemId = eatItemId;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ItemOffer getOffer() {
		return offer;
	}

	public void setOffer(ItemOffer offer) {
		this.offer = offer;
	}

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

}