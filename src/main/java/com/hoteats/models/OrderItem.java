package com.hoteats.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue
	private Long orderItemId;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "orderId", nullable = false)
	private Orders orders;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "itemId", nullable = true)
	private Item item;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "eatItemId", nullable = true)
	private EatItem eatItem;

	@Column
	private Integer quantity;

	@Column
	private BigDecimal price;

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

	public EatItem getEatItem() {
		return eatItem;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setEatItem(EatItem eatItem) {
		this.eatItem = eatItem;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

}
