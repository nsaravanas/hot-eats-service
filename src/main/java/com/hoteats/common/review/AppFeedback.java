package com.hoteats.common.review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "FEEDBACK_APP")
@Entity
public class AppFeedback extends Feedback {

	@Column
	private String feedbacks;

	public String getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(String feedbacks) {
		this.feedbacks = feedbacks;
	}

}
