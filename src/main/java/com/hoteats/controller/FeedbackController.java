package com.hoteats.controller;

import java.util.List;

import com.hoteats.common.review.Feedback;

public interface FeedbackController {

	Feedback addFeedback(Feedback feedback);

	Feedback updateFeedback(Feedback feedback);

	void deleteFeedback(Feedback feedback);

	Feedback getFeedbackByFeedbackId(Long feedbackId);

	List<Feedback> getFeedbacksByUserId(Long userId);

	List<Feedback> getFeedbacksByItemId(Long itemId);

	List<Feedback> getFeedbacksByRestaurantId(Long restaurantId);

	List<Feedback> getFeedbacksByOrdersId(Long ordersId);

}
