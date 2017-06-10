package com.hoteats.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteats.models.Orders;
import com.hoteats.models.enums.Status;
import com.hoteats.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;

	@Override
	public Orders getOrderById(Long orderId) {
		return this.repository.findOne(orderId);
	}

	@Override
	public Orders saveOrder(Orders order) {
		return this.repository.save(order);
	}

	@Override
	public Orders addOrder(Orders order) {
		return this.repository.save(order);
	}

	@Override
	public Orders updateOrder(Orders order) {
		return this.repository.save(order);
	}

	@Override
	public void deleteOrder(Orders order) {
		this.repository.delete(order);
	}

	@Override
	public void deleteOrder(Long orderId) {
		this.repository.delete(orderId);
	}

	@Override
	public List<Orders> ordersByUserId(Long userId) {
		return this.repository.ordersByUserId(userId);
	}

	@Override
	public Integer updateOrderStatus(Long orderId, Status status, String updatedBy) {
		return this.repository.updateOrderStatus(orderId, status, updatedBy, LocalDateTime.now());
	}

	@Override
	public List<Orders> getAllUnprocessedEatOrders() {
		return this.repository.getAllUnprocessedEatOrders();
	}

	@Override
	public List<Orders> getOrderByStatus(Status status) {
		return this.repository.getOrdersByStatus(status);
	}

}
