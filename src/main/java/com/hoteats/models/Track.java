package com.hoteats.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Track {

	@Id
	@GeneratedValue
	private Long trackId;

	@Column
	private String bikeNo;

	@Column
	private String boxId;

	@Column
	private LocalDate registrationDate;

	@JsonManagedReference
	@OneToMany(mappedBy = "track", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TimeCoorinate> timeCoorinates;

	@ManyToOne
	private Orders order;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
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

	public String getBikeNo() {
		return bikeNo;
	}

	public void setBikeNo(String bikeNo) {
		this.bikeNo = bikeNo;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

}
