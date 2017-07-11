package com.hoteats.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.hoteats.models.enums.ModeOfPay;

@Embeddable
public class OrderPrice {

	@Column
	private Double totalAmount;

	@Column
	private Double amountPaid;

	@Enumerated(EnumType.STRING)
	private ModeOfPay modeOfPay;

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public ModeOfPay getModeOfPay() {
		return modeOfPay;
	}

	public void setModeOfPay(ModeOfPay modeOfPay) {
		this.modeOfPay = modeOfPay;
	}

}
