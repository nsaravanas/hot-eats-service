package com.hoteats.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hoteats.models.Orders;
import com.hoteats.models.enums.Status;

public interface OrderController {

	Orders getOrderById(Long orderId);

	Orders addOrder(Orders order);

	Orders updateOrder(Orders order);

	void deleteOrder(Orders order);

	void deleteOrder(Long orderId);

	List<Orders> ordersByUserId(Long userId);

	List<Orders> getEatOrders();

	ResponseEntity<?> updateOrderStatus(Long orderId, Status status, String updatedBy);

	List<Orders> getUnprocessedOrders();

}
