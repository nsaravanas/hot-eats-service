package com.hoteats.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hoteats.models.enums.UserStatus;

@Entity
public class UserInfo {

	@Id
	@GeneratedValue
	private Long userInfoId;

	@JoinColumn(name = "userId", nullable = false)
	@JsonBackReference
	@ManyToOne
	private User user;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String mobileNo;

	@Column
	private String emailId;

	@Column
	private LocalDateTime userSince;

	// @JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<UserAddress> userAddress;

	@Column
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDateTime getUserSince() {
		return userSince;
	}

	public void setUserSince(LocalDateTime userSince) {
		this.userSince = userSince;
	}

	public List<UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
