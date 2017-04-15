package com.hoteats.controller;

import com.hoteats.common.review.Feedback;

public interface FeedbackController {

	Feedback addFeedback(Feedback feedback);

	Feedback updateFeedback(Feedback feedback);

	void deleteFeedback(Feedback feedback);

}
