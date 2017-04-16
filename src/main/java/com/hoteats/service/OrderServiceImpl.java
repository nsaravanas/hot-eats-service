package com.hoteats.service;

import java.util.List;

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

	@Override
	@Transactional
	public Orders addOrder(Orders order) {
		return this.repository.save(order);
	}

	@Override
	@Transactional
	public Orders updateOrder(Orders order) {
		return this.repository.save(order);
	}

	@Override
	@Transactional
	public void deleteOrder(Orders order) {
		this.repository.delete(order);
	}

	@Override
	@Transactional
	public void deleteOrder(Long orderId) {
		this.repository.delete(orderId);
	}

	@Override
	@Transactional
	public List<Orders> ordersByUserId(Long userId) {
		return this.repository.ordersByUserId(userId);
	}

}
