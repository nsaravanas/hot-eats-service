package com.hoteats.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hoteats.models.enums.Status;

@Entity
public class Orders {

	@Id
	@GeneratedValue
	private Long orderId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@JsonManagedReference
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderItem> orderItems;

	@Column
	private LocalDateTime orderedOn;

	@Column
	private LocalDateTime updatedOn;

	@Column
	private String updatedBy;

	@Column
	@Enumerated(EnumType.STRING)
	private Status status = Status.PLACED;

	@Embedded
	private OrderPrice orderPrice;

	@JsonManagedReference
	@OneToOne(mappedBy = "orders", cascade = CascadeType.ALL)
	private Delivery delivery;

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public OrderPrice getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(OrderPrice orderPrice) {
		this.orderPrice = orderPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderedOn() {
		return orderedOn;
	}

	public void setOrderedOn(LocalDateTime orderedOn) {
		this.orderedOn = orderedOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
