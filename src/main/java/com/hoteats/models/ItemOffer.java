package com.hoteats.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hoteats.models.audit.AuditInfo;
import com.hoteats.models.enums.OfferType;

@Entity
public class ItemOffer extends AuditInfo {

	@Id
	private Long itemOfferId;

	@JsonBackReference
	@ManyToOne
	private Item item;

	@Column
	private LocalDateTime offerFrom;

	@Column
	private LocalDateTime offerTill;

	@Column
	private BigDecimal offerPercentage;

	@Column
	private BigDecimal flatDiscount;

	@Column
	@Enumerated(EnumType.STRING)
	private OfferType offerType;

	public OfferType getOfferType() {
		return offerType;
	}

	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}

	public Long getItemOfferId() {
		return itemOfferId;
	}

	public void setItemOfferId(Long itemOfferId) {
		this.itemOfferId = itemOfferId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public LocalDateTime getOfferFrom() {
		return offerFrom;
	}

	public void setOfferFrom(LocalDateTime offerFrom) {
		this.offerFrom = offerFrom;
	}

	public LocalDateTime getOfferTill() {
		return offerTill;
	}

	public void setOfferTill(LocalDateTime offerTill) {
		this.offerTill = offerTill;
	}

	public BigDecimal getOfferPercentage() {
		return offerPercentage;
	}

	public void setOfferPercentage(BigDecimal offerPercentage) {
		this.offerPercentage = offerPercentage;
	}

	public BigDecimal getFlatDiscount() {
		return flatDiscount;
	}

	public void setFlatDiscount(BigDecimal flatDiscount) {
		this.flatDiscount = flatDiscount;
	}

}
