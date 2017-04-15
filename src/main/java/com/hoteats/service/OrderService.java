package com.hoteats.service;

import com.hoteats.models.Orders;

public interface OrderService {

	Orders getOrderById(Long orderId);

	Orders saveOrder(Orders testOrder);

}
