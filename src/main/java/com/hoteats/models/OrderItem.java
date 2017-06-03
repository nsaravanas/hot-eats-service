package com.hoteats.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class OrderItem {

	@Id
	private Long id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "orderId", nullable = false)
	private Orders orders;

	@ManyToOne
	@JoinColumn(name = "itemId", nullable = true)
	private Item item;

	@ManyToOne
	@JoinColumn(name = "eatItemId", nullable = true)
	private EatItem eatItem;

	@Column
	private Integer quantity;

	@Column
	private BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
