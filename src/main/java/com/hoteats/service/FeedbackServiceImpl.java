package com.hoteats.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteats.common.review.Feedback;
import com.hoteats.controller.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository repository;

	@Override
	@Transactional
	public Feedback addFeedback(Feedback feedback) {
		return this.repository.save(feedback);
	}

	@Override
	@Transactional
	public Feedback updateFeedback(Feedback feedback) {
		return this.repository.save(feedback);
	}

	@Override
	@Transactional
	public void deleteFeedback(Feedback feedback) {
		this.repository.delete(feedback);
	}

}
