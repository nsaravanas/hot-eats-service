package com.hoteats.common.review;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hoteats.models.Item;

@Entity
@Table(name = "FEEDBACK_ITEM")
public class ItemFeedback extends Feedback {

	@ManyToOne
	private Item item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
