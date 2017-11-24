package com.lc.info.service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.info.dao.UserDao;
import com.lc.info.exception.ParamException;
import com.lc.info.model.User;
import com.lc.info.utils.AssertUtil;
import com.lc.info.utils.MD5Util;
import com.lc.info.utils.UserIDBase64;
import com.lc.info.vo.UserLoginIdentity;



@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public UserLoginIdentity login(String userName,String password){
		AssertUtil.isNotEmpty(userName, "用户名不能为空");
		AssertUtil.isNotEmpty(password, "密码不能为空");
		User user  = userDao.findByUserName(userName.trim());
		AssertUtil.isNotEmpty(user, "用户名或密码错误");
		String md5Pwd = MD5Util.md5Method(password);
		if(!md5Pwd.equals(user.getPassword())){
			throw new ParamException("用户名或密码错误");
		}
		UserLoginIdentity userLoginIdentity = buildLoginIndentity(user);
		return userLoginIdentity;
	}


	public void register(String userName, String password, String trueName, String email, String phone) {
		checkParam(userName,password,trueName);
		User user = new User();
		user.setUserName(userName);
		user.setPassword(MD5Util.md5Method(password));
		user.setTrueName(trueName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		user.setIsValid(1);
		userDao.insert(user);
	}
	
	public Map<String, Object> selectForPage(String userName) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<User> list = userDao.queryForPage(userName);
		map.put("rows", list);
		return map;
	}
	
	public void insert(String userName, String password, String trueName, String phone, String email) {
		User user = new User();
		checkParam(userName,password,trueName);
		user.setUserName(userName);
		user.setPassword(MD5Util.md5Method(password));
		user.setTrueName(trueName);
		user.setPhone(phone);
		user.setEmail(email);
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		userDao.insert(user);
	}
	
	public void update(Integer id,String userName, String password, String trueName, String phone, String email) {
		User userFromDB = userDao.findByUserName(userName);
		User user = new User(userName, MD5Util.md5Method(password), trueName, email, phone);
		user.setId(id);
		if(!StringUtils.isNoneBlank(password)){
			user.setPassword(userFromDB.getPassword());
		}
		if(!StringUtils.isNoneBlank(trueName)){
			user.setTrueName(userFromDB.getTrueName());
		}
		if(!StringUtils.isNoneBlank(phone)){
			user.setPhone(userFromDB.getPhone());
		}
		if(!StringUtils.isNoneBlank(email)){
			user.setEmail(userFromDB.getEmail());
		}
		user.setUpdateTime(new Date());
		userDao.update(user);
	}

	public void delete(String ids) {
		AssertUtil.isNotEmpty(ids, "请选择删除的数据");
		userDao.delete(ids);
	}


	private void checkParam(String userName, String password, String trueName) {
		AssertUtil.isNotEmpty(userName, "用户名不能为空");
		AssertUtil.isNotEmpty(password, "密码不能为空");
		AssertUtil.isNotEmpty(trueName, "姓名不能为空");
		User user = userDao.findByUserName(userName);
		if(user != null){
			throw new ParamException("用户名已存在");
		}
	}

	private UserLoginIdentity buildLoginIndentity(User user) {
		UserLoginIdentity userLoginIdentity = new UserLoginIdentity();
		userLoginIdentity.setUserIdStr(UserIDBase64.encoderUserID(user.getId()));
		userLoginIdentity.setTrueName(user.getTrueName());
		userLoginIdentity.setUserName(user.getUserName());
		return userLoginIdentity;
		
	}


}
