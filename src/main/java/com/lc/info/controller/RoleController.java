package com.lc.info.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lc.info.base.BaseController;
import com.lc.info.base.ResultInfo;
import com.lc.info.dto.RoleQuery;
import com.lc.info.model.Role;
import com.lc.info.service.RoleService;
@Controller
@RequestMapping("role")
public class RoleController extends BaseController{
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("index")
	public String index() {
		return "role";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public List<Role> list(RoleQuery query){
		Map<String,Object> map = new HashMap<>();
		map = roleService.selectForPage(query);
		return (List<Role>) map.get("rows");
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ResultInfo add(Role role) {
		roleService.add(role);
		return success("添加成功");
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResultInfo update(Role role) {
		roleService.update(role);
		return success("修改成功");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public ResultInfo delete(String ids) {
		roleService.delete(ids);
		return success("删除成功");
	}
}
