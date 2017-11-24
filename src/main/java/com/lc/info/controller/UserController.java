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
import com.lc.info.model.User;
import com.lc.info.service.UserService;
import com.lc.info.vo.UserLoginIdentity;
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("index")
	public String index() {
		return "user";
	}
	
	@RequestMapping("login")
	@ResponseBody
	public ResultInfo login(String userName,String password){
		UserLoginIdentity userLoginIdentity = userService.login(userName, password);
		return success(userLoginIdentity);
	}
	
	@RequestMapping("register")
	@ResponseBody
	public ResultInfo register(String userName,String password,String trueName,String email,String phone){
		userService.register(userName,password,trueName,email,phone);
		return success("注册成功");
	}
	
	@RequestMapping("list")
	@ResponseBody
	public List<User> findAll(String userName){
		Map<String,Object> map = new HashMap<>();
		map = userService.selectForPage(userName);
		return (List<User>) map.get("rows");
	}
	
	@RequestMapping("add")
	@ResponseBody
	public ResultInfo add(String userName,String password,String trueName,String phone,String email){
		userService.insert(userName,password,trueName,phone,email);
		return success("添加成功");
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResultInfo update(Integer id,String userName,String password,String trueName,String phone,String email){
		userService.update(id,userName,password,trueName,phone,email);
		return success("修改成功");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public ResultInfo delete(String ids){
		userService.delete(ids);
		return success("删除成功");
	}
	
}
