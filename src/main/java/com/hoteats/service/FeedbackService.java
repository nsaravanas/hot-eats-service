package com.hoteats.service;

import com.hoteats.common.review.Feedback;

public interface FeedbackService {

	Feedback addFeedback(Feedback feedback);

	Feedback updateFeedback(Feedback feedback);

	void deleteFeedback(Feedback feedback);

}
