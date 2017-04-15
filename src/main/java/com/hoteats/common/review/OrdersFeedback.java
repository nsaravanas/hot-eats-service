package com.hoteats.common.review;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hoteats.models.Orders;

@Entity
@Table(name = "FEEDBACK_ORDER")
public class OrdersFeedback extends Feedback {

	@ManyToOne
	private Orders orders;

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}
