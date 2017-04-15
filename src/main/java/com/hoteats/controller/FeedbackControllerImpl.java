package com.hoteats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoteats.common.review.Feedback;
import com.hoteats.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
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

}
