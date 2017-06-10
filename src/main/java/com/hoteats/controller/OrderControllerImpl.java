package com.hoteats.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoteats.commons.CommonStubs;
import com.hoteats.models.Orders;
import com.hoteats.models.enums.Status;
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
	@RequestMapping(value = "/order/add", method = RequestMethod.POST)
	public Orders addOrder(@RequestBody Orders order) {
		order.setOrderedOn(LocalDateTime.now());
		return this.service.addOrder(order);
	}

	@Override
	@RequestMapping(value = "/order/update", method = RequestMethod.PUT)
	public Orders updateOrder(@RequestBody Orders order) {
		order.setUpdatedOn(LocalDateTime.now());
		return this.service.updateOrder(order);
	}

	@Override
	@RequestMapping(value = "/order/delete", method = RequestMethod.DELETE)
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

	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public Orders testAddOrder() {
		return CommonStubs.testOrder();
	}

	@Override
	@RequestMapping(value = "/order/unprocessed", method = RequestMethod.GET)
	public List<Orders> getUnprocessedOrders() {
		return this.service.getOrderByStatus(Status.PLACED);
	}

	@Override
	@RequestMapping(value = "/eats/unprocessed", method = RequestMethod.GET)
	public List<Orders> getEatOrders() {
		return this.service.getAllUnprocessedEatOrders();
	}

	@Override
	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateOrderStatus(@PathVariable Long orderId, @RequestParam Status status,
			@RequestParam String updatedBy) {
		Map<String, Object> map = new LinkedHashMap<>();
		Orders o = this.service.getOrderById(orderId);
		if (o == null) {
			map.put("error", "orderId " + orderId + " not found.");
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
		o.setStatus(status);
		o.setUpdatedBy(updatedBy);
		Orders ro = this.updateOrder(o);
		return new ResponseEntity<>(ro, HttpStatus.OK);
	}

}
