package com.hoteats.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hoteats.common.review.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

	Feedback getFeedbackById(Long feedbackId);

	@Query("from RestaurantFeedback where restaurant.restaurantId = ?1")
	List<Feedback> getFeedbacksByRestaurantId(Long restaurantId);

	@Query("from OrdersFeedback where orders.orderId = ?1")
	List<Feedback> getFeedbacksByOrdersId(Long ordersId);

	@Query("from ItemFeedback where item.itemId = ?1")
	List<Feedback> getFeedbacksByItemId(Long itemId);

	@Query("from Feedback where user.userId = ?1")
	List<Feedback> getFeedbacksByUserId(Long userId);

}
