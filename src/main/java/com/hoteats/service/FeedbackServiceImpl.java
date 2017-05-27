package com.hoteats.service;

import java.util.List;

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

	@Override
	@Transactional
	public Feedback getFeedbackByFeedbackId(Long feedbackId) {
		return this.repository.getFeedbackById(feedbackId);
	}

	@Override
	@Transactional
	public List<Feedback> getFeedbacksByRestaurantId(Long restaurantId) {
		return this.repository.getFeedbacksByRestaurantId(restaurantId);
	}

	@Override
	@Transactional
	public List<Feedback> getFeedbacksByOrdersId(Long ordersId) {
		return this.repository.getFeedbacksByOrdersId(ordersId);
	}

	@Override
	@Transactional
	public List<Feedback> getFeedbacksByItemId(Long itemId) {
		return this.repository.getFeedbacksByItemId(itemId);
	}

	@Override
	@Transactional
	public List<Feedback> getFeedbacksByUserId(Long userId) {
		return this.repository.getFeedbacksByUserId(userId);
	}

	@Override
	@Transactional
	public List<Feedback> addFeedbacks(List<Feedback> feedbacks) {
		return this.repository.save(feedbacks);
	}

}
