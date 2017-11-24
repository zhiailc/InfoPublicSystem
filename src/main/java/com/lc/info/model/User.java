package com.lc.info.model;

import com.lc.info.base.BaseModel;

public class User extends BaseModel {
	private String userName;
	private String password;
	private String trueName;
	private String email;
	private String phone;

	public User() {
		super();
	}

	public User(String userName, String password, String trueName, String email, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.trueName = trueName;
		this.email = email;
		this.phone = phone;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
