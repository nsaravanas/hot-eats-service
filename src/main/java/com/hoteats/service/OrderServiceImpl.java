package com.hoteats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteats.models.Order;
import com.hoteats.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;

	@Override
	public Order getOrderById(Long orderId) {
		return this.repository.findOne(orderId);
	}

	@Override
	public Order saveOrder(Order order) {
		return this.repository.save(order);
	}

}
