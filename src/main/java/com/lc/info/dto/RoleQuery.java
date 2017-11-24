package com.lc.info.dto;

import com.lc.info.base.BaseQuery;

public class RoleQuery extends BaseQuery {
	private String roleName;
	private String roleRemark;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleRemark() {
		return roleRemark;
	}
	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}
	
}
