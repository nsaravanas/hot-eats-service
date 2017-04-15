package com.hoteats.service;

import com.hoteats.models.Order;

public interface OrderService {

	Order getOrderById(Long orderId);

	Order saveOrder(Order testOrder);

}
