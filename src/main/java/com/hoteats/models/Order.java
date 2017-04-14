package com.hoteats.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hoteats.models.Delivery;
import com.hoteats.models.OrderItem;
import com.hoteats.models.OrderPrice;
import com.hoteats.models.User;
import com.hoteats.models.audit.AuditInfo;
import com.hoteats.models.enums.Status;

@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
public class Order extends AuditInfo {

	@Id
	private Long orderId;

	@ManyToOne
	private User user;

	@JsonManagedReference
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;

	@Column
	private LocalDateTime orderedOn;

	@Column
	private LocalDateTime updatedOn;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Column
	private LocalDateTime deliveryTime;

	@Embedded
	private OrderPrice orderPrice;

	@JsonManagedReference
	@OneToOne
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

	public LocalDateTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalDateTime deliveryTime) {
		this.deliveryTime = deliveryTime;
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

}
