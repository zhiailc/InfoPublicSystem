package com.lc.info.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserLoginIdentity implements Serializable {
	private String userIdStr;
	private String userName;
	private String trueName;
	
	public String getUserIdStr() {
		return userIdStr;
	}
	public void setUserIdStr(String userIdStr) {
		this.userIdStr = userIdStr;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
}
