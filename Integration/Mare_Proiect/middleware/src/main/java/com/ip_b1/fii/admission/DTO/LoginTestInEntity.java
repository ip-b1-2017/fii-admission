package com.ip_b1.fii.admission.DTO;

public class LoginTestInEntity {
	private String username;
	private String password;

	public LoginTestInEntity(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public LoginTestInEntity() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
