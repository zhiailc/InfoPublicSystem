package com.lc.info.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.info.dao.RoleDao;
import com.lc.info.dto.RoleQuery;
import com.lc.info.exception.ParamException;
import com.lc.info.model.Role;
import com.lc.info.utils.AssertUtil;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;


	public Map<String, Object> selectForPage(RoleQuery query) {
		Map<String,Object> map = new HashMap<>();
		List<Role> list = roleDao.selectForPage(query);
		map.put("rows", list);
		return map;
	}

	public void add(Role role) {
		AssertUtil.isNotEmpty(role.getRoleName(), "角色名不能为空");
		AssertUtil.isNotEmpty(role.getRoleRemark(), "角色描述不能为空");
		Role roleFromDB = roleDao.findByRoleName(role.getRoleName());
		if(roleFromDB != null) {
			throw new ParamException("角色名已存在");
		}
		role.setCreateTime(new Date());
		role.setUpdateTime(new Date());
		roleDao.insert(role);
	}

	public void update(Role role) {
		role.setUpdateTime(new Date());
		roleDao.update(role);
	}

	public void delete(String ids) {
		roleDao.delete(ids);
	}
}
