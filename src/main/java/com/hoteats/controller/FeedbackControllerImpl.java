package com.hoteats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoteats.common.review.Feedback;
import com.hoteats.commons.CommonStubs;
import com.hoteats.service.FeedbackService;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackControllerImpl implements FeedbackController {

	@Autowired
	private FeedbackService service;

	@Override
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		return this.service.addFeedback(feedback);
	}

	@Override
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		return this.service.updateFeedback(feedback);
	}

	@Override
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteFeedback(@RequestBody Feedback feedback) {
		this.service.deleteFeedback(feedback);
	}

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public List<Feedback> feedbacks() {
		return this.service.addFeedbacks(CommonStubs.sampleFeedbacks());
	}

	@Override
	@RequestMapping(value = "/feedback/{feedbackId}", method = RequestMethod.GET)
	public Feedback getFeedbackByFeedbackId(@PathVariable Long feedbackId) {
		return this.service.getFeedbackByFeedbackId(feedbackId);
	}

	@Override
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public List<Feedback> getFeedbacksByUserId(@PathVariable Long userId) {
		return this.service.getFeedbacksByUserId(userId);
	}

	@Override
	@RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
	public List<Feedback> getFeedbacksByItemId(@PathVariable Long itemId) {
		return this.service.getFeedbacksByItemId(itemId);
	}

	@Override
	@RequestMapping(value = "/restaurant/{restaurantId}", method = RequestMethod.GET)
	public List<Feedback> getFeedbacksByRestaurantId(@PathVariable Long restaurantId) {
		return this.service.getFeedbacksByRestaurantId(restaurantId);
	}

	@Override
	@RequestMapping(value = "/orders/{ordersId}", method = RequestMethod.GET)
	public List<Feedback> getFeedbacksByOrdersId(@PathVariable Long ordersId) {
		return this.service.getFeedbacksByOrdersId(ordersId);
	}
}
