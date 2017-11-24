package com.lc.info.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lc.info.dto.RoleQuery;
import com.lc.info.model.Role;

public interface RoleDao {

	List<Role> selectForPage(RoleQuery query);
	
	@Select("select id,role_name,role_remark,create_time,update_time,is_valid "
			+ " from t_role where role_name = #{roleName}")
	Role findByRoleName(@Param(value = "roleName")String roleName);

	void insert(Role role);

	void update(Role role);

	void delete(@Param(value = "ids")String ids);

}
