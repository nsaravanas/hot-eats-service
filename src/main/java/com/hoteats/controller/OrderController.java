package com.hoteats.controller;

import java.util.List;

import com.hoteats.models.Orders;

public interface OrderController {

	Orders getOrderById(Long orderId);

	Orders addOrder(Orders order);

	Orders updateOrder(Orders order);

	void deleteOrder(Orders order);

	void deleteOrder(Long orderId);

	List<Orders> ordersByUserId(Long userId);

}
