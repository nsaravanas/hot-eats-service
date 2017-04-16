package com.hoteats.common.review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "FEEDBACK_APP")
@Entity
public class AppFeedback extends Feedback {

	@Column
	private String feedbacks;

	@Column
	private String feature;

	public String getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(String feedbacks) {
		this.feedbacks = feedbacks;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

}
