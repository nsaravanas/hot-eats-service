package com.hoteats.service;

import java.util.List;

import com.hoteats.models.Orders;

public interface OrderService {

	Orders getOrderById(Long orderId);

	Orders saveOrder(Orders testOrder);

	Orders addOrder(Orders order);

	Orders updateOrder(Orders order);

	void deleteOrder(Orders order);

	void deleteOrder(Long orderId);

	List<Orders> ordersByUserId(Long userId);

}
