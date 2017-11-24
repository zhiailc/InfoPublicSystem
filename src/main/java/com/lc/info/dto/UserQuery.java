package com.lc.info.dto;

import com.lc.info.base.BaseQuery;

public class UserQuery extends BaseQuery{
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
