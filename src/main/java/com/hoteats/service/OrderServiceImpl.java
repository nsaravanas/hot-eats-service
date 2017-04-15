package com.hoteats.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteats.models.Orders;
import com.hoteats.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;

	@Override
	@Transactional
	public Orders getOrderById(Long orderId) {
		return this.repository.findOne(orderId);
	}

	@Override
	@Transactional
	public Orders saveOrder(Orders order) {
		return this.repository.save(order);
	}

}
