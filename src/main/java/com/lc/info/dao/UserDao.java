package com.lc.info.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lc.info.model.User;

public interface UserDao {
	User findByUserName(@Param(value = "userName")String userName);

	void insert(User user);

	void update(User user);

	void delete(@Param(value = "ids")String ids);
	
	List<User> queryForPage(@Param(value = "userName")String userName);
}
