package com.hoteats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/sampleorder", method = RequestMethod.GET)
	public Orders testOrder() {
		return CommonStubs.testOrder();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Orders addOrder() {
		return this.service.saveOrder(CommonStubs.testOrder());
	}
}
