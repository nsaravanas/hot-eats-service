package com.hoteats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoteats.commons.CommonStubs;
import com.hoteats.models.Orders;
import com.hoteats.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderControllerImpl implements OrderController {

	@Autowired
	private OrderService service;

	@Override
	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
	public Orders getOrderById(@PathVariable Long orderId) {
		return this.service.getOrderById(orderId);
	}

	@Override
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public Orders addOrder(@RequestBody Orders order) {
		return this.service.addOrder(order);
	}

	@Override
	@RequestMapping(value = "/order", method = RequestMethod.PUT)
	public Orders updateOrder(@RequestBody Orders order) {
		return this.service.updateOrder(order);
	}

	@Override
	@RequestMapping(value = "/order", method = RequestMethod.DELETE)
	public void deleteOrder(@RequestBody Orders order) {
		this.service.deleteOrder(order);
	}

	@Override
	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.DELETE)
	public void deleteOrder(@PathVariable Long orderId) {
		this.service.deleteOrder(orderId);
	}

	@Override
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public List<Orders> ordersByUserId(@PathVariable Long userId) {
		return this.service.ordersByUserId(userId);
	}

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Orders testOrder() {
		return this.service.addOrder(CommonStubs.testOrder());
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Orders testAddOrder() {
		return this.service.saveOrder(CommonStubs.testOrder());
	}
}
