package com.hoteats.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hoteats.models.Delivery;
import com.hoteats.models.TimeCoorinate;

@Entity
public class Track {

	@Id
	private Long trackId;

	@JsonManagedReference
	@OneToMany(mappedBy = "track")
	private List<TimeCoorinate> timeCoorinates;

	@JsonBackReference
	@ManyToOne
	private Delivery delivery;

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Long getTrackId() {
		return trackId;
	}

	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

	public List<TimeCoorinate> getTimeCoorinates() {
		return timeCoorinates;
	}

	public void setTimeCoorinates(List<TimeCoorinate> timeCoorinates) {
		this.timeCoorinates = timeCoorinates;
	}

}
