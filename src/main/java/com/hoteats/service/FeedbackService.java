package com.hoteats.service;

import java.util.List;

import com.hoteats.common.review.Feedback;

public interface FeedbackService {

	List<Feedback> addFeedbacks(List<Feedback> feedbacks);

	Feedback addFeedback(Feedback feedback);

	Feedback updateFeedback(Feedback feedback);

	void deleteFeedback(Feedback feedback);

	Feedback getFeedbackByFeedbackId(Long feedbackId);

	List<Feedback> getFeedbacksByRestaurantId(Long restaurantId);

	List<Feedback> getFeedbacksByOrdersId(Long ordersId);

	List<Feedback> getFeedbacksByItemId(Long itemId);

	List<Feedback> getFeedbacksByUserId(Long userId);

}
