package com.hoteats.models;

import com.hoteats.models.enums.LoginStatus;

public class LoginResponse {

	private Long userId = -1L;
	private String userame;
	private String name;
	private LoginStatus status = LoginStatus.FAILED;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserame() {
		return userame;
	}

	public void setUserame(String userame) {
		this.userame = userame;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LoginStatus getStatus() {
		return status;
	}

	public void setStatus(LoginStatus status) {
		this.status = status;
	}

}
